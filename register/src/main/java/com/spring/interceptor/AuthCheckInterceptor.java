package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.domain.AuthVO;

@Component
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// http://localhost:8080/member/changePwd 로 요청이 들어오면
		// 로그인 세션이 존재하면
		// changePwd 작업을 진행할 수 있도록 해주고
		// 세션값이 없다면 로그인 페이지로 돌려보내기
		HttpSession session = request.getSession(false);
		if(session!=null) {
			AuthVO auth = (AuthVO) session.getAttribute("auth");
			if(auth!=null) {
				return true;
			}
		}		
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}
}















