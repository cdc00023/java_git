package com.swcodingschool.collections;

public class MemberArrayListTest {

	public static void main(String[] args) {
		MemberArrayList memberArrayList = new MemberArrayList();
		Member member1 = new Member(1001, "이다인");		
		Member member2 = new Member(1002, "홍다인");	
		Member member3 = new Member(1003, "리다인");	
		Member member4 = new Member(1004, "김다인");	
		Member member5 = new Member(1005, "정다인");	
		
		memberArrayList.addMember(member1);		
		memberArrayList.addMember(member2);		
		memberArrayList.addMember(member3);		
		memberArrayList.addMember(member4);		
		memberArrayList.addMember(member5);		
		
		memberArrayList.showAllMember();
		System.out.println("=======================");
		memberArrayList.removeMembber(member3.getMemberID());
		memberArrayList.showAllMember();
		}

	}//end of class


