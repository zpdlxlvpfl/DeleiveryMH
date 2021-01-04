package com.hwyj.service;

import java.util.HashMap;    
import java.util.List ;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;

@Service
public interface RestaurantService {
	
	//메뉴보기 서비스
	public List<String> menuList() throws Exception;
	
	public ResMenuVO get(String res_code);
	
	public ResMenuVO menuread(String menucode);
	
	//식당보기 서비스
	public List<String> restList() throws Exception;
	
	public ResVO read(String res_code);
	

	

	
	
	
	HashMap<String, Object> getresCount();
	
	/*
	 * public ResMenuVO getmenu (String menucode);
	 * 
	 * public ResVO getres (String rescode);
	 */
	
	
	
	//식당등록
	public void insertres(ResVO resvo);
	
	public void insertmenu(ResMenuVO menuvo);

	
	

}
