package com.swcodingschool.oop2;

public class Student2 {
	
	int name;
	int height;
	double weight;
	char gender;
	boolean married;
	
	Student2(){
		System.out.println("실행중입니다");
	}
	
	Student2(int name, int height, double weight, char gender, boolean married) {
		System.out.println("동작하였습니다");
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.married = married;
	}
	
	
	
	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public void study() {
		System.out.println(name + "이(가) 게임을 한다");
	}
	
	public void showStudent2Info() {
		System.out.println(name + "," + gender); //이름, 성별 출력
	}
	
	
}
