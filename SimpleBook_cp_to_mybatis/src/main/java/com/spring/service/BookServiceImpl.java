package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.BookVO;
import com.spring.mapper.BookMapper;

@Service("book")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper mapper;

	@Override
	public List<BookVO> getList() {
		return mapper.getList();
	}
	@Override
	public BookVO getBook(String code) {
		return mapper.getBook(code);
	}
	@Override
	public int insert(BookVO vo) {
		return mapper.insertBook(vo);
	}
	@Override
	public int update(BookVO vo) {
		return mapper.updateBook(vo);
	}
	@Override
	public int delete(String code) {
		return mapper.deleteBook(code);
	}
	
}
