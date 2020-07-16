package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AuthVO;
import com.spring.domain.ChangeVO;
import com.spring.domain.LoginVO;
import com.spring.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/member/*")
@Controller
@Slf4j
public class MemberController {

	@Autowired
	private MemberService service;
	
	//로그인 
	@GetMapping("/login")
	public void loginGet() {
		log.info("로그인 폼 보여주기");
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String loginPost(LoginVO login,HttpSession session) {
		//login.jsp에서 넘긴 값 가져오기
		log.info("로그인 요청 "+login);
		//로그인 확인 => 성공시 index.jsp / 실패 로그인페이지
		AuthVO auth = service.login(login);
		if(auth!=null) {
			//세션에 값 담기
			session.setAttribute("auth", auth);
			return "redirect:/";
		}else{
			return "/member/login";
		}
	}
	
	//로그아웃 => 세션 해제 후 인덱스 페이지 보여주기
	@GetMapping("/logout")  //  http://localhost:8080/member/logout
	public String logout(HttpSession session) {
		log.info("로그아웃");
		//세션에 있는 모든 정보 삭제
		session.invalidate();
		//세션에 있는 특정한 정보 삭제
		//session.removeAttribute("auth");
		return "redirect:/";		
	}
	
	//비밀번호 변경 폼을 보여주는 컨트롤러 생성
	// jsp => /member/changePwd
	@GetMapping("/changePwd")
	public void changPwd() {
		log.info("비밀번호 변경 폼 보여주기");
	}
	
	//비밀번호 변경 요청 처리 컨트롤러 생성
//	@PostMapping("/changePwd")
//	public String changePwdPost(ChangeVO change,HttpSession session,RedirectAttributes rttr) {
//		log.info("비밀번호 변경 "+change);	
//		//① userid 알아내기
//		AuthVO auth = (AuthVO)session.getAttribute("auth");
//		//② userid와 일치하는 비밀번호 추출
//		String current_password = service.getPwd(auth.getUserid());
//		//③ 사용자가 입력한 현재 비밀번호와 일치하는지 확인
//		if(current_password.equals(change.getPassword())) {
//			//일치한다면 수정작업 시작
//			//new_password와 confirm_password가 일치하는지 확인
//			if(change.newPasswordEqualsConfirm()) {
//				//userid 담아주기
//				change.setUserid(auth.getUserid());
//				if(service.updatePwd(change)) {
//					//수정작업이 성공하면 세션해제 후 로그인 페이지로 이동
//					session.removeAttribute("auth");
//					rttr.addFlashAttribute("info", "비밀번호변경이 성공했습니다.다시 로그인해 주세요");
//					return "redirect:/";
//				}
//			}else { //두개의 비밀번호가 일치하지 않을 때 changePwd
//				rttr.addFlashAttribute("error", "두 개의 비밀번호가 일치하지 않습니다.");
//				return "redirect:/member/changePwd";
//			}
//		}else { //현재 비밀번호가 일치하지 않을 때 changePwd
//			rttr.addFlashAttribute("error", "현재 비밀번호를 확인해 주세요");
//			return "redirect:/member/changePwd";
//		}
//		return "redirect:/";
//	}	
	
	//회원탈퇴 버튼을 클릭시 leave 보여주기
	@GetMapping("/leave")
	public void leaveForm() {
		log.info("회원탈퇴 폼 요청");
	}
	
//	//회원탈퇴
//	@PostMapping("/leave")
//	public String leave(String userid,String current_password,HttpSession session) {
//		log.info("탈퇴 요청...");
//		log.info("userid : "+userid);
//		log.info("current_password : "+current_password);
//		
//		//userid와 일치하는 비밀번호 추출
//		String password = service.getPwd(userid);
//		
//		if(password.equals(current_password)) {
//			//일치한다면 삭제작업 시작
//			if(service.delete(userid)) {
//			//삭제가 성공하면 세션 해제 인덱스 페이지로 이동
//				session.removeAttribute("auth");
//				return "redirect:/";
//			}else {
//			//삭제 실패시 leave 페이지 보여주기
//				return "redirect:/member/leave";
//			}
//		}
//		return "redirect:/";
//	}
	
	

	@DeleteMapping("/leave")
	@ResponseBody
	public ResponseEntity<String> leaveDelete(@RequestBody LoginVO vo,
						HttpSession session) {
		log.info("회원탈퇴" + vo);		
		//userid와 일치하는 비밀번호 추출
		String password = service.getPwd(vo.getUserid());
		
		if(password.equals(vo.getPassword())) {
			//일치한다면 삭제작업 시작
			if(service.delete(vo.getUserid())) {				
				session.removeAttribute("auth");	
				return new ResponseEntity<String>("success",HttpStatus.OK);					
			}
		}		
		return new ResponseEntity<String>("fail",HttpStatus.BAD_REQUEST); 		
	}
	
	
	@PutMapping("/changePwd")
	@ResponseBody
	public ResponseEntity<String> changePwdPost(@RequestBody ChangeVO change,
			HttpSession session) {
		log.info("비밀번호 변경 "+change);	
		//① userid 알아내기
		AuthVO auth = (AuthVO)session.getAttribute("auth");
		//② userid와 일치하는 비밀번호 추출
		String current_password = service.getPwd(auth.getUserid());
		//③ 사용자가 입력한 현재 비밀번호와 일치하는지 확인
		if(current_password.equals(change.getPassword())) {
			//일치한다면 수정작업 시작
			//new_password와 confirm_password가 일치하는지 확인
			if(change.newPasswordEqualsConfirm()) {
				//userid 담아주기
				change.setUserid(auth.getUserid());
				if(service.updatePwd(change)) {
					//수정작업이 성공하면 세션해제 후 로그인 페이지로 이동
					session.removeAttribute("auth");					
					return new ResponseEntity<String>("success",HttpStatus.OK);
				}
			}else { //두개의 비밀번호가 일치하지 않을 때 changePwd				
				return new ResponseEntity<String>("not equal",HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<String>("error",HttpStatus.BAD_REQUEST);
	}	
}





















