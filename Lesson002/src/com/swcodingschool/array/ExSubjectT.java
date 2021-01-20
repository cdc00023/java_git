package com.swcodingschool.array;
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
 * Subject Class :
 * Member Property : subjectName, subjectScore
 * Method : setters & getters, constructor
 */
public class ExSubjectT {
	// member property
	private String subjectName;
	private int subjectScore;
	
	// constructor
	public ExSubjectT(String subjectName, int subjectScore) {
		this.subjectName = subjectName;
		this.subjectScore = subjectScore;
	}
	// member methods
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectScore() {
		return subjectScore;
	}
	public void setSubjectScore(int subjectScore) {
		this.subjectScore = subjectScore;
	}
}//end of class