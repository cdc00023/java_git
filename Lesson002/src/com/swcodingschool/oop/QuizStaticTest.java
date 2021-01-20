package com.swcodingschool.oop;
/*
 * 매장이 하나 있다.
 * 이 매장과 거래하는 손님들이 있다.
 * 매장은 싱글톤패턴으로 구현함 
 * 다수의 손님들이 물건을 구매함
 * 이를 객체지향 프로그래밍으로 시뮬레이션 해보자.
 * 손님 : 손님ID, 손님의 money
 * 매장 : 손님의 숫자, 매장의 money
 */
public class QuizStaticTest {		
	
	public static void main(String[] args) {
		QuizStaticStore store1 = QuizStaticStore.getInstance();
		QuizStaticStore store2 = QuizStaticStore.getInstance();
		System.out.println(store1 == store2);
		
//		QuizStaticGuest gtJames = new QuizStaticGuest("철수1", 10000);
//		QuizStaticGuest gtTomas = new QuizStaticGuest("철수2", 20000);
//		Store QuizStaticStore = new Store();
//		//손님, 가게
		
//		gtJames.showInfo();
//		gtJames.takeStore(store1);
//		//손님이 들어옴
//		
//		gtJames.takeMoney(store1);
//		//손님이 물건을 삼
//		
//		gtJames.takeOffStore(store1);
//		//손님이 나감
//		
//		gtJames.showInfo();
//		
		//손님의 돈과 가게의 돈을 확인
	}

}//end of class QuizStatic
