package com.swcodingschool.oop;

public class QuizStaticGuest {
	public int guestID;
	public int guestName;
	public int guestMoney;
	public int guestCount;
	public int storeMoney;
	
	public static int sirialNum = 100;
	public static int getserialNum() {
		return sirialNum;
	}
	

	public QuizStaticGuest(int guestID, int guestMoney, String guestName) {
		this.guestID = sirialNum++;
		this.guestMoney = guestMoney;
	}
	

	public void takeStore(QuizStaticStore store) {
		store.take(1000);
		this.guestCount++;
	}//end of takeStore()
	
	public void takeMoney(int guestMoney) {
		this.guestMoney -= 1000;
		this.guestMoney += guestMoney;
	}//end of take
	
	public void takeOffStore(QuizStaticStore store) {
		this.guestCount--;
	}//end of takeOffStore


	public void showInfo() {
		System.out.println(guestID + "님의 남은 돈은" + guestMoney
				+ "원 이고, 매장의 수입은 " + storeMoney + "원 입니다");
		
	}//end of showInfo
	
	
	
	
}//end of class
