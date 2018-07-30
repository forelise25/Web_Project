package com.example.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.project.model.dto.BoardVO;
import com.example.project.service.BoardPager;
import com.example.project.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService boardService;
	/*01. 게시글 목록 보기(검색기능전)
	@RequestMapping("list.do")
	public ModelAndView list() {
		List<BoardVO> list = boardService.listAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/list");
		mav.addObject("list",list);
		return mav;
	}
	*/
	/*
	//01-1. 게시글 목록(검색 기능 추가)
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword) {  
		List<BoardVO> list = boardService.listAll(searchOption, keyword);
		int count = boardService.countArticle(searchOption, keyword);
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list",list);
		map.put("count",count);
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		mav.addObject("map", map);
		mav.setViewName("board/list");
		return mav;
	}
	*/
	//01-2. 게시글 목록(페이징 추가)
		@RequestMapping("list.do")
		public ModelAndView list(@RequestParam(defaultValue="title")String searchOption, 
				@RequestParam(defaultValue="")String keyword, 
				@RequestParam(defaultValue="1")int curPage) {
			int count = boardService.countArticle(searchOption, keyword);
			
			BoardPager boardPager = new BoardPager(count, curPage);
			int start = boardPager.getPageBegin();
			int end = boardPager.getPageEnd();
			
			
			
			List<BoardVO> list = boardService.listAll(start, end, searchOption, keyword);
			
			
			ModelAndView mav = new ModelAndView();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list",list);
			map.put("count",count);
			map.put("searchOption",searchOption);
			map.put("keyword",keyword);
			map.put("boardPager", boardPager);
			mav.addObject("map", map);
			mav.setViewName("board/list");
			return mav;
		}
	
	//02. 게시글 작성
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}
	
	//02-01. 게시글 작성 처리 화면
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute BoardVO vo, HttpSession session) {
		String writer = (String)session.getAttribute("userId");
		vo.setWriter(writer);
		vo.setUserName((String)session.getAttribute("userName"));
		boardService.create(vo);
		return "redirect:list.do";
	}
	
	//03. 게시글 상세 조회
	@RequestMapping("view.do")
	public ModelAndView view(@RequestParam int bno) {
		boardService.increaseViewcnt(bno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("dto",boardService.read(bno));
		mav.addObject("dtoUserName","");
		return mav;
	}
	
	//04. 수정
	@RequestMapping("update.do")
	public String update(@ModelAttribute BoardVO vo) {
		boardService.update(vo);
		return "redirect:list.do";
	}
	
	//05. 삭제
	@RequestMapping("delete.do")
	public String delete(@RequestParam int bno) {
		boardService.delete(bno);
		return "redirect:list.do";
	}
}
