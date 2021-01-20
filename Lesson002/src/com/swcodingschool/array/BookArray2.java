package com.swcodingschool.array;

public class BookArray2 {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		
		library[0] = new Book("a", "b");
		library[1] = new Book("c", "d");
		library[2] = new Book("e", "f");
		library[3] = new Book("g", "h");
		library[4] = new Book("i", "j");

		for(int i = 0; i < library.length; i++) {
			library[i].showBookInfo();
		}
		
		for(int i = 0; i < library.length; i++) {
			System.out.println(library[i]);
		}	
	}
}
