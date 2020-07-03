package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.AuthVO;
import com.spring.domain.LoginVO;
import com.spring.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	// 로그인
	@GetMapping("/login")
	public void loginGet() {
		log.info("login 폼 보여주기");
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String loginPost(LoginVO login) {
		//login.jsp에서 넘긴 값 가져오기
		log.info("로그인 요청" + login);
		//로그인 확인 => 성공시 index.jsp / 실패시 로그인페이지
		AuthVO auth = service.login(login);
		if(auth != null) {
			return "redirect:/";
		}else {
			return "/member/login";
		}
	}
}
