package com.swcodingschool.array;
//이차원 배열의 길이 출력하기 p221
public class TwoDimension2 {

	public static void main(String[] args) {

		int[][] arr = new int[2][3]; //2행3열
		
		for(int i = 0; i < arr.length; i++) { //행 길이
			for(int j = 0; j < arr[i].length; j++) { //열 길이
				System.out.println(arr[i][j]);
			}
			System.out.println( );
			}
		System.out.println(arr.length);
		System.out.println(arr[0].length);
	}

}
