package com.hwyj.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hwyj.domain.OrderVO;


@Mapper
public interface OrderMapper {
	
	//주문내역
	public String OrderList(OrderVO orderVO);
	
	public String insertOrder(OrderVO orderVO);

}
