package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;

//@Component("dao")
@Repository
public class BoardDAO {
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getconConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "javadb";
		String password = "12345";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 게시글 등록
	public int insertArticle(BoardVO vo) {
		String sql = "insert into spring_board(bno, title, content, writer) "
				+ "values(seq_board.nextVal,?,?,?)";
		int result = 0;
		try (Connection con = getconConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
