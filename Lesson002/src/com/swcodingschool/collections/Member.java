package com.swcodingschool.collections;
/*
 * Collection Framework의 이해와 활용
 * ArrayList에서 사용할 기본 클래스
 */
public class Member {
	private int memberID;
	private String memberName;
	
	public Member(int memberID, String memberName) {
		this.memberID = memberID;
		this.memberName = memberName;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return memberName + "회원님의 아이디는" 
				+ memberName + "입니다.";
	}

}//end of class
