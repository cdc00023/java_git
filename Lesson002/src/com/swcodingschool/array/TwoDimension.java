package com.swcodingschool.array;
//이차원 배열 초기화하기 p220

// 자료형  배열이름         행 개수  열 개수
//  int[][]  arr = new int    [2]      [3]

public class TwoDimension {

	public static void main(String[] args) {
		
		int[][] arr = {{1, 2, 3}, {4, 5, 6}};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
			System.out.println( ); //행 출력 끝난 후 한 줄 띄움
		}
	}

}
