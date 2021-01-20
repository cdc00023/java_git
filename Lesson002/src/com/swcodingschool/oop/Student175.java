package com.swcodingschool.oop;
/*
 * 교재 페이지 175의 예제 클래스
 * 객체간 협력을 통한 객체 지향 프로그래밍 구현방법을
 * 설명한다.
 */
public class Student175 {
	//Member variables
	public String studentName; //학생이름
	public int studentID; //학번
	public int grade; //학년
	public int money; //학생이 소지한 돈
	
	//static 변수 추가와 활용
	public static int sirialNum = 1000;
	
	
	
	//Member Methods
	//학생의 이름과 가진 돈을 인수로 받는 생성자
	public Student175(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
		this.studentID = sirialNum++; //
	}//end of constructor Student175
	
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
		
	}//end of takeBus()
	
	public void takeOffBus(Bus bus) {
		bus.takeOffBus();
	}
	
	public void showInfo() {
		System.out.println(studentID + "번 학생" + studentName + 
				"님의 남은 돈은 " + money + "입니다");
	}//end of showInfo
	
}//end of class student175
