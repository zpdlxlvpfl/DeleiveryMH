package com.hwyj.service;


import java.util.List;

import com.hwyj.domain.OrderVO;

public interface OrderService {
	
	
	//주문내역
	public List<OrderVO> OrderList(OrderVO orderVO);
	
	//등록
	public List<OrderVO> insertOrder(OrderVO orderVO);

}
