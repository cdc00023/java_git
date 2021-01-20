package com.swcodingschool.oop;

public class QuizStaticStore {
	int guestCount;
	int storeMoney;

	private static QuizStaticStore instance = new QuizStaticStore();

	private QuizStaticStore() {
	}

	public static QuizStaticStore getInstance() {
		if (instance == null) {
			instance = new QuizStaticStore();
		}
		return instance;
	}

	public void take(int storeMoney) {
		this.storeMoney += storeMoney;
		this.guestCount++;
	}

	public void takeOffStore() {
		this.guestCount--;
	}

	public void showInfo() {
		System.out.println("현재 매장에 있는 손님의 수는 " + guestCount + "명 이고, 매장의 수입금액은 " + storeMoney + "원 입니다.");
	}// end of showInfo

}// end of class
