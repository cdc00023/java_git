package com.koreait.service;

import java.util.List;

import com.koreait.domain.BoardVO;
import com.koreait.domain.PageDTO;

public interface BoardService {

	public List<BoardVO> getList(PageDTO page);
	
	public int getTotal();
	
	public void insert(BoardVO board);
	
	public BoardVO view(BoardVO board);
	
	public void delete(BoardVO board);
	
	public void update(BoardVO board);
	
}
