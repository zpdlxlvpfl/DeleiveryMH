package com.hwyj.controller;

import java.util.Locale;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwyj.domain.ResVO;
import com.hwyj.mapper.RestaurantMapper;
import com.hwyj.service.RestaurantService;

import lombok.AllArgsConstructor;
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
	
	@GetMapping("/menuwrite") 
	public void menuwrite() {

	}
	
	@GetMapping("/reswrite") 
	public void reswrite() {

	}
	
	@GetMapping("/restList") 
	public void restList() {

	}
	
	
	

	@Autowired  //매장 등록 
	private RestaurantMapper restmapper;
	@GetMapping("/insertres")
	@ResponseBody
	public void insertres (Locale locale, ResVO resvo,Model model) {
		restmapper.insertres(resvo);
		System.out.println(resvo);
	}
	

}
