package com.swcodingschool.array;

import java.util.Scanner;

/*
 * 2차원 배열 예제, 학생 3명의 국,영,수 과목의 
 * 총점과 평균을 구하여 출력하는 프로그램을 구성하시오.
 * 접근순서...  Pseudo Code   ===> Algorithm
 * 1. 배열  double[3][5]score선언
 * 2. 학생성적은 어떤 방법?
 *    for loop 행 {
 *      for loop 열 {
 *         각 학생의 국/영/수 과목을 입력 받는다.
 *      }
 *    } 
 *    사용자로부터 입력받는다.
 * 3. for loop 행 {
 *      for loop 열 { 
 *        개인별 총점과 평균을 계산한다.
 *        총점 score[i][3]
 *      } 
 *      평균 총점/3
 *    } 
 * 4. 다중 for loop 이용, 배열 전체를 출력한다.  
 */
public class ScoringT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1. 배열 선언
		double[][] score = new double[3][5];
		
		// 2. 성적을 입력받는다. 
		//    이때 행은 학생별, 열은 국,영,수 과목별점수
		//    반복 횟수 제어를 위해 각 행 열의길이 - 2를 사용
		//    (총점,평균 제외)
		//row행, column열
		for(int row=0;row < score.length;row++) {
			System.out.println((row+1) + "번 째 학생의 성적을 입력해주세요.");
			for(int col=0;col < score[row].length - 2; col++) {
				System.out.printf("%d과목 : %n", col+1);
				score[row][col] = sc.nextDouble();
			}
			System.out.println();
		}// end of 입력용 다중 for loop 
		
		// 3. 개인별 총점과 평균을 계산한다.
		for(int row=0;row < score.length; row++) {
			for(int col=0;col < score[row].length - 2;col++) {
				score[row][3] += score[row][col]; //누계시켜줌
			}
			score[row][4] = score[row][3] / 3.0;
		}// end of 개인별 총점 평균 계산
		
		// 4. 배열 전체를 출력한다.
		System.out.printf("과목1\t과목2\t과목3\t총점\t평균\n");
		for(int row=0;row < score.length;row++) {
			for(int col=0;col < score[row].length;col++) {
				System.out.printf("%5.1f\t",score[row][col]);
			}
			System.out.println();
		}// end of 출력
	}// end of main
}// end of class