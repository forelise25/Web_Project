package com.example.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.model.dto.MemberVO;
import com.example.project.service.MemberService;

@Controller
public class MemberController {
	// MemberService ��ü�� ���������� �����Ͽ� ���Խ�����
	@Inject
	MemberService memberService;
	
	//1. ȸ�� ��� ���� - url pattern mapping
	@RequestMapping("member/list.do") //�� do�� ���ص� �ȴ�.
	public String memberList(Model model) {
		//controller -> service -> dao ȣ��(��û)
		List<MemberVO> list = memberService.memberList();
		model.addAttribute("list", list);
		//�ڵ�
		return "member/member_list";
	}
	//2. ȸ�� ���(ȭ��) ������
	@RequestMapping("member/write.do")
	public String memberWrite() {
		return "member/member_write";
	}
	//2.1 ȸ�� ��� �� �� ó���ϴ� ���
	@RequestMapping("member/insert.do")
	public String memberInsert(@ModelAttribute MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:/member/list.do";
	}
	
	//03. 회원 정보 상세 보기
	@RequestMapping("member/view.do")
	public String memberView(String userId, Model model) {
		model.addAttribute("dto",memberService.viewMember(userId));
		return "member/member_view";
	}
	//04.회원 정보 수정 처리
	
	@RequestMapping("member/update.do")
	public String memberUpdate(@ModelAttribute MemberVO vo, Model model) {
		boolean result=memberService.checkPw(vo.getUserId(), vo.getUserPw());
		if(result) {
			memberService.updateMember(vo);
			return "redirect:/member/list.do";
		}else {
			MemberVO vo2 = memberService.viewMember(vo.getUserId());
			vo.setUserRegdate(vo2.getUserRegdate());
			vo.setUserUpdatedate(vo2.getUserUpdatedate());
			model.addAttribute("dto", vo);
			model.addAttribute("message","비밀번호불일치");
			return "member/member_view";
		}
	}
	
	//05. 회원정보 삭제
	@RequestMapping("member/delete.do")
	public String memberDelete(@RequestParam String userId, @RequestParam String userPw, Model model) {
		boolean result=memberService.checkPw(userId, userPw);
		if(result) {
			memberService.deleteMember(userId);
			return "redirect:/member/list.do";
		}else {
			model.addAttribute("dto", memberService.viewMember(userId));
			model.addAttribute("message","비밀번호불일치");
			return "member/member_view";
		}
	}
	
	
}
