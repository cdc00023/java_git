package com.swcodingschool.oop;

public class CarCompanyTest {
	public static void main(String[] args) {
    CarCompany hyundai = CarCompany.getInstance();
	hyundai.showInfo();
	
	CarFactory cheonju = new CarFactory("청주");
	cheonju.probuceCar(1000);
	cheonju.showInfo();
	hyundai.showInfo();
	
	CarCompany usahyundai = CarCompany.getInstance();
	CarFactory usa = new CarFactory("미국");
	usa.probuceCar(500);
	usahyundai.showInfo();
	
	}
}
