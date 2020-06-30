package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.mapper.BoardMapper;

//@Component("board")
@Service("board")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private  BoardMapper mapper;
	
	@Override
	public int insertBoard(BoardVO vo) {
		return mapper.insertArticle(vo);
	}
	@Override
	public int updateBoard(BoardVO vo) {
		return mapper.updateArticle(vo);
	}
	@Override
	public int deleteBoard(int bno) {
		return mapper.deleteArticle(bno);
	}
	@Override
	public BoardVO getBoard(int bno) {
		return mapper.getArticle(bno);
	}
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

}
