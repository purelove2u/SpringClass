package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BookVO;
import com.spring.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {	
	@Autowired
	private BookService service;
	
	@GetMapping(value= {"/insert","/delete","/modify"})
	public String handleGet() {
		log.info("부적절한 요청");
		return "redirect:/";
	}
	
	
	
	//도서목록보기 클릭시 동작하는 컨트롤러 생성	
	@GetMapping("/select")
	public String selectAll(Model model) {
		log.info("도서 목록 요청");
		//전체 도서목록을 가져온 후 모델에 담고
		List<BookVO> list =service.getList();
		model.addAttribute("list", list);
		//페이지 이동
		return "book_selectAll";
	}
	
	//도서목록추가
	//book_insert에서 도서정보 가져오기
	//DB작업하고
	//입력성공시 도서목록 보여주기
	//입력실패시 index
	@PostMapping("/insert")
	public String insertPost(BookVO vo, RedirectAttributes rttr) {
		log.info("도서 정보 입력 : "+vo);
		try {
			if(service.insert(vo)) {
				return "redirect:select";
			}else{
				rttr.addFlashAttribute("tab", "insert");
				return "redirect:/";
			}			
		} catch (Exception e) {		
			rttr.addFlashAttribute("tab", "insert");
			return "redirect:/"; 
		}
	}
	
	//도서목록 삭제
	@PostMapping("/delete")
	public String deletePost(String code,RedirectAttributes rttr) {
		log.info("도서목록삭제:"+code);
		if(service.delete(code)) {
			return "redirect:select";
		}else {
			rttr.addFlashAttribute("tab", "delete");
			return "redirect:/"; //
		}
	}
	
	//도서목록 수정
	@PostMapping("/modify")
	public String updatePost(String code,int price,RedirectAttributes rttr) {
		log.info("도서 정보 수정 "+code+" 가격 : "+price);
		if(service.modify(code, price)) {
			return "redirect:select";
		}else {
			rttr.addFlashAttribute("tab", "modify");
			return "redirect:/";
		}
	}
	
	//도서정보검색
	//성공후 book_searchAll
	//실패는 인덱스
	@PostMapping("/search")
	public String searchPost(String criteria,String keyword,Model model,RedirectAttributes rttr) {
		log.info("검색 요청 "+criteria+" 검색어 : "+keyword);
		
		List<BookVO> list = service.getSearchList(criteria, keyword);
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
			return "book_searchAll";
		}else {
			rttr.addFlashAttribute("msg", "검색결과없음");
			rttr.addFlashAttribute("tab", "search");
			return "redirect:/";
		}
	}
	
	@GetMapping("/search")
	public String searchGet(RedirectAttributes rttr) {
		log.info("검색 폼 요청");
		rttr.addFlashAttribute("tab", "search");
		return "redirect:/";
	}
}















