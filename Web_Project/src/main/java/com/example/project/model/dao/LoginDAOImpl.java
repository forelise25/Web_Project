package com.example.project.model.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.project.model.dto.MemberVO;

@Repository
public class LoginDAOImpl implements LoginDAO{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		String name = sqlSession.selectOne("login.loginCheck",vo);
		return (name==null)?false:true;
	}

	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("login.viewMember",vo);
	}
}
