package com.hwyj.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.mapper.MemberMapper;
import com.hwyj.mapper.RestaurantMapper;
import com.hwyj.service.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/restaurant/*")
@AllArgsConstructor
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	// 식당 기본페이지
	@GetMapping("res") // 페이지 이름 뭘로하지????
	public void res(Model model) {
		model.addAttribute("menuList", restaurantService.menuList());
	}

	
	@GetMapping("/get")
	public void get() {

	}

	@GetMapping("/menulist")
	public void menulist() {

	}

	@GetMapping("/reswrite")
	public void reswrite() {

	}

	@GetMapping("/menuwrite")
	public void menuwrite() {

	}

	@GetMapping("/insertres") // 매장 등록
	public String insertres(Locale locale, ResVO resvo, RedirectAttributes rttr) {
		restaurantService.insertres(resvo);
		log.info(resvo);
		System.out.println(resvo);
		return "redirect:/restaurant/reshome";
	}

	@GetMapping("/insertmenu") // 메뉴 등록
	public String insertmenu(ResMenuVO menuvo, RedirectAttributes rttr) {
		restaurantService.insertmenu(menuvo);
		log.info(menuvo);
		System.out.println(menuvo);
		rttr.addFlashAttribute(menuvo);
		return "redirect:/restaurant/reshome";
	}


	
	@GetMapping("/menuList")
	@ResponseBody
	public Object menuList(@RequestParam Map<String,Object> map,ResMenuVO menuvo) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		
		List list = restaurantService.menuList();
		hashmap.put("data" , list);
		hashmap.put("msg" , "test");
		System.out.println("@@@@@" + hashmap);
		System.out.println("@@@@@" + menuvo);
		return hashmap;
	}



	
	@GetMapping("/restList")
	@ResponseBody
	public Object restList(@RequestParam Map<String,Object> map,ResVO resvo) {
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		
		List list = restaurantService.restList();
		hashmap.put("data" , list);
		hashmap.put("msg" , "test");
		System.out.println("@@@@@" + hashmap);
		System.out.println("@@@@@" + resvo);
		return hashmap;
	}
	
	
	@RequestMapping(value = "/reshome", method = RequestMethod.GET)
	public String reshome(HttpServletRequest request,HttpSession session,ResMenuVO menuvo) {
		String str = "";
		str = restaurantService.menuList(menuvo.getRes_menu_price());
		menuvo.setRes_menu_name(request.getParameter("res_menu_name"));
		System.out.println("@@@" + menuvo);
		//menuvo.setRes_menu_price(request.getParameter(menuvo.getRes_menu_price()));
		
		return menuvo;
	}


}
