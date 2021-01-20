package com.swcodingschool.hello;

import java.util.Scanner;

/*
 * First Java Program, HelloWorld
 * JDK, eclipse 설치 및 configuration 후 첫 프로그램 동작 확인
 */
public class HelloWorld {

	public static void main(String[] args) {
		// 1단계 : 출력메서드 활용, 간단한 메시지 출력
		System.out.println("Hello, Java.");
		System.out.println("By swcodingschool.com");
		
		// 2단계 : 주석, 라인주석, 블럭주석, javadoc 주석
		// 3단계 : Scanner 클래스 활용, 사용자로 부터 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a number : ");
		int inVar = sc.nextInt();
		System.out.println(inVar);
		sc.close();
		// 4단계 : 자주 사용하는 단축키
		/*=================================================================
		 * sysout 입력 후 Ctrl + Spacebar : 출력문 자동 생성
		 * Ctrl + F11 : 실행
		 * Alt + 방향키(위/아래) : 현재 커서가 있는 줄(블록) 위/아래 이동
		 * Ctrl + Alt + 방향키(위/아래) : 현재 커서 줄 위/아래 복사
		 * Ctrl + D : 현재 커서 줄 삭제
		 * Ctrl + Shift + F : 문단 자동 정렬
		 * Ctrl + Shift + C : 주석 처리
		 * Ctrl + Shif + O : 자동 import
		 * Ctrl + Shift + L : 단축키 확인
		 * ================================================================
		 */

	}//end of main

}//end of class
