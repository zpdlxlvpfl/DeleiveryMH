package com.hwyj.controller;

import java.text.DecimalFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.OrderVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
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
	
	
	
	@RequestMapping(value = "/insertOrdercode", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String insertOrdercode(ResMenuVO menuvo, HttpSession session, OrderVO vo, Model model, RedirectAttributes rttr) {

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";

		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}

		String order_no =  "ODN" +ymd + "_" + subNum;
		log.info(order_no);
		// rttr.addAttribute("insertres");
		session.setAttribute("get_Order_no", vo.getOrder_no());
		System.out.println(session);
		return "redirect:/order/orderList";
	}
	
	
	
	@PostMapping("/orderList")
	public void orderList (OrderVO ordervo,Model model) {
		model.addAttribute("ORDERLIST START@@@@::" + Orderservice.OrderList(ordervo));
		
	}
	
	@PostMapping("/insertOrder")
	public void insertOrder (OrderVO ordervo,Model model) {
		
		Orderservice.insertOrder(ordervo);
	}
	
	
}
