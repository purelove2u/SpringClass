package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.persistence.BookDAO;

@Service("book")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO dao;
	
	@Override
	public List<BookVO> getList() {		
		return dao.getList();
	}

	@Override
	public boolean insert(BookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BookVO getBook(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
