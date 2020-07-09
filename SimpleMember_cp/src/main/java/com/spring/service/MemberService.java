package com.spring.service;

import java.util.List;

import com.spring.domain.MemberVO;

public interface MemberService {
	public List<MemberVO> getList();
	public boolean insert(MemberVO vo);
	public boolean update(MemberVO vo);
	public boolean delete(String userid);
	public MemberVO getBook(String userid);
}
