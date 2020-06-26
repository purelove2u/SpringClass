package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
//		MessageBean msg = new MessageBean();
		
		// 스프링 컨테이너 구동 -> 설정파일 읽고
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		// look Up : 스플이 컨테이너로부터 필요한 객체를 요청하고
		MessageBean msg = (MessageBean)ctx.getBean("msg");
		
		// 실행
		msg.sayHello("Hong");
	}

}
