package com.swcodingschool.array;

public class ArrayTest3 {

	public static void main(String[] args) {
		char[] abc = new char[5];
		char ch = 'A'; //데이터 타입
		
		for(int i = 0; i < abc.length; i++, ch++) {
			abc[i] = ch; //아스키 값으로 각 요소에 저장 
		}
		
		for(int i = 0; i < abc.length; i++) {
			System.out.println(abc[i] + ", " + (int)abc[i]);
		}//글자,숫자로 형변환출력
	}//end of main
}//end of class
