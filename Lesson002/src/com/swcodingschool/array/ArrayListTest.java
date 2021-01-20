package com.swcodingschool.array;

import java.util.ArrayList;

/*
 * ArrayList<> 선언 및 활용 방법
 */
public class ArrayListTest {

	public static void main(String[] args) {
		// ArrayList<> 선언
		ArrayList<Book> library = new ArrayList<Book>();
		
		library.add(new Book("나무", "베르베르"));
		library.add(new Book("개미", "베르베르"));
		library.add(new Book("개미의 날", "베르베르"));
		library.add(new Book("개미 혁명", "베르베르"));
		library.add(new Book("파피용", "베르베르"));
		
		for(int i = 0; i < library.size(); i++) {
			Book book = library.get(i);
			book.showBookInfo();
		
	}

	System.out.println("====================="); //for each구문
	for(Book book : library)
		book.showBookInfo();

	}

}