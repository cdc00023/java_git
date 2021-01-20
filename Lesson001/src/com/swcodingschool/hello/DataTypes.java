package com.swcodingschool.hello;
/* 
 * Variable :
 * A variable provides us with named storage that our programs can manipulate. 
 * Each variable in Java has a specific type, which determines the size and 
 * layout of the variable's memory; the range of values that can be stored 
 * within that memory; and the set of operations that can be applied to the 
 * variable. 
 * You must declare all variables before they can be used.
 * 
 * Data Types에 대한 설명
 * Java Data Type은 Primitive Data Types, Reference/Object Data Types
 * 1. Primitive Datatypes
 *           정수형     문자형    실수형   논리형
 *   1 byte    byte                         boolean     
 *   2 byte    short     char
 *   4 byte    int                 float
 *   8 byte    long                double
 *   
 *   byte : 8-bit signed two's complement integer. -128(-2^7) ~ 127(2^7 -1 )
 *   short : 16-bit signed tow's complement integer. -32,768 ~ 32,767
 *   int : 32-bit. -2,147,483,648 ~ 2,147,483,647
 *   long : 64-bit. -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807. 
 *          default value is 0L
 *   float : 32bit. default value is 0.0f
 *   double : 64-bit. 0.0d
 *   boolean : one bit of information
 *   
 * 2. Reference/Object Datatypes
 *    Reference variables are created using defined constructors of the classes. 
 *    They are used to access objects.
 * 
 * 3. Java Literals
 *    A literal is a source code representation of a fixed value. 
 *    They are represented directly in the code without any computation.
 */    
public class DataTypes {

	public static void main(String[] args) {
		// 단계 1. 변수 선언
		//int a, b, c;         // Declares three ints, a, b, and c.
		//int a = 10, b = 10;  // Example of initialization
		//byte B = 22;         // initializes a byte type variable B.
		//double pi = 3.14159; // declares and assigns a value of PI.
		//char ch = 'a';        // the char variable a is initialized with value 'a'
		
		// short integer의 최대수 저장 후 출력
		short shortint = 32767;
		System.out.println(shortint);
		// 최대수에 1 더한 후 출력하기
		shortint++;
		System.out.println(shortint);
		
		
	}// end of main
}// end of class
