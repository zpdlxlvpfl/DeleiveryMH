package com.hwyj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
@Mapper
public interface RestaurantMapper {
	
	//식당 메뉴 보기
	public List<ResMenuVO> readMenu(String id);
	
	//식당 정보 보기
	
	//식당 리뷰 보기
	
	//public String saveImage(FileVO vo);
	
<<<<<<< HEAD
=======
	public void status (ResVO resvo);
>>>>>>> branch 'master' of https://github.com/zpdlxlvpfl/DeleiveryMH
	
	public void insertres (ResVO resvo);
	
	public void insertmenu (ResMenuVO menuvo);

	
	
	
	
	

}
