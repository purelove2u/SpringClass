package com.spring.domain;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
}
