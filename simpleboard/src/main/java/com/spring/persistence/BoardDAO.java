package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;

//@Component
@Repository
public class BoardDAO {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		String url = "jdbc:oracle:thin:@192.168.0.10:1521:orcl";
		String user="javaDB";
		String password="12345";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	//게시글 등록
	public int insertArticle(BoardVO vo) {
		int result = 0;
		String sql = "insert into spring_board(bno,title,content,writer) ";
		sql+=" values(seq_board.nextVal,?,?,?)";
		try(Connection con = getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//게시글 전체 가져오기
	public List<BoardVO> getList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from spring_board";
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {				
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString("content"));
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








