package com.hwyj.controller;

import java.text.DecimalFormat; 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.OrderVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.domain.ReviewVO;
import com.hwyj.service.CartService;
import com.hwyj.service.OrderService;
import com.hwyj.service.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/order/")
@AllArgsConstructor
public class OrderController {

	private OrderService service;

	@ResponseBody
	@GetMapping(value = "/getOrderList", produces= { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<String> getOrderList(ModelMap model, RedirectAttributes rttr, HttpSession session,
			Authentication authentication,CartVO vo) throws Exception {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String id = userDetails.getUsername();
		rttr.getFlashAttributes();
		vo.setId(id);
		HashMap<String, Object> HashMapList = new HashMap<String, Object>();
		List<String> getOrderList = service.orderList(id);
		UtilController util = new UtilController();
		vo.setPayment("Y");
		HashMapList.put("getOrderList", getOrderList);
		model.addAttribute("getOrderList", HashMapList);
		rttr.addFlashAttribute("getOrderList", HashMapList);
		System.out.println("=====OrderList=====" + getOrderList);
		System.out.println("=====HashMapList=====" + HashMapList);
		
		return getOrderList;

	}
	


}
