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
	
	public List<ResMenuVO> getList();
	
	public List<String> menuList() throws Exception;
	
	public ResMenuVO read(String res_code);
	
//	public ResMenuVO restget(String menucode);
	
	//식당 정보 보기
	
	
	public List<ResVO> restList( );
	
	public HashMap<String, Object> getresCount();
	
	
	//식당 리뷰 보기
	
	//public String saveImage(FileVO vo);
	
	public void status (ResVO resvo);
	
	public void insertres (ResVO resvo); // 매장등록
	
	public void insertmenu (ResMenuVO menuvo); //메뉴등록

	

	
	
	
	
	

}
