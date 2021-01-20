package com.swcodingschool.hello;
/*
 * Java Basic Input and Output
 * Java output : System.out.println(), ..print(), ..printf()
 * Difference between println(), print() and printf()
   print() - It prints string inside the quotes.
   println() - It prints string inside the quotes similar like print() method. Then the cursor moves to the beginning of the next line.
   printf() - It provides string formatting
   
   refer to  https://www.programiz.com/java-programming/basic-input-output
 */
public class InputAndOutput {

	public static void main(String[] args) {
		//printing variables and literals
		double number = -10.6;
		
		System.out.println(5);
		System.out.println(number);
		
		// print concatenated strings
		System.out.println("와우.. " + "좀 놀랍군...");
		System.out.println("숫자 : " + number);

	} //end of main

}//end of class
