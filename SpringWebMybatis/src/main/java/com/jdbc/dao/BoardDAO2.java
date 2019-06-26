package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.executor.ReuseExecutor;
import org.mybatis.spring.SqlSessionTemplate;

import com.jdbc.dto.BoardDTO;

public class BoardDAO2 {
	
	private SqlSessionTemplate sessionTemplate;
	
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate){
		this.sessionTemplate = sessionTemplate;
	}
	
	public int getMaxNum(){
		
		int maxNum = 0;
		
		maxNum = sessionTemplate.selectOne("boardMapper.maxNum");
		
		return maxNum;
	}
	
	public void insertData(BoardDTO dto){
		
		sessionTemplate.insert("boardMapper.insertData",dto);
	}
	
	//전체데이터
	public List<BoardDTO> getList(int start, int end,
			String searchKey, String searchValue){
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		List<BoardDTO> lists = 
				sessionTemplate.selectList("boardMapper.getLists",params);
		
		return lists;
		
		
	}
	
	//전체 데이터수 구하기
	public int getDataCount(String searchKey,String searchValue){
		
		int result = 0;
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		result = sessionTemplate.selectOne("boardMapper.getDataCount",params);
		
		return result;
	
	}
	
	//조회수증가
	public void updateHitCount(int num){

		sessionTemplate.update("boardMapper.updateHitCount",num);
		
	}
	
	//한명의 데이터 출력
	public BoardDTO getReadData(int num){
		
		BoardDTO dto = sessionTemplate.selectOne("boardMapper.getReadData",num);
		
		return dto;
		
	}
	
	//삭제
	public void deleteData(int num){

		sessionTemplate.delete("boardMapper.deleteData",num);
	}
	
	
	//수정
	public void updateData(BoardDTO dto){
		
		sessionTemplate.update("boardMapper.updateData",dto);
	
	}
	

}
