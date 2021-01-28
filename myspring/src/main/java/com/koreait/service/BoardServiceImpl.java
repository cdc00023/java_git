package com.koreait.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.domain.BoardVO;
import com.koreait.domain.PageDTO;
import com.koreait.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList(PageDTO page) {
		
		return mapper.getList(page);
	   }
	
	@Override
	public int getTotal() {
		return mapper.getTotal();
	}
		
		@Override
		public void insert(BoardVO board) {
			mapper.insert(board);
		}
		
		@Override
		public BoardVO view(BoardVO board) {
			return mapper.view(board);
		}
		
		@Override
		public void delete(BoardVO board) {
			int result = mapper.getAuth(board);
			if (result == 1) {
				mapper.delete(board);
			}
		}
		
		@Override
		public void update(BoardVO board) {
			int result = mapper.getAuth(board);
			if (result == 1) {
				mapper.update(board);
			}
		}
		
}
