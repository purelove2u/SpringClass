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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;

//@Component("dao")
@Repository
public class BoardDAO {
	@Autowired
	private DataSource ds;
	
	// 게시글 등록
	public int insertArticle(BoardVO vo) {
		String sql = "insert into spring_board(bno, title, content, writer) "
				+ "values(seq_board.nextVal,?,?,?)";
		int result = 0;
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			con.setAutoCommit(false);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				con.commit();
			}
		} catch (Exception e) {
			//con.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 게시글 전체 가져오기
	public List<BoardVO> getList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from spring_board";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setRegdate(rs.getDate(5));
				vo.setUpdatedate(rs.getDate(6));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	 
}

