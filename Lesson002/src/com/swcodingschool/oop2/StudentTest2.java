package com.swcodingschool.oop2;

public class StudentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student2 stWatermellon = new Student2();
		Student2 stTomato = new Student2();
		Student2 stApple = new Student2();
		
		System.out.println(stApple);
		System.out.println(stTomato);
		
		stTomato.setHeight(5);
		stTomato.weight = 3;
		
		stApple.showStudent2Info();

	}

}
