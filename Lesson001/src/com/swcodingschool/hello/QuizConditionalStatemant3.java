package com.swcodingschool.hello;

import java.util.Scanner;

public class QuizConditionalStatemant3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int circleRadius;
		double circleArea;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원의 반지름을 입력하시오");
		circleRadius = sc.nextInt();
		
		circleArea = circleRadius * circleRadius * 3.14;
		
		
		System.out.println("원의 면적은" + circleArea + "입니다.");
		sc.close();
	}

}
