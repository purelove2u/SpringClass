package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.domain.BookVO;

@Repository  
public class BookDAO extends JdbcDaoSupport{
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	//도서목록 가져오기
	public List<BookVO> getList(){		
		String sql = "select * from bookTBL";
		return getJdbcTemplate().query(sql, new BookRowMapper());
	}
	
	//도서목록 삭제
	public int deleteRow(String code) {
		String sql = "delete from bookTBL where code=?";
		return getJdbcTemplate().update(sql,code);
	}
	
	//도서목록 수정
	public int updateRow(BookVO vo) {
		String sql = "update bookTBL set price=? where code=?";
		return getJdbcTemplate().update(sql,vo.getPrice(),vo.getCode());
	}
	
	//도서목록 입력
	public int insertRow(BookVO vo) {
		String sql = "insert into bookTBL(code,title,writer,price) values(?,?,?,?)";
		return getJdbcTemplate().update(sql,vo.getCode(),vo.getTitle(),vo.getWriter(),vo.getPrice());
	}
	
	//도서목록 하나 가져오기
	public BookVO getRow(String code) {
		String sql = "select * from bookTBL where code=?";
		Object args[]= {code};
		return getJdbcTemplate().queryForObject(sql, args, new BookRowMapper());
	}
}











