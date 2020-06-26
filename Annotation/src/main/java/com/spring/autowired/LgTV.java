package com.spring.autowired;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LgTV implements TV{
	
	//@Autowired
	@Inject
	@Qualifier("samsung")
	private Speaker speaker;
			
	public LgTV() {
		super();		
	}	
	@Override
	public void powerOn() {
		System.out.println("LGTV - 전원 On");		
	}
	@Override
	public void powerOff() {
		System.out.println("LGTV - 전원 Off");		
	}
	@Override
	public void volumeUp() {
		//System.out.println("LGTV - 볼륨 Up");	
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		//System.out.println("LGTV - 볼륨 Down");	
		speaker.volumeDown();
	}
}
