package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config.xml");
		Product product = (Product) ctx.getBean("product");
		product.setCompany("LEGO");
		product.setPname("LEGO 블럭");
		product.setPrice("1000000");
		product.getInfo();
		ctx.close();		
	}
}
