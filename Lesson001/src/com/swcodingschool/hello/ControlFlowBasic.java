package com.swcodingschool.hello;
/*
 * 프로그램의 기본 제어 구조 설명
 * 순차제어구조, 조건제어구조, 반복제어구조
 */
public class ControlFlowBasic {

	public static void main(String[] args) {
		// 시간에 따른 일과 진행을 예로 들어 순차구조를 설명한다.
		int time = 6;
		System.out.printf("%d시: 기상%n",time);
		time++;
		System.out.printf("%d시: 아침식사%n",time);
		time++;
		System.out.printf("%d시: 출근%n",time);
		// 9시 - 18시 업무 시간은 반복 구문으로 
		for(time=9;time<18;time++) {
			// 점심 시간은 조건문으로
			if(time == 12) System.out.printf("%d시: 점심%n",time);
			else System.out.printf("%d시: 근무%n",time);
		}
		System.out.printf("%d시: 퇴근%n",time);
		time++;
		System.out.printf("%d시: 저녁식사%n",time);
		time++;
		System.out.printf("%d시: 휴식%n",time);
		time++;
		System.out.printf("%d시: 휴식%n",time);
		time++;
		System.out.printf("%d시: 취침%n",time);
	}//end of main
}//end of class
