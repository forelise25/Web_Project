package com.example.project.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.project.model.dao.BoardDAO;
import com.example.project.model.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardDAO boardDao;
	
	@Override
	public void create(BoardVO vo) {
		// TODO Auto-generated method stub
		String title = vo.getTitle();
		String content = vo.getContent();
		String writer = vo.getWriter();
		String userName = vo.getUserName();
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setUserName(userName);
		
		boardDao.create(vo);
	}

	@Override
	public BoardVO read(int bno) {
		// TODO Auto-generated method stub
		return boardDao.read(bno);
	}

	@Override
	public void update(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDao.update(vo);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		boardDao.delete(bno);
	}
	
	//게시글 전체 목록 보기 
	@Override
	public List<BoardVO> listAll(int start, int end, String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return boardDao.listAll(start, end, searchOption, keyword);
	}
	
	@Override
	public void increaseViewcnt(int bno) {
		// TODO Auto-generated method stub
		boardDao.increaseViewcnt(bno);
	}

	@Override
	public int countArticle(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		return boardDao.countArticle(searchOption, keyword);

	
	
	
	
	
	
	
	
	
	}
	

}
