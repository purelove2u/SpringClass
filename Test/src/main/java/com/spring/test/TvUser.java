package com.spring.test;

public class TVUser {
	public static void main(String[] args) {
//		LgTV lg = new LgTV();
//		lg.turnOn();
//		lg.soundUp();
//		lg.soundDown();
//		lg.turnOff();
		
		//TV tv = new LgTV(new SonySpeaker());
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(new SonySpeaker());
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}





