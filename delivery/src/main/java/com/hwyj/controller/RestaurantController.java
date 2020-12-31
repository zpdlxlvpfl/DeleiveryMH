package com.hwyj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	
	//식당 기본페이지
	@GetMapping("res") //페이지 이름 뭘로하지????
	public void res(String id, Model model) {
		model.addAttribute("menuList", restaurantService.menuList(id));
	}
	
	
	@GetMapping("/reshome") 
	public void reshome() {
		
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
	

	
	@GetMapping("/insertres")  //매장 등록 
	public String insertres (Locale locale, ResVO resvo,RedirectAttributes rttr) {
		restaurantService.insertres(resvo);
		log.info(resvo);
		System.out.println(resvo);
		return "redirect:/restaurant/reshome";
	}
	
	 
	@GetMapping("/insertmenu") //메뉴 등록 
	public String insertmenu (ResMenuVO menuvo,RedirectAttributes rttr) {
		restaurantService.insertmenu(menuvo);
		log.info(menuvo);
		System.out.println(menuvo);
		rttr.addFlashAttribute(menuvo);
		return "redirect:/restaurant/reshome";
	}
	
	
	/*
	 * @GetMapping("/rescode")
	 * 
	 * @ResponseBody public String rescode () { Map<String, String> map = new
	 * HashMap<String, String>();
	 * 
	 * List<'e'> keys = new ArrayList(map.keySet()); Collections.shuffle(keys); for
	 * (Object o : keys) { // Access keys/values in a random order map.get(o); }
	 */
	
	
	@GetMapping("/menuList")
	@ResponseBody
	public String menuList() {
		Map<String, Object> map = new HashMap<String , Object>();
		ResMenuVO resmenu = new ResMenuVO();
		map.put("menucode", resmenu.getRes_menu_code());
		map.put("resex", resmenu.getRes_menu_explan());
		map.put("Foodname" , resmenu.getRes_menu_name());
		map.put("FoodPrice" , resmenu.getRes_menu_price());
		
		
		return null;
		/*
		 * restaurantService.menuList(id); log.info(id); System.out.println(id);
		 * model.addAttribute("menuList", restaurantService.menuList(id));
		 */
		
	}
	
	
	
	//@RequestMapping(value = "/restList/get.do") //메뉴 보기
	@GetMapping("/restList")
	@ResponseBody
	public String restList() {
		Map<String, Object> map = new HashMap<String , Object>();
		ResVO resvo = new ResVO ( );
		map.put("Rescode", resvo.getRES_CODE());
		map.put("Resname", resvo.getRES_NAME());
		map.put("ResInfo" , resvo.getRES_INFO());
		map.put("DelPrice" , resvo.getDEL_PRICE());
		map.put("MenuPrice" , resvo.getRES_MENU_PRICE());
		
		
		return null;
	}
	

}
