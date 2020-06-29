package com.spring.domain;

import java.util.List;

public interface MemberService {
	public List<MemberVO> getList();
	public boolean insert(MemberVO vo);
	public boolean update(MemberVO vo);
	public boolean delete(String userid);
	public boolean getMember(String userid);
}
