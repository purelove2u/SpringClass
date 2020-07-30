package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;
import com.spring.service.PartnerServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PartnerController {
	
	@Autowired //객체 주입
	private PartnerService service;

	@GetMapping("/partner/register")
	public void registerGet() {
		log.info("파트너 정보 입력 폼 요청");
	}
	
	@PostMapping("/partner/register")
	public String registerPost(PartnerVO vo) {
		log.info("파트너 정보 입력 요청"+vo);
		service.insert(vo);
		//return "/exam/test";
		return "redirect:list";
	}
	
	@GetMapping("/partner/list")
	public void list(Model model) {
		log.info("리스트 요청");
		List<PartnerVO> list = service.list();
		model.addAttribute("list", list);
	}
	
	
	
	@GetMapping("/exam/test")  //    WEB-INF/view/exam/test.jsp
	public void test() { 
		log.info("test 요청");
	}
}













