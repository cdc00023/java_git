package com.koreait.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.domain.BoardVO;
import com.koreait.domain.PageDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_= @Autowired)
	private BoardService service;
	
	//@Test
	public void testGetList() {
		log.info("service 에서 리스트.......................");
		PageDTO page = new PageDTO(3,10);
		service.getList(page).forEach(board -> log.info(board)); //람다식 반복구문
	}
	
	//@Test
	public void testInsert() {
		log.info("service 에서 테스트..........................");
		BoardVO board = new BoardVO();
		board.setB_subject("입력 테스트");
		board.setB_contents("내용 입력 테스트");
		board.setB_name("홍길동");
		board.setB_password("1234");
		service.insert(board);
		log.info(board);
	}
	
	//@Test
	public void testView() {
		log.info("service에서 view 테스트....................");	
		BoardVO board = new BoardVO();
		board.setB_num(26);
		board = service.view(board);
		log.info(board);
	
	}
	
	//@Test
	public void testDelete() {
		log.info("service에서 delete 테스트............");
		BoardVO board = new BoardVO();
		board.setB_num(5);
		board.setB_password("1234");
		service.delete(board);
	}
	
	//@Test
	public void testUpdate() {
		log.info("service에서 update 테스트..............");
		BoardVO board = new BoardVO();
		board.setB_num(2);
		board.setB_subject("제목");
		board.setB_contents("내용");
		board.setB_name("이름");
		board.setB_password("1234");
		service.update(board);
		
	}
}
