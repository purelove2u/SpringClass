package com.spring.basic;

public class TvUser {
	public static void main(String[] args) {
//		LgTV lg = new LgTV();
//		lg.turnOn();
//		lg.soundUp();
//		lg.soundDown();
//		lg.turnOff();
		
//		TV samsung = new LgTV(new SonySpeaker());
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(new SonySpeaker());
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}	
}
