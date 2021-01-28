package com.koreait.domain;

import lombok.Data;

@Data
public class PagingDTO {

	private int startPage;
	private int endPage;
	private boolean bprev; //이전 페이지 이동 여부
	private boolean bnext; //다음 페이지 이동 여부
	private int total; //전체 레코드 수
	private PageDTO page; //현재 몇 페이지인지 정보
	
	public PagingDTO(PageDTO page, int total) { //화면을 꾸미기 위함
		this.page = page;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(page.getPageNum() / 10.0)) * 10;		
		this.startPage = this.endPage - 9;
		int tmp = (int)Math.ceil(total / page.getPageAmount()); //실제 마지막 페이지
		if (this.endPage > tmp) {
			this.endPage = tmp;
		}
		this.bprev = this.startPage > 1; //11페이지 이상일 경우 참
		this.bnext = this.endPage < tmp;
	}
	
	
}
