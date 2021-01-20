package com.swcodingschool.realoop;
/*
 * 인터페이스 : 추상메서드와 상수로만 구성
 * 직접 인스턴스를 생성할 수 없다.
 */
public interface Calc {
	//Member Property : 상수로만 구성된다.
	//변수만드는것과 같지만, 
	//내부적으로 컴파일 과정에서 final상수로 변환처리가 된다
	double PI = 3.14;
	int ERROR = -9999;
	
	//Methods : abstract methods로만 구성
	//컴파일 과정에서 abstract상수로 변환처리가 된다
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int tims(int num1, int num2);
	int divide(int num1, int num2);
	
}
