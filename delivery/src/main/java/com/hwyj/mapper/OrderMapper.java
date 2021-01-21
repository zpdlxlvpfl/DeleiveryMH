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
	public List<OrderVO> orderList()throws Exception;
	
	//public void insertOrder(OrderVO orderVO);

	public List<OrderVO> read(String order_no);
	
	//public void insertOrder(OrderVO orderVO);
	
	public void updateOrder(String order_no);
	
	public void updateOrderResCode(OrderVO orderVO);

	public void insertOrder(OrderVO orderVO);
	
	
	


}
