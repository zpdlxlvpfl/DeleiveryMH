package com.hwyj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hwyj.domain.OrderVO;


@Mapper
public interface OrderMapper {
	
	//주문내역
	public List<OrderVO> OrderList(OrderVO orderVO);
	
	public List<OrderVO> insertOrder(OrderVO orderVO);


}
