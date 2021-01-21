package com.hwyj.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

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

@Controller
@Log4j
@RequestMapping("/order/*")
@AllArgsConstructor
public class OrderController {
	
	@Autowired
	private OrderService Orderservice;
	
	@Setter(onMethod_ = @Autowired)
	private CartService cartService;
	
	
	
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "insertOrder", method = RequestMethod.GET, produces =
	 * "application/json; charset=utf8") public String insertOrder(ResMenuVO
	 * menuvo,HttpServletRequest rttr, HttpSession session, OrderVO vo, Model model,
	 * Authentication authentication) throws Exception { Calendar cal =
	 * Calendar.getInstance(); UserDetails userDetails = (UserDetails)
	 * authentication.getPrincipal(); CartVO cart = new CartVO(); String id =
	 * userDetails.getUsername(); List<String> cartList = (List)
	 * session.getAttribute("cartList"); HashMap<String, Object> HashMapList = new
	 * HashMap<String, Object>(); int year = cal.get(Calendar.YEAR); String ym =
	 * year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1); String
	 * ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE)); String
	 * subNum = ""; for (int i = 1; i <= 6; i++) { subNum += (int) (Math.random() *
	 * 10); }
	 * 
	 * String order_no = "ODRER_NUM" + ymd + "_" + subNum;
	 * 
	 * vo.setId(id); vo.setOrder_no(order_no); Orderservice.insertOrder(vo);
	 * Orderservice.updateOrder(order_no); Orderservice.updateOrderResCode(vo);
	 * Orderservice.orderList();
	 * 
	 * HashMapList.put("HashMapList", order_no); HashMapList.put("HashMapList" ,
	 * cartList); HashMapList.put("orderList", Orderservice.orderList());
	 * 
	 * //model.addAttribute("cartList", cartList); session.setAttribute("order_no",
	 * order_no); session.setAttribute("orderList", Orderservice.orderList());
	 * //System.out.println("=====cartList======\n" + cartList);
	 * 
	 * return "redirect:/order/updateOrder"; }
	 */
	
	/*
	 * @RequestMapping(value = "insertOrder", method = RequestMethod.GET, produces =
	 * "application/json; charset=utf8") public String insertOrder(String
	 * order_no,HttpServletRequest rttr, HttpSession session, OrderVO vo, Model
	 * model, Authentication authentication) {
	 * 
	 * List<String> cartList = (List) session.getAttribute("cartList"); UserDetails
	 * userDetails = (UserDetails) authentication.getPrincipal(); CartVO cart = new
	 * CartVO(); String id = userDetails.getUsername(); HashMap<String, Object>
	 * HashMapList = new HashMap<String, Object>();
	 * 
	 * List<OrderVO> OrderList = new ArrayList<OrderVO>();
	 * HashMapList.put("HashMapList",userDetails.getUsername());
	 * HashMapList.put("HashMapList" , cartList); Calendar cal =
	 * Calendar.getInstance(); int year = cal.get(Calendar.YEAR); String ym = year +
	 * new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1); String ymd = ym
	 * + new DecimalFormat("00").format(cal.get(Calendar.DATE)); String subNum = "";
	 * order_no = "ORDER"+ymd+"_" +subNum; vo.setOrder_no(order_no); vo.setId(id);
	 * Orderservice.insertOrder(vo); //vo.setOrder_no(order_no);
	 * model.addAttribute("HashMapList", cartList); model.addAttribute("cartList",
	 * cartList); HashMapList.put("OrderList" , HashMapList);
	 * System.out.println("=====cartList======\n" + cartList);
	 * System.out.println("======HashMapList=====\n" +HashMapList);
	 * 
	 * return "redirect:/order/orderList"; }
	 * 
	 * @RequestMapping(value = "updateOrder", method = RequestMethod.GET, produces =
	 * "application/json; charset=utf8") public String updateOrder(ResMenuVO
	 * menuvo,HttpServletRequest rttr, HttpSession session, OrderVO vo, Model model,
	 * Authentication authentication) throws Exception { String order_no = (String)
	 * session.getAttribute("order_no"); UserDetails userDetails = (UserDetails)
	 * authentication.getPrincipal(); CartVO cart = new CartVO(); String id =
	 * userDetails.getUsername(); vo.setId(id); Orderservice.updateOrder(order_no);
	 * Orderservice.updateOrderResCode(vo); Orderservice.orderList();
	 * 
	 * return "redirect:/order/orderList"; }
	 * 
	 * 
	 * @RequestMapping(value = "/orderList", method = RequestMethod.GET, produces =
	 * "application/json; charset=utf8") public List<OrderVO> orderList (OrderVO
	 * ordervo,ModelMap model, RedirectAttributes rttr, HttpSession
	 * session,Authentication authentication) throws Exception { UserDetails
	 * userDetails = (UserDetails) authentication.getPrincipal(); String
	 * id=userDetails.getUsername(); List<OrderVO> orderList = (List)
	 * session.getAttribute("orderList"); rttr.getFlashAttributes(); String order_no
	 * = (String) session.getAttribute("order_no"); HashMap<String, Object>
	 * HashMapList = new HashMap<String, Object>();
	 * 
	 * orderList = Orderservice.orderList(); orderList =
	 * Orderservice.read(order_no);
	 * 
	 * //HashMapList.put("ID", userDetails.getUsername());
	 * HashMapList.get(order_no); HashMapList.get(orderList);
	 * HashMapList.put("HashMapList" , orderList); model.addAttribute("HashMapList",
	 * orderList); model.addAttribute("HashMapList", HashMapList);
	 * Orderservice.orderList(); System.out.println("==22====orderList=====\n"
	 * +orderList); System.out.println("======HashMapList=====\n" +HashMapList);
	 * //System.out.println("======insertOrder=====\n"
	 * +Orderservice.insertOrder(ordervo)); return orderList;
	 * 
	 * }
	 * 
	 * @GetMapping("orderwrite") public void orderwrite( ) {
	 * 
	 * }
	 */

	
	
	
	
}
