package com.spring.stu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {
//		StudentInfo info = new StudentInfo(new Student("hong", "15", "3"));
//		info.getStudentInfo();
		
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("config2.xml");
		
		StudentInfo info = (StudentInfo)ctx.getBean("info");
		info.getStudentInfo();
		
	}
}



