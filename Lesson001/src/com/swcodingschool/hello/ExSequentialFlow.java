package com.swcodingschool.hello;

import java.util.Scanner;

/*
 * Convert Fahrenheit to Celsius 
 * or Convert Celsius to Fahrenheit
 * 
 * Tc = (Tf - 32)/1.8
 * Tf = Tc * 1.8 + 32
 */
public class ExSequentialFlow {

	public static void main(String[] args) {
		// 입력 받은 섭씨를 화씨로 변환하기
		Scanner sc = new Scanner(System.in);
		System.out.print("변환하고자 하는 섭씨 온도를 입력하세요 : ");
		double temperatureC = sc.nextDouble();
		double temperatureF = (double)temperatureC * 1.8 + 32;
		System.out.printf("%5.1f Celsus is %5.1f", temperatureC, temperatureF);
		sc.close();
		System.out.println("프로그램을 종료합니다.");
	}// end of main
}//end of class
