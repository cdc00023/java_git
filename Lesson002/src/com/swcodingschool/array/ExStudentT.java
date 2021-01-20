package com.swcodingschool.array;
//학생의 SHOW INFO
import java.util.ArrayList;

import javax.security.auth.Subject;

/*
 * 배열 응용 연습문제
 * 학생들이 있다. 학생들은 각각 n개 과목을 수강한다.
 * 과목은 과목명과 점수로 구성되고
 * 학생은 학번, 이름, 수강과목목록으로 구성한다.
 * 학생의 교과목별 점수와 총점을 출력하도록 프로그래밍하시오.
 * 
 * 작업 클래스 : ExStudent, ExSubject, ExStudentTest
 */
/*
 * Student Class
 * Member Property : ID, Name, SubjectList 
 * Method : constructor(), showStudentInfo()
 *          addSubject()
 */
public class ExStudentT {
	int studentID;
	String studentName;
	ArrayList<ExSubjectT> subjectList;
	
	public ExStudentT(int studentID, String studentName){
		this.studentID = studentID;
		this.studentName = studentName;
		subjectList = new ArrayList<ExSubjectT>();
	}
	
	public void addSubject(String subjectName, int subjectScore) {
		ExSubjectT subject = new ExSubjectT(subjectName, subjectScore);
		subjectList.add(subject);//생성자에 다이렉트로 적어줌
	}//리스트에 추가
	
	public void showStudentInfo() {
		int total = 0;
		for(ExSubjectT s : subjectList) {
			total += s.getSubjectScore();
			System.out.println(studentName + ", " 
			           + s.getSubjectName() + " 교과 점수 :"
			           + s.getSubjectScore());
		}
		System.out.println(studentName + " 총점 " 
				       + total);
		System.out.println("-------------------");
	}
}//end of class