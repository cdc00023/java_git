package com.swcodingschool.realoop;

public class VIPCustomer extends Customer {
	protected int agentID;
	double saleRatio;
	
	public VIPCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		System.out.println("VIPCustomer 생성자 동작...");
	}
	
	@Override
	protected int calcPrice(int price) {
		// 
		// return super.calcPrice(price);
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	}

	public int getAgentID() {
		return agentID;
	}
	
}
