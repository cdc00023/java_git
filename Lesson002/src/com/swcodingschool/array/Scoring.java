package com.swcodingschool.array;
/* 1/5
 * 2차원 배열의 예제, 학생 3명의 국,영,수 과목의
 * 총점과 평균을 구하여 출력하는 프로그램을 구성하시오.
 * 
 * 접근순서... pseudo Code -------Algorithm
 * 1. 배열 double[3][5]score선언
 * 2. 학생성적은 어떤방법으로? 
 * ->사용자로 부터 입력받는다
 *   for loop 행 {
 *      for loop 열 {
 *        각 학생의 국/영/수 과목을 입력 받는다.
 *      }
 *    }
 * 3. for loop 행 {
 *      for loop 열 {
 *        개인별 총점과 평균을 계산
 *        총점=score[i][3]
 *      } 
 *      평균=총점/3
 *    }
 * 4. 다중 for loop이용, 배열 전체를 출력받는다.   
 */
public class Scoring {

	public static void main(String[] args) {
//		double[][] score = new double[2][5] {		
//		for(double i=0; i < score.length; i++) {
//			for(double j = 0; j < double[i].length; j++) {
//				System.out.println(score[i][j]);
//			}
//	    	System.out.println( );
//		}
//		System.out.println(score.length);
//		System.out.println(score[0].length);

		double[][] score = new double[][] {
			{40,70,65}, {80,99,75}, {48,50,90}
			};
			
		System.out.println("국영수 총점 = ");
		
		for(double i=0; i < score.length; i++) {
			double sum=0;
			System.out.println(" " + (i + 1) + " ");
		}
		for(double j=0; j < score.length; j++) {
//			sum += score[i][j];
//			System.out.println(score[i][j] + " "); //점수출력
//		}
//		
//		System.out.println("국영수 평균 = ");
//		System.out.println(sum + " " + sum/score[i].length);
//		//평균값
//		

		
		
		
		
		
		
		
		}		

	}//end of main

}//end of class
