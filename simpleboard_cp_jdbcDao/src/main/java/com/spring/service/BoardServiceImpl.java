package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.domain.BoardVO;
import com.spring.persistence.BoardDAO;

//@Component("board")
@Service("board")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public int insertBoard(BoardVO vo) {		
		return dao.insertArticle(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {		
		return dao.updateArticle(vo);
	}

	@Override
	public int deleteBoard(BoardVO vo) {		
		return dao.deleteArticle(vo);
	}

	@Override
	public BoardVO getBoard(int bno) {		
		return dao.getRow(bno);
	}

	@Override
	public List<BoardVO> getList() {		
		return dao.getList();
	}

}






