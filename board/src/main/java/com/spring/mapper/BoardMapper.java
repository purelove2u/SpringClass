package com.spring.mapper;

import java.util.List;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> list(Criteria cri);
	public int total();
	public int insert(BoardVO vo);
	public BoardVO read(int bno);
	public int update(BoardVO vo);
	public int delete(int bno);
}
