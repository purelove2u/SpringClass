package com.spring.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonVO;
import com.spring.service.PersonService;

public class PersonClient {
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("config.xml");
		PersonService person = (PersonService)ctx.getBean("person");
		
		//person.insertPerson("kim","김철수");
		//System.out.println(person.selectPerson("kim"));
		
		//업데이트
		PersonVO vo = new PersonVO();
		vo.setId("hong123");
		vo.setName("소지섭");
		if(person.update(vo)) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("업데이트 실패");
		}
		
		//삭제
		person.delete("kang11");		
		List<PersonVO> list = person.getList();
		for(PersonVO vo1:list) {
			System.out.println(vo1);
		}
	}
}















