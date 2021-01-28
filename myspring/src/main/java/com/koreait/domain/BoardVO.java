package com.koreait.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int b_num;
	private String b_subject;
	private String b_contents;
	private String b_name;
	private String b_password;
	private Date b_wdate;
	private Date b_udate;
	

}
