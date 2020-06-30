package com.spring.service;

import java.util.List;

import com.spring.domain.BoardVO;

public interface BoardService {
	//게시판과 관련된 기능 등록
	int insertBoard(BoardVO vo);
	List<BoardVO> getList();
	BoardVO getBoard(int bno);
	int updateBoard(BoardVO vo);
	int deleteBoard(int bno);
}
