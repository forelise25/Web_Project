package com.example.project.model.dao;

import java.util.List;

import com.example.project.model.dto.MemberVO;

public interface MemberDAO {
	//ȸ�� ��� ��ȸ
	public List<MemberVO> memberList();
	//ȸ�� �Է�
	public void insertMember(MemberVO vo);
	//ȸ�� ����
	public void deleteMember(String userId);
	//ȸ�� ����
	public void updateMember(MemberVO vo);
	//ȸ�� ���� �� ����
	public MemberVO viewMember(String userId);
}
