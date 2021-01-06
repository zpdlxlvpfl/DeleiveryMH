package com.hwyj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwyj.domain.OrderVO;
import com.hwyj.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/order/*")
@AllArgsConstructor
public class OrderController {
	
	@Autowired
	private OrderService Orderservice;
	
	@PostMapping("/orderList")
	public void orderList (OrderVO ordervo,Model model) {
		model.addAttribute("ORDERLIST START@@@@::" + Orderservice.OrderList(ordervo));
		
	}
	
	@PostMapping("/insertOrder")
	public void insertOrder (OrderVO ordervo,Model model) {
		
		Orderservice.insertOrder(ordervo);
	}
	
	
}
