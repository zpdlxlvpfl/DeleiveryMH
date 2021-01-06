package com.hwyj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwyj.domain.OrderVO;
import com.hwyj.mapper.OrderMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class OrderServiceImpl  implements OrderService {
	
	@Autowired
	private OrderMapper OrderMapper;
	
	@Override
	public String OrderList(OrderVO orderVO) {
		OrderMapper.OrderList(orderVO);
		System.out.println(orderVO);
		return "";
	}
	
	@Override
	public String insertOrder(OrderVO orderVO) {
		String str = OrderMapper.insertOrder(orderVO);
		System.out.println(orderVO);
		return str;
	}
	
	
}
