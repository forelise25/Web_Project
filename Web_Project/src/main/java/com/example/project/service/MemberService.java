package com.example.project.service;

import java.util.List;

import com.example.project.model.dto.MemberVO;

public interface MemberService {
	//ȸ�����
	public List<MemberVO> memberList();
	//ȸ�� �Է�
	public void insertMember(MemberVO vo);
	//ȸ���󼼺���
	public MemberVO viewMember(String userId);
	//ȸ������
	public void deleteMember(String userId);
	//ȸ������
	public void updateMember(MemberVO vo);
	
	public boolean checkPw(String userId, String userPw);
}
