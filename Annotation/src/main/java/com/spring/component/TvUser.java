package com.spring.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {
	public static void main(String[] args) {
		
		System.out.println("IoC 컨테이너 구동 전");
		
		// 스프링 컨테이너 구동하기 -> 설정파일 읽기
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config3.xml");
		System.out.println("컨테이너 구동 후");
		
		// LookUp  : 스프링 컨테이너로부터 필요한 객체를 요청
		TV tv = (TV)ctx.getBean("tv");	
		// component로 객체 생성할 때 클래스 이름으로 생성 (앞 첫글자를 소문자로 변경)
		// @Component("tv") 로 객체 생성을 하게 되면 이름까지
		// 지정이 가능. 따라서 정해준 이름으로 객체를 찾아올 수 있게 됨
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}	
}
