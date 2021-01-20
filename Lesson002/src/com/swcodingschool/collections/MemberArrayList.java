package com.swcodingschool.collections;

import java.util.ArrayList;

/*
 * Member class를 ArrayList 형태로 구성
 */
public class MemberArrayList {
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<Member>();
		}
	public void addMember(Member member) {
		arrayList.add(member);
	} //추가함
	
	public void addMember(int idx, Member member) {
		arrayList.add(idx, member);
	} //이렇게 추가해도 됨
	
	public boolean removeMembber(int memberID) {
		for(int i = 0; i < arrayList.size(); i++) {
			Member member = arrayList.get(i);
			int tempID = member.getMemberID();
			if(tempID == memberID) {
				arrayList.remove(i);
				return true;
			}
		}		
		System.out.println(memberID + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(Member member : arrayList) {
		System.out.println(member);
		}
		System.out.println();
	}
	

}//end of class
