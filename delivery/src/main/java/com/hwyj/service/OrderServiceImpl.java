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
	public List<OrderVO> orderList()  throws Exception {
		return  OrderMapper.orderList();
	}
	
	/*
	 * @Override public String read(String res_menu_code) { return
	 * OrderMapper.read(res_menu_code); }
	 */
	

	@Override
	public void updateOrder(String order_no) {
		OrderMapper.updateOrder(order_no);
		
	}
	
	@Override
	public void updateOrderResCode(OrderVO orderVO) {
		OrderMapper.updateOrderResCode(orderVO);
		
	}
	
	@Override
	public List<OrderVO> read(String order_no) {
		return OrderMapper.read(order_no);
	}

	
	@Override
	public void insertOrder(OrderVO orderVO) {
		OrderVO vo = new OrderVO();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		String order_no ="ORDER"+ ymd + "_" + subNum;
		vo.setOrder_no(order_no);
		OrderMapper.insertOrder(orderVO);
	}
	
	
	
}
