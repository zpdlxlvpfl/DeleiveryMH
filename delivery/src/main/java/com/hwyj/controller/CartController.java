package com.hwyj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.service.CartService;
import com.hwyj.service.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/cart/*")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_MEMBER')") // 일반사용자 전용 페이지
public class CartController {

	@Setter(onMethod_ = @Autowired)
	private RestaurantService restaurantService;

	
	@GetMapping("myCart")
	public void myCart() {
		
	}
	/*
	 * @GetMapping("myCart") // 장바구니 페이지 public void myCart(Authentication
	 * authentication, Model model) {
	 * 
	 * }
	 */

//	  @RequestMapping(value = "/myCart", method = RequestMethod.GET, produces ="application/json; charset=utf8")
//		public void menuList(ModelMap model,Authentication authentication, ResMenuVO menuvo) throws Exception {
//			HashMap<String, Object> hashMap = new HashMap<>();	//HashMap 인스턴스화
//			List<ResMenuVO> list = new ArrayList<>();				//List 인스턴스화
//			
//			list =  restaurantService.menuList();
//			hashMap.put("HashMapList", list);
//			model.addAttribute("HashMapList", list);
//			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//			System.out.println("model@@@@@@@@@@@@@@@@@@@@@" + model);
//			System.out.println("hashMap@@@@@@@@@@@@@@@@@@@@" + hashMap);
//		//	return "myCart";
//		}


}