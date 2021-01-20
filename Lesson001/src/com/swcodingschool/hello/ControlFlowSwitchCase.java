package com.swcodingschool.hello;

import java.util.Random;
import java.util.Scanner;

/*
 * Control Flow - Switch Case Statement
 * switch(expression) {
 *   case value1 : statements; break;
 *   case value2 : statements; break;
 *   default: statements;
 * }
 */
public class ControlFlowSwitchCase {

	public static void main(String[] args) {
		// 필요한 변수 선언
		String winner = "";//Referece Datetype
		Random  rd = new Random();    // random number
		int comGame = rd.nextInt(2)+1; // 0~2사이의 수 생성 + 1 : 1~3사이의 수 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.println("★★★ 컴퓨터와 가위 바위 보 게임 ★★★");
		System.out.println("가위 1, 바위 2, 보 3");
		int usrGame = sc.nextInt();
		
		
		switch(usrGame) {
		case 1: // 사용자가 가위를 냈을 때
			if(comGame == 1) winner = "비김";
			else if(comGame == 2) winner = "컴퓨터";
			else winner = "너~ 님";
			break;
		case 2: // 사용자가 바위를 냈을 때
			if(comGame == 2) winner = "비김";
			else if(comGame == 3) winner = "컴퓨터";
			else winner = "너~ 님";
			break;
		case 3: // 사용자가 보를 냈을 때
			if(comGame == 3) winner = "비김";
			else if(comGame == 1) winner = "컴퓨터";
			else winner = "너~ 님";
			break;
		default:
			System.out.println("1(가위) 2(바위) 3(보) 중에 하나를 선택하세요.");
		}// end of switch
		System.out.println("컴퓨터는 " + comGame + " : " + winner + " 승~!!");
		sc.close();
	}// end of main
}// end of class
