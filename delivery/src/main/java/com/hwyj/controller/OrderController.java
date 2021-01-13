package com.hwyj.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.OrderVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.service.CartService;
import com.hwyj.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/order/*")
@AllArgsConstructor
public class OrderController {
	
	@Autowired
	private OrderService Orderservice;
	
	@Setter(onMethod_ = @Autowired)
	private CartService cartService;
	
	
	
	
	@RequestMapping(value = "insertOrder", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String insertOrder(ResMenuVO menuvo, HttpSession session, OrderVO vo, Model model, Authentication authentication) {
		Calendar cal = Calendar.getInstance();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		CartVO cart = new CartVO();
		List<String> cartList = (List) session.getAttribute("cartList");
		HashMap<String, Object> HashMapList = new HashMap<String, Object>();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		List<OrderVO> OrderList = new ArrayList<OrderVO>();
		
		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}
		
		String order_no =  "ODRER_NUM" + ymd + "_" + subNum;
		HashMapList.put("order_no", order_no);
		HashMapList.put("id",userDetails.getUsername());
		HashMapList.put("cartList" , cartList);
		model.addAttribute("HashMapList", HashMapList);
		model.addAttribute("cartList", cartList);
		System.out.println("=====cartList======\n" + cartList);
		System.out.println("======HashMapList=====\n" +HashMapList);
		
		return "redirect:/order/orderList";
	}
	
	@RequestMapping(value = "orderList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public HashMap<String, Object> orderList (OrderVO ordervo,Model model, Authentication authentication) {
		Calendar cal = Calendar.getInstance();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		CartVO cart = new CartVO();
		String id=userDetails.getUsername();
		HashMap<String, Object> orderList = new HashMap<String, Object>();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
 
		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}
		
		String order_no =  "order_no" + ymd + "_" + subNum;
	
		orderList.put("order_no", order_no);
		ordervo.setOrder_no(order_no);
		orderList.put("ID", userDetails.getUsername());
		orderList.put("cartList" , cartService.cartList(userDetails.getUsername()));
		orderList.put("orderList" , Orderservice.OrderList(ordervo));
		// rttr.addAttribute("insertres");
		
		model.addAttribute("orderList", orderList);
		System.out.println("======HashMapList=====\n" +orderList);
		//System.out.println("======insertOrder=====\n" +Orderservice.insertOrder(ordervo));
		return orderList;
		
	}

	
	
	
	
}
