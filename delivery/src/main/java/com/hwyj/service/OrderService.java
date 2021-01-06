package com.hwyj.service;


import com.hwyj.domain.OrderVO;

public interface OrderService {
	
	
	//주문내역
	public String OrderList(OrderVO orderVO);
	
	//등록
	public String insertOrder(OrderVO orderVO);

}
