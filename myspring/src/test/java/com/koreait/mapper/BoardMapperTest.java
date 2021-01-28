package com.koreait.mapper;

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
public class BoardMapperTest {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	//@Test
	public void testGetLsit() {
		log.info("리스트................................");
		PageDTO page = new PageDTO(2,10); //2페이지 10개씩 보이게 생성
		mapper.getList(page).forEach(board -> log.info(board));
	}
	
	//@Test
	public void testGetTotal() {
		log.info("전체 레코드 갯수........................");
		int result = mapper.getTotal();
		log.info("갯수 : " + result);
	}

	// @Test
	public void testInsert() {
		log.info("insert 테스트..........................");
		BoardVO board = new BoardVO();
		board.setB_subject("입력 테스트");
		board.setB_contents("내용 입력 테스트");
		board.setB_name("홍길동");
		board.setB_password("1234");
		mapper.insert(board);
		log.info(board);
	}
	
	//@Test
	public void testView() {
		log.info("view 테스트...........................");
		BoardVO board = new BoardVO();
		board.setB_num(26);
		board = mapper.view(board);
		log.info(board);
	}
	
	//@Test
	public void testGetAuth() {
		log.info("getAuth 테스트......................");
		BoardVO board = new BoardVO();
		board.setB_num(5);
		board.setB_password("1234");
		int result = mapper.getAuth(board);
		log.info("결과 : " + result);		
	}
			
	//@Test
	public void testDelete() {
		log.info("delete 테스트...........................");
		BoardVO board = new BoardVO();
		board.setB_num(3);
		mapper.delete(board);
		log.info("삭제완료..............");
	}
	
	//@Test
	public void testUpdate() {
		log.info("update 테스트.....................");
		BoardVO board = new BoardVO();
		board.setB_num(4);
		board.setB_subject("수정....");
		board.setB_contents("내용수정....");
		board.setB_name("홍길동 수정");
		mapper.update(board);
	}
	
}
