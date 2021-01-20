package com.swcodingschool.array;
/*
 * 배열의 선언과 활용
 * 배열의 선언 :
 * 1. 타입[] 배열이름 = new 타입[크기]
 * 2. 타입 배열이름[] = new 타입[크기]
 */
public class ArrayTest {

	public static void main(String[] args) {
		//배열 선언과 초기화 방법1
//		int[] number;
//		number = new int[] {1,2,3,4,5,6,7,8,9,10};
//		
//		//배열 선언과 초기화 방법2		
//		int[] number = {1,2,3,4,5,6,7,8,9,10};
		
		//배열 선언과 초기화 방법3		
		int[] number = new int[]{1,2,3,4,5,6,7,8,9,10};
		
	
		for(int i = 0;i < number.length;i++) {
			//number[i] = i+1; //for를가지고 배열 넣어줌
			System.out.printf("3d%", number[i]);
		}
		System.out.println();

	}

}
