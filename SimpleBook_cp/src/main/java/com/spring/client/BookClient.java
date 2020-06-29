package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

public class BookClient {

	public static void main(String[] args) {

		// 컨테이너 구동
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		// Look Up
		BookService service = (BookService) ctx.getBean("book");

		// 도서목록 가져오기
		List<BookVO> list = service.getList();
		for(BookVO vo : list) {
			System.out.println(vo);
		}
		
		// 도서 추가
//		BookVO vo = new BookVO();
//		vo.setCode("a001");
//		vo.setTitle("스프링 연습");
//		vo.setWriter("서명원");
//		vo.setPrice(20000);
//		int result = service.insert(vo);
//		if(result > 0) {
//			System.out.println("입력 성공");
//		}else {
//			System.out.println("입력 실패");
//		}
		
	}

}
