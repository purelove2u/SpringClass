package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	//게시판과 관련된 기능 등록
	boolean insertBoard(BoardVO vo);
	boolean updateBoard(BoardVO vo);
	boolean deleteBoard(int bno);
	BoardVO getBoard(int bno);
	List<BoardVO> getList();
}








