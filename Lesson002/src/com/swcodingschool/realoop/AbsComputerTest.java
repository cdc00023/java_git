package com.swcodingschool.realoop;

public class AbsComputerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// AbsComputer c1 = new AbsComputer(); //추상클래스라서 안됨
		AbsComputer c2 =  new AbsDesktop();
		//AbsComputer c3 =  new AbsNotebook(); //추상클래스라서 안됨
		AbsComputer c4 =  new AbsMyNotebook();
		
		c2.display();
		c2.typing();
		
		c4.display();
		c4.typing();
	}

}
