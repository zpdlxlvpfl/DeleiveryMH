package com.hwyj.service;

import java.util.HashMap;
import java.util.List;

import com.hwyj.domain.OrderVO;

public interface OrderService {

	// 주문내역
	public List<OrderVO> orderList() throws Exception;

	// 등록
	public void insertOrder(OrderVO orderVO);
	

	public void updateOrderResCode(OrderVO orderVO);

	public List<OrderVO> read(String order_no);

	public void updateOrder(String order_no);




}
