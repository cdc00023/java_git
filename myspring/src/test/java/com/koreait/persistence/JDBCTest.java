package com.koreait.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	
	//@Test
	public void testConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
					"java",
					"1234");
			log.info(conn);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}