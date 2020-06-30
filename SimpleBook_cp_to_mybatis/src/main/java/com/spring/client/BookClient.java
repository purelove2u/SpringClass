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

		
		// 도서 추가
//		BookVO vo = new BookVO();
//		vo.setCode("a002");
//		vo.setTitle("마이바티스 연습");
//		vo.setWriter("서명원");
//		vo.setPrice(30000);
//		int result = service.insert(vo);
//		if(result > 0) {
//			System.out.println("입력 성공");
//		}else {
//			System.out.println("입력 실패");
//		}

		// update
//		BookVO vo = new BookVO();
//		vo.setCode("a002");
//		vo.setTitle("마이바티스 수정 연습");
//		vo.setWriter("서명원님");
//		vo.setPrice(14000);
//		int result = service.update(vo);
//		if(result > 0) {
//			System.out.println("수정 성공");
//		}else {
//			System.out.println("수정 실패");
//		}


		// delete
//		int result = service.delete("1005");
//		if(result > 0) {
//			System.out.println("삭제 성공");
//		}else {
//			System.out.println("삭제 실패");
//		}
		
		// 책 찾아오기
		System.out.println(service.getBook("a002"));

//		// 도서목록 가져오기
//		List<BookVO> list = service.getList();
//		for(BookVO vo2 : list) {
//			System.out.println(vo2);
//		}
	}

}
