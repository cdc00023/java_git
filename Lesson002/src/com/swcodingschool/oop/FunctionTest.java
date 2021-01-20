package com.swcodingschool.oop;
/*
 * 함수의 정의와 호출을 디버깅을 통해 확인한다.
 * 변수의 영향 범위 scope
 * local varoable 지역변수
 * global variable 전역변수(~=class variable 클래스변수)
 * class변수 선언시 앞에 static 키워드를 사용한다.
 * 인스턴스화 되지 않더라도 사용할수 있는 메서드에 보통 static키워드 사용
 * 
 */
public class FunctionTest {
	
	static int global = 0; //add, 메인변수와 무관하게 만듬

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		global++;
		System.out.println("in main : " + global);
		
		int sum = add(num1, num2);
		System.out.println(sum);

	}//end of main

	public static int add(int n1, int n2) {
		global++;
		System.out.println("in main" + global);
		
		return n1 + n2;
		
	
	}
}//end of class
