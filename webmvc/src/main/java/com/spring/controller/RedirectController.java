package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

//redirect 시켰을 때 값을 담는 방법 2가지

@Slf4j
@Controller
public class RedirectController {

	@GetMapping("/doA")	//http://localhost:8080/doA
	public String doA(RedirectAttributes rttr) {
		log.info("doA 요청");
		
		// RedirectAttributes : 일회성으로 값을 전달하기 위한 용도
		// 파라미터 형식으로 보내기
		// path +="?age=10";
		rttr.addAttribute("age", 10);
		
		// sendRedirect 방식
		return "redirect:/member/login";	//http://localhost:8080/member/login
	}
	
	@GetMapping("/doB")	//http://localhost:8080/doB
	public String doB(RedirectAttributes rttr) {
		log.info("doB 요청");
		rttr.addFlashAttribute("age", 10);	// 세션객체에 담아줌
		return "redirect:/";	// http://localhost:8080/
	}
}
