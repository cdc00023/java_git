package com.koreait.mapper;

import java.util.List;

import com.koreait.domain.BoardVO;
import com.koreait.domain.PageDTO;

public interface BoardMapper {

	public List<BoardVO> getList(PageDTO page);
	
	public void insert(BoardVO board);
	
	public BoardVO view(BoardVO board);
	
	public int getAuth(BoardVO board);
	
	public void delete(BoardVO board);
	
	public void update(BoardVO board);
	
	public int getTotal();
	
}
