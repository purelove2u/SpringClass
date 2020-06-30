package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BoardVO;
import com.spring.service.BoardService;

public class BoardClient {
	public static void main(String[] args) {
		//컨테이너 구동
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config.xml");
		//Lookup
		BoardService service = (BoardService) ctx.getBean("board");
		
		//게시글 등록
//		BoardVO vo = new BoardVO();
//		vo.setTitle("스프링 게시판3");
//		vo.setContent("스프링 게시판 연습3");
//		vo.setWriter("현빈");
//		int result=service.insertBoard(vo);
//		if(result>0) {
//			System.out.println("입력성공");
//		}else {
//			System.out.println("입력실패");
//		}
		
		//수정
//		BoardVO vo = new BoardVO();
//		vo.setBno(4);
//		vo.setTitle("스프링 게시판 수정");
//		vo.setContent("게시판 내용 수정");
//		int result=service.updateBoard(vo);
//		if(result>0) {
//			System.out.println("수정성공");
//		}else {
//			System.out.println("수정실패");
//		}
		
		//삭제		
		
			
		//게시글 전체 리스트 가져오기
		List<BoardVO> list = service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
		}
		
		//게시글 하나 가져오기
	}
}









