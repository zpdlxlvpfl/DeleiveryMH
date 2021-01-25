package com.hwyj.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hwyj.domain.OrderVO;
import com.hwyj.domain.ResMenuVO;


@Mapper
public interface OrderMapper {
	
	//주문내역
	public List<String> orderList(String id)throws Exception;
	

	public List<String> read(String res_menu_code);
	
	
	


}
