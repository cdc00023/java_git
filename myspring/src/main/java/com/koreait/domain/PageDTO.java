package com.koreait.domain;

import lombok.Data;

@Data
public class PageDTO {
	private int pageNum;
	private int pageAmount;
	
	public PageDTO() {   //default 생성자
		this(1, 10);
	}
	
	public PageDTO(int pageNum, int pageAmount) {   //생성자 오버로딩
		this.pageNum = pageNum;
		this.pageAmount = pageAmount;
	}
}
