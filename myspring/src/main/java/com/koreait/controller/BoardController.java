package com.koreait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.domain.BoardVO;
import com.koreait.domain.PageDTO;
import com.koreait.domain.PagingDTO;
import com.koreait.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j	

public class BoardController {
		
	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@GetMapping("/list")
	public String list(PageDTO page, Model model) {
		int total = service.getTotal();
		PagingDTO paging = new PagingDTO(page, total);

		model.addAttribute("list", service.getList(page)); // 다중화된 배열성 객체, 테이블의 내용을 list변수로 jsp파일에 전달함
		model.addAttribute("paging", paging);
		return "/board/list";
	}

	@GetMapping("/insert")
	public String insert() {

		return "/board/insert"; // insert.jsp 사용
	}

	@PostMapping("/insert")
	public String insert(BoardVO board) { // 포멧 네임을 일치시켰기때문에 넘어올수 있다
		log.info("전송된 데이터 : " + board);
		service.insert(board); //테이블에 입력
		return "redirect:/board/list"; //list.jsp 호출
		//redirect: controller의 list호출

	}
	
	@GetMapping("/view")
	public String view(BoardVO board, PageDTO page, Model model) {
		log.info("view 화면 처리...................");
		log.info(board);
		board = service.view(board); //단일 레코드 변환
		model.addAttribute("board", board); //model객체에 반환된 레코드를 저장해서 view로 전달		
		model.addAttribute("page", page);
		return "/board/view";		
	}
	
	@PostMapping("/delete")
	public String delete(BoardVO board) {
		log.info("삭제 처리.....................");
		service.delete(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/update")
	public String update(BoardVO board, Model model) {
		log.info("update 폼 호출.................");
		board = service.view(board); //단일 레코드를 반환함
		model.addAttribute("board", board);
		return "/board/update";
	}
	
	@PostMapping("/update")
	public String update(BoardVO board) {
		log.info("update 처리 호출.................");
		service.update(board);
		
		return "redirect:/board/list";
		
	}
	
}
