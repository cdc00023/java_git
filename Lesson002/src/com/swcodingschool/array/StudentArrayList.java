package com.swcodingschool.array;

import java.util.ArrayList;

public class StudentArrayList {

	public static void main(String[] args) {
 //                        객체참조변수      
		ArrayList<Student> Studentlist = new ArrayList<Student>();
		
		Studentlist.add(new Student("이철수", 1001));
		Studentlist.add(new Student("김철수", 1002));
		Studentlist.add(new Student("박철수", 1003));
		Studentlist.add(new Student("홍철수", 1004));
		Studentlist.add(new Student("정철수", 1005));
		
		for(int i = 0; i < Studentlist.size(); i++) {
			Student student = Studentlist.get(i);
			student.showStudentInfo();
		}

		for(Student student : Studentlist) {
			student.showStudentInfo();
		}

	}//end of main

}//end of class
