package com.hwyj.service;

import java.util.ArrayList;
import java.util.List;

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
	public  List<OrderVO> OrderList(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		list = OrderMapper.OrderList(orderVO);
		System.out.println(orderVO);
		return list;
	}
	
	
	@Override
	public  List<OrderVO>  insertOrder(OrderVO orderVO) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		list = OrderMapper.insertOrder(orderVO);
		System.out.println(orderVO);
		return list;
	}
	
	
}
