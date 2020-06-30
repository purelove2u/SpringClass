package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

public class BoardClient {
	public static void main(String[] args) {
		// 컨테이너 구동
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		// Look Up
		BoardService service = (BoardService) ctx.getBean("board");
		
		// 게시글 등록
//		BoardVO vo = new BoardVO();
//		vo.setTitle("mybatis");
//		vo.setContent("mybatis test 중입니다.");
//		vo.setWriter("서명원");
//		int result = service.insertBoard(vo);
//		if(result > 0) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}
		
		
		// update
//		BoardVO vo = new BoardVO();
//		vo.setTitle("mybatis수정");
//		vo.setContent("mybatis 수정 test 중입니다.");
//		vo.setWriter("서명원");
//		vo.setBno(41);
//		int result = service.updateBoard(vo);
//		if(result > 0) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}

		
		// delete
//		int result = service.deleteBoard(42);
//		if(result > 0) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}
		
		// 게시글 전체 리스트 가져오기
		List<BoardVO> list = service.getList();
		for(BoardVO vo2 : list) {
			System.out.println(vo2);
		}
	}
}
