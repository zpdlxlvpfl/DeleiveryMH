package com.hwyj.service;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
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
	public List<String> orderList(String id)  throws Exception {
		return  OrderMapper.orderList(id);
	}
	
	@Override
	public List<String> read (String res_menu_code){
		return OrderMapper.read(res_menu_code);
	}
	
	
}
