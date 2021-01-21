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
	public List<ResMenuVO> menuList() throws Exception;
	
	
	public ResMenuVO get(String res_menu_code);
	
	public List<ResMenuVO> menuread(String RES_CODE);
	
	
	public List<String> userorder ();
	
	//식당보기 서비스
	public List<ResVO> restList() throws Exception;
	
	
	public ResMenuVO read(String res_menu_code);
	
	//시갇ㅇ갯수
	public HashMap<String, Object> getresCount();
	
	
	//식당등록
	public void insertres(ResVO resvo);
	
	public void insertmenu(ResMenuVO menuvo);

	public void rescodeUpDate();
	
	public void UpdateRes(ResVO resvo);
	
	public void deleteRes(ResVO resvo);
	
	public boolean UpdateMenu(ResMenuVO menuvo);
	
	public boolean deleteMenu(ResMenuVO menuvo);

	public List<ResVO> ResInfo()throws Exception;



	

}
