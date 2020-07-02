package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginVO;
import com.spring.domain.RegisterVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

//	스프링에서 Request를 매핑시키는 방법
//  @RequestMapping(value="/login",method=RequestMethod.DELETE)
//	@GetMapping("/login")
//	@PostMapping("/login")
//	@PutMapping("/login")  == @PatchMapping("/login")
//	@DeleteMapping("/login")
	
	
	@GetMapping("/login")
	public void login() {
		log.info("login 폼 요청");
	}
	
//	@PostMapping("/login")
//	public void loginPost(HttpServletRequest req){
//		log.info("login 요청");
//		
//		//사용자가 보낸 값 가져오기
//		log.info("userid : " + req.getParameter("userid"));
//		log.info("password : " + req.getParameter("password"));
//	}
	
//	@PostMapping("/login")
//	public void loginPost(@RequestParam("userid") String id, String password){
//		log.info("login 요청");
//		
//		//사용자가 보낸 값 가져오기
//		log.info("userid : " + id);
//		log.info("password : " + password);
//	}
//	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute("vo") LoginVO login){
		log.info("login 요청");
		
		//사용자가 보낸 값 가져오기
		log.info("userid : " + login.getUserid());
		log.info("password : " + login.getPassword());
		
		//logout.jsp 보여주기
		return "member/logout";
	}
	
	
	@RequestMapping("/logout")
	public void logout() {
		log.info("logout 요청");
	}
	
	@RequestMapping("/register")
	public void register() {
		log.info("register 폼 요청");
	}
	
	@PostMapping("/register")
	public void registerPost(RegisterVO vo) {
		log.info("register 요청");
		
		//사용자로부터 정보 가져오기
		log.info("userid : " + vo.getUserid());
		log.info("password : " + vo.getPassword());
		log.info("confirm_password : " + vo.getConfirm_password());
		log.info("mobile : " + vo.getMobile());
	}
	
	
	// update.jsp 보여주는 컨트롤러 생성하기
	@GetMapping("/update")
	public void update() {
		log.info("update 폼 요청");
	}
//	@PostMapping("/update")
//	public void updatePost(String userid, String password, Model model) {
//		log.info("update 요청");
//		model.addAttribute("userid", userid);
//		model.addAttribute("password", password);
//	}

	@PostMapping("/update")
	public void updatePost(@ModelAttribute("userid") String userid, 
			@ModelAttribute("password") String password) {
		log.info("update 요청");
	}
	// @ModelAttribute : 도메인 객체의 이름 지정
	//					Model 의 역할을 함
	
	
	
}





