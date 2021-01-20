package com.swcodingschool.oop;
/*
 * static, 객체간 협조 연습 예제
 */
public class CarFactory {
	private String factoryName;
	private int productsCounts;
	
	CarFactory(String factoryName){
		this.factoryName = factoryName;
	}
	
	public void probuceCar(int produceNumber) {
		productsCounts += produceNumber;
		CarCompany.carCompanyProductCounts += produceNumber; //누계
	}
	
	public void showInfo() {
		System.out.println(factoryName + "공장 : " 
				+ "\n현재까지의 생산량 : " + productsCounts);
	}
	

}
