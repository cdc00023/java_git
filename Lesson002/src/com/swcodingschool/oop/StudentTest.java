package com.swcodingschool.oop;

/*
 *1. 클래스 객체를 만드는(instance화 한다(인스턴스로 만든다)) 방법을 설명한다
 *2. 접근제어자(access modifier)의 개념을 확인한다.
 *3. constructor 생성자의 개념을 확인한다.
 *
 */
public class StudentTest {

	public static void main(String[] args) {
		// Student 클래스의 객체 생성하기
		//생성자는 클래스의 이름과 동일한 메서드를 생성자라고 함
		//특히 패러미터가 없는 생성자를 디폴트 생성자라고 함
		//기본 생성자를 통해 객체가 생성되었을 때
		//메모리 공간 안에서는 무슨일이 생길까?
		Student stYounju = new Student();
		Student stDain = new Student(2, "이다인", 2, "청주시");
		
		System.out.println(stYounju);
		System.out.println(stDain);
		
//		stYounju.studentName = "정윤주";
//		stYounju.grade = 1;
		
		
		
//		stDain.studentName = "이다인";
//		stDain.grade = 2;
		
		stYounju.setStudentID(1);
		stYounju.setStudentName("정윤주");
//		System.out.println(stYounju.getStudentID());
//		System.out.println(stYounju.getStudentName());
		
		stYounju.showInfo();
		stDain.showInfo();
		
//		
//		stYounju.study();
//		stDain.study();
		
	}

}
