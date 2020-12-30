package com.hwyj.service;

import java.util.List ;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;

@Service
public interface RestaurantService {
	
	//식당 메뉴보기 서비스
	public List<ResMenuVO> menuList(String id);
	
	
	//식당등록
	public void insertres(ResVO resvo);
	
	public void insertmenu(ResMenuVO menuvo);


	

	//public String saveImage(FileVO vo);
}
