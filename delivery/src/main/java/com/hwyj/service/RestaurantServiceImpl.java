package com.hwyj.service;

import java.util.HashMap;   
import java.util.List ;

import org.springframework.stereotype.Service;

import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.mapper.MemberMapper;
import com.hwyj.mapper.RestaurantMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
	
	private RestaurantMapper restaurantMapper;
	
	//메뉴보기 서비스
	@Override
	public List<String> menuList( )throws Exception {
		return restaurantMapper.menuList();
	}
	
	public ResMenuVO get(String res_code) {
		return restaurantMapper.menuread(res_code);
	}
	
	public ResMenuVO menuread(String menucode) {
		return restaurantMapper.menuread(menucode);
	}

	
	//식당보기 서비스
	@Override
	public List<String> restList( )throws Exception {
		log.info("식당보기: "+restaurantMapper.restList());
		return restaurantMapper.restList();
	}
	
	@Override
	public List<String> read(String RES_CODE)  {
		
		return restaurantMapper.read(RES_CODE);
	}

	
	@Override
	public HashMap<String, Object> getresCount() {
		
		return restaurantMapper.getresCount();
	}
	

	
	/*
	 * @Override public String saveImage(FileVO vo) {
	 * log.info(restaurantMapper.saveImage(vo)); return "redirect:/formFile"; }
	 */
	
	@Override
	public void insertres(ResVO resvo) {
		restaurantMapper.insertres(resvo);
		log.info("메뉴등록@@@@@@@@" + resvo);
	//	return 0;
		//return restaurantMapper.insertres(resvo);
	}
	
	@Override
	public void insertmenu(ResMenuVO menuvo) {
		restaurantMapper.insertmenu(menuvo);
		log.info("메장등록@@@@@@@@" + menuvo);
	}
	
	@Override
	public void rescodeUpDate() {
		restaurantMapper.rescodeUpDate();
		System.out.println("@@@@update start@@@@@@");
		
	}
	
	
	
	@Override
	public void UpdateRes(ResVO resvo) {
		restaurantMapper.UpdateRes(resvo);
	}
	
	
	@Override
	public void deleteRes(ResVO resvo) {
		restaurantMapper.deleteRes(resvo);
		
	}
	
	
	@Override
	public void UpdateMenu(ResMenuVO menuvo) {
		restaurantMapper.UpdateMenu(menuvo);
	}
	
	
	@Override
	public void deleteMenu (ResMenuVO menuvo) {
		restaurantMapper.deleteMenu(menuvo);
	}
	

	




	
	
	
	
}
