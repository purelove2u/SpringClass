package com.spring.mapper;

import java.util.List;

import com.spring.domain.BookVO;

public interface BookMapper {
	public List<BookVO> getList();
	public int insertBook(BookVO vo);
	public BookVO getBook(String code);
	public int updateBook(BookVO vo);
	public int deleteBook(String code);
}
