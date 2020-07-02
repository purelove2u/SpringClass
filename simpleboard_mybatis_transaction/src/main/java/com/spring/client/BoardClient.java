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
		BoardVO vo = new BoardVO();
		vo.setBno(17);
		vo.setTitle("스프링 게시판22");
		vo.setContent("스프링 게시판 연습22");
		vo.setWriter("홍길동2");
		int result=service.insertBoard(vo);
		if(result>0) {
			System.out.println("입력성공");
		}else {
			System.out.println("입력실패");
		}
		
		//게시글 전체 리스트 가져오기
		List<BoardVO> list = service.getList();
		for(BoardVO vo1:list) {
			System.out.println(vo1);
		}
	}
}









