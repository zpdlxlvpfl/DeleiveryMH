package com.hwyj.service;

import java.util.HashMap;
import java.util.List;

import com.hwyj.domain.OrderVO;

public interface OrderService {

	// 주문내역
	public List<String> orderList(String id) throws Exception;

	public List<String> read(String res_menu_code);






}
