package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.PartnerVO;
import com.spring.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/partner/*")
public class PartnerController {
	@Autowired
	private PartnerService service;

	@GetMapping("/register")
	public void registerGet() {
		log.info("register form 요청");
	}
	
	//글등록하기
	@PostMapping("/register")
	public String registerPost(PartnerVO vo,RedirectAttributes rttr) {
		log.info("글 등록 요청 " +vo);
		if(service.insertBoard(vo)) {
			rttr.addFlashAttribute("result", vo.getBno());
			return "redirect:list";
		}else {
			return "register";
		}
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list 요청");
		
	}
	
	//내용보기
	@GetMapping("/read")
	public void read(int bno,Model model) {
		log.info("내용보기..."+bno);
		
	}	
	
}












