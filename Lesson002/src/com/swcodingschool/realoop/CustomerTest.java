package com.swcodingschool.realoop;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer customerLee = new Customer();
		customerLee.setCustomerName("이순신");
		customerLee.setCustomerID(10010);
		customerLee.setBonusPoint(1000);
		
		VIPCustomer customerKim = new VIPCustomer();
		customerKim.setCustomerName("김유신");
		customerKim.setCustomerID(10020);
		customerKim.setBonusPoint(10000);
		
		System.out.println(customerLee.showCustomerInfo());
		System.out.println(customerKim.showCustomerInfo());
		
		System.out.println("Lee의 지불 금액 : " + customerLee.calcPrice(10000));
		System.out.println("Kim의 지불 금액 : " + customerKim.calcPrice(10000));
		
		System.out.println(customerLee.showCustomerInfo());
		System.out.println(customerKim.showCustomerInfo());
		
		
		
	}//end of test

}//end of class
