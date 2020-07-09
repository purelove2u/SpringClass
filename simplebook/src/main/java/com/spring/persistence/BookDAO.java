package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.domain.BookVO;

@Repository  
public class BookDAO {

	//드라이버 로드
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	//getConnection()
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
	
	//도서목록 가져오기
	public List<BookVO> getList(){
		List<BookVO> list = new ArrayList<BookVO>();
		
		String sql = "select * from bookTBL";
		try(Connection con=getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();			
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getString("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}











