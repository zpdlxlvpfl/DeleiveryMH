package com.hwyj.mapper;

import java.util.HashMap;  
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
@Mapper
public interface RestaurantMapper {
	
	//식당 메뉴 보기
	//public List<ResMenuVO> menuList( );
	
	
	public List<ResMenuVO> menuList() throws Exception;
	
	public List<ResMenuVO> mymenuList()throws Exception;
	
	public List<ResMenuVO> menuread(String RES_CODE);

	public ResMenuVO read(String res_menu_code) ;
	
	//식당 정보 보기
	
	public List<ResVO> restList() throws Exception;
	
	public HashMap<String, Object> getresCount();
	
	public List<ResVO> ResInfo() throws Exception;
	
	//주문정보
	
	public List<String> userorder ();
	
	//식당 리뷰 보기
	
	//public String saveImage(FileVO vo);
	
	public void enable (ResVO resvo);
	
	public void insertres (ResVO resvo); // 매장등록
	
	public void insertmenu (ResMenuVO menuvo); //메뉴등록

	public void rescodeUpDate();
	
	public void UpdateRes (ResVO resvo); 
	
	public void deleteRes (ResVO resvo); 
	
	public int UpdateMenu (ResMenuVO menuvo);
	
	public int deleteMenu (ResMenuVO menuvo);
	
	public ResMenuVO get(String res_code);

	
	
	
	

	
	
	
	
	

}
