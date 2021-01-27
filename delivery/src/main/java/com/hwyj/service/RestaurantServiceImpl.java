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
	public List<ResMenuVO> menuList( )throws Exception {
		return restaurantMapper.menuList();
	}
	
	@Override
	public List<ResMenuVO> mainmenuList( )throws Exception {
		return restaurantMapper.mainmenuList();
	}
	
	@Override
	public ResMenuVO get(String res_menu_code) {
		return restaurantMapper.get(res_menu_code);
	}
	
	
	@Override
	public List<ResMenuVO> menuread(String RES_CODE) {
		return restaurantMapper.menuread(RES_CODE);
	}

	
	//식당보기 서비스
	@Override
	public List<ResVO> restList( )throws Exception {
		log.info("식당보기: "+restaurantMapper.restList());
		return restaurantMapper.restList();
		
	}
	
	@Override
	public List<ResVO> restList2( )throws Exception {
		log.info("식당보기: "+restaurantMapper.restList2());
		return restaurantMapper.restList2();
		
	}
	
	@Override
	public ResMenuVO read (String res_menu_code) {
		return restaurantMapper.read(res_menu_code);
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
	public ResVO ResInfo(String res_code) throws Exception {
		log.info(restaurantMapper.ResInfo(res_code));
		return restaurantMapper.ResInfo(res_code);
	}
	
	
	@Override
	public boolean UpdateRes(ResVO resvo) {
		return restaurantMapper.UpdateRes(resvo)==1;
	}
	
	
	@Override
	public boolean deleteRes(ResVO resvo) {
		return restaurantMapper.deleteRes(resvo)==1;
		
	}
	
	@Override
	public List<String> getorderList (String id) {
		return restaurantMapper.getorderList(id);
	}
	
	
	@Override
	public boolean UpdateMenu(ResMenuVO menuvo) {
		return restaurantMapper.UpdateMenu(menuvo)==1 ;
	}
	
	
	@Override
	public boolean deleteMenu (ResMenuVO menuvo ) {
		return restaurantMapper.deleteMenu(menuvo)==1;
	}
	

	




	
	
	
	
}
