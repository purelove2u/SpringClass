package com.spring.service;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookService {
	List<BookVO> getList();
	int insert(BookVO vo);
	int update(BookVO vo);
	int delete(String code);
	BookVO getBook(String code);	
}
