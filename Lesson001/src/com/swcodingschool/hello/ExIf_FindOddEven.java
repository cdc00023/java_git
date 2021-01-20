package com.swcodingschool.hello;

import java.util.Scanner;

/*
 * If 구문 연습 예제
 * 임의 숫자를 입력 받아 홀/짝수를 판단해주는 프로그램
 * 
 * 한 걸음 더 : while loop으로 발전시켜 무한 루프로 동작하도록 한다.
 * 0을 입력하면 프로그램이 종료되는 조건을 추가하도록 한다.
 */
public class ExIf_FindOddEven {

	public static void main(String[] args) {
		// 메시지를 주어 임의 수를 입력하도록 안내한다.
		System.out.println("임의 수를 입력하세요 :");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		if(number % 2 == 0) System.out.println("짝수입니다."); 
		else  System.out.println("홀수입니다.");
	}//end of main
}//end of class
