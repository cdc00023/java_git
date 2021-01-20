package com.swcodingschool.hello;

import java.util.Scanner;

public class QuizConditionalStatemant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 필요한 변수 선언
		String studant = "";// Referece Datetype

		Scanner sc = new Scanner(System.in);

		System.out.println("성적계산기");
		System.out.println("성적을 입력하시오");
		int grade = sc.nextInt();

		switch (grade) {
		case 1: case 90:  // 성적이 90 이상일 때
			if (grade >= 90)
				studant = "A";
			else
				studant = " ";
			break;

		case 2: // 성적이 80 이상일 때
			if (grade >= 90)
				studant = "A";
			else
				studant = " ";
			break;

		case 3: // 성적이 70 이상일 때
			if (grade >= 90)
				studant = "C";
			else
				studant = "F";
			break;

		default:
			System.out.println("성적을 입력하세요.");
		}// end of switch
		System.out.println("당신의 성적은 " + studant + "입니다.");
		sc.close();

	}// end of main

}// end of class
