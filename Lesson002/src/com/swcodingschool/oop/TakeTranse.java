package com.swcodingschool.oop;
//학생, 버스 객체간의 협력을 보여주는 프로그램
public class TakeTranse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student175 studentJames = new Student175("제임스", 10000);
		Student175 studentTomas = new Student175("토마스", 20000);
		Bus bus823 = new Bus(823);
		//객체 등록 직후, 아직 버스 타기 전
		
		studentJames.showInfo();
		studentTomas.showInfo();
		bus823.showInfo();
		//버스 탐
		
		studentJames.takeBus(bus823);
		studentTomas.takeBus(bus823);
		//버스 승차 후
		
		studentJames.showInfo();
		studentTomas.showInfo();
		bus823.showInfo();
		
		//버스에서 내림
		studentJames.takeOffBus(bus823);
		
		bus823.showInfo();
	}

}
