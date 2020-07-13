package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.BoardVO;
import com.spring.domain.Criteria;
import com.spring.domain.PageVO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;

	@GetMapping("/register")
	public void registerGet() {
		log.info("register form 요청");
	}
	
	//글등록하기
	@PostMapping("/register")
	public String registerPost(BoardVO vo,RedirectAttributes rttr) {
		log.info("글 등록 요청 " +vo);
		if(service.insertBoard(vo)) {
			rttr.addFlashAttribute("result", vo.getBno());
			return "redirect:list";
		}else {
			return "register";
		}
	}
	
	@GetMapping("/list")
	public void list(Model model,@ModelAttribute("cri") Criteria cri) {
		log.info("list 요청");
		//현재 페이지에 보여줄 게시물
		model.addAttribute("list", service.getList(cri));
		//하단의 페이지나누기와 관련된 정보
		model.addAttribute("pageVO", new PageVO(cri, service.totalRows(cri)));
	}
	
	//내용보기
	@GetMapping(value= {"/read","/modify"})
	public void read(int bno,@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("내용보기..."+bno+"..."+cri);
		BoardVO vo=service.getBoard(bno);
		model.addAttribute("vo", vo);
		//http://localhost:8080/board/read
		//http://localhost:8080/board/modify
	}
	
	//내용수정
	@PostMapping("/modify")
	public String update(BoardVO vo,Criteria cri,RedirectAttributes rttr) {
		log.info("내용 수정...."+vo+"...."+cri);
		if(service.updateBoard(vo)) {
			//rttr.addFlashAttribute("", "");  $
			rttr.addAttribute("bno", vo.getBno()); // read?bno=3
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addFlashAttribute("keyword", cri.getKeyword());
			
			return "redirect:read"; 
		}else {			
			rttr.addAttribute("bno", vo.getBno());
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addFlashAttribute("keyword", cri.getKeyword());
			return "redirect:modify";
		}
	}
	
	//내용삭제
	@PostMapping("/remove")
	public String deletePost(int bno,Criteria cri,RedirectAttributes rttr) {
		log.info("게시글 삭제 "+bno);
		service.deleteBoard(bno);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("result", "success");
		return "redirect:list";
	}	
}












