package com.swcodingschool.oop;
//singlestone design pattern
public class CarCompany {
	
	//step2.
		private static CarCompany instance = new CarCompany();
		public static int carCompanyProductCounts = 0;//총생산개수
	
	//step1. 생성자를 private
	private CarCompany() {
		
	}
	
	
	//step3.
	public static CarCompany getInstance() {
		if(instance == null) {
			instance = new CarCompany();
		}
		return instance;
	}

	//
	public void showInfo() {
		System.out.println("회사 총 생산량 : " + carCompanyProductCounts);
	}
}
