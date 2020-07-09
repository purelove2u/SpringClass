package com.spring.service;

import java.util.List;

import com.spring.domain.PartnerVO;

public interface PartnerService {
	//게시판과 관련된 기능 등록
	boolean insertBoard(PartnerVO vo);
	boolean updateBoard(PartnerVO vo);
	boolean deleteBoard(int bno);
	PartnerVO getBoard(int bno);
	List<PartnerVO> getList();
}








