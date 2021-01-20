package com.swcodingschool.array;

public class ExStudentTestT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExStudentT stDain = new ExStudentT(1001, "이다인");
		ExStudentT stYunju = new ExStudentT(1002, "정윤주");
		ExStudentT stHong = new ExStudentT(1003, "홍의");

		stDain.addSubject("컴퓨터", 100);
		stDain.addSubject("데이터베이스", 95);
		stDain.addSubject("자료구조", 90);

		stYunju.addSubject("생물학기초", 100);
		stYunju.addSubject("데이터베이스", 95);
		
		stHong.addSubject("컴퓨터구조", 100);
		stHong.addSubject("데이터베이스", 95);
		stHong.addSubject("알고리즘", 90);
		stHong.addSubject("프로그래밍언어", 90);
		
		stDain.showStudentInfo();
		stYunju.showStudentInfo();
		stHong.showStudentInfo();
	}
}