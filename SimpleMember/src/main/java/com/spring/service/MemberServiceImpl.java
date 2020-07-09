package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.persistence.MemberDAO;

@Service("member")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public List<MemberVO> getList() {		
		return dao.getList();
	}

	@Override
	public boolean insert(MemberVO vo) {		
		return false;
	}

	@Override
	public boolean update(MemberVO vo) {		
		return false;
	}

	@Override
	public boolean delete(String userid) {		
		return false;
	}

	@Override
	public MemberVO getBook(String userid) {		
		return null;
	}

}
