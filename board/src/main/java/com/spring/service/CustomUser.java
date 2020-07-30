package com.spring.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.spring.domain.MemberVO;

import lombok.Getter;

// mybatis 를 통해 결과로 나온 값은 MemberVO 에 있음
// MemberVO 인스턴스를 스프링 시큐리티의 UserDetails 타입으로 변환하기

@Getter
public class CustomUser extends User {
	
	private MemberVO member;	

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);		//반드시 필요
	}
	
	public CustomUser(MemberVO member) {
		super(member.getUserid(),member.getUserpw(),member.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.member = member;
	}
}













