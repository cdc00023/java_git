package com.swcodingschool.hello;

public class QuizConditionalStatemant2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("구구단");
		int i = 0;
		int j = 0;
		
		for(i = 2; i < 10; i++) {
			for(j = 1; j < 10; j++) {
				System.out.print(i + "x" + j + " = " + i*j);
			}
			System.out.println();
		}
	}

}
