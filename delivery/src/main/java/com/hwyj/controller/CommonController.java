package com.hwyj.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.EmailVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.mapper.MemberMapper;
import com.hwyj.mapper.RestaurantMapper;
import com.hwyj.service.EmailService;
import com.hwyj.service.MemberService;
import com.hwyj.service.RestaurantService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Controller
@Log4j
public class CommonController {

	@Setter(onMethod_ = @Autowired)
	private PasswordEncoder pwencoder;

	@Setter(onMethod_ = @Autowired)
	private RestaurantService restaurantService;

	@GetMapping("/login") // 로그인 페이지
	public void login(String error, Model model) {
		log.info("에러: " + error);
		if (error != null) { // 로그인실패
			model.addAttribute("error", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
		}

	}

	@PostMapping("/logout") // 로그아웃 버튼 누르면 로그아웃 되고 로그인페이지로 이동
	public String logout() {
		return "redirect:/login";
	}

	@GetMapping("findId") // 아이디 찾기 페이지
	public void findId() {

	}

	@GetMapping("/findPw") // 비번 찾기 페이지
	public void findPw() {

	}

	@GetMapping("/join") // 가입
	public void join() {

	}
	
	 


	@RequestMapping(value = "menuList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String menuList(ModelMap model, ResMenuVO menuvo, RedirectAttributes rttr, String RES_CODE)
			throws Exception {
		// HttpSession session = null;
		// RES_CODE = (String)session.getAttribute("RES_CODE");
		rttr.getFlashAttributes();
		UtilController util = new UtilController();
		HashMap<String, Object> HashMapList = new HashMap<>();
		List<ResMenuVO> menuList = new ArrayList<>();
		menuList = restaurantService.menuList();
		menuList = restaurantService.menuread(RES_CODE);
		HashMapList.put("HashMapList", menuList);
		model.addAttribute("menuList", menuList);
		model.addAttribute("HashMapList", HashMapList);
		restaurantService.menuread(RES_CODE);
		System.out.println(menuList + "LIST@@@@@@@@@@@@@@@@@@@");
		return "menuList";
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public ModelAndView index(String RES_CODE, ResVO vo, ResMenuVO menu, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<ResVO> restList = restaurantService.restList2();
		List<ResMenuVO> menuList = restaurantService.mainmenuList();		
		
		mav.setViewName("index");
		mav.addObject("RES_CODE", vo.getRES_CODE());
		mav.addObject("res_code", menu.getRES_CODE());
		mav.addObject("restList", restList);
		mav.addObject("mainmenuList", menuList);
		System.out.println("@rsetList@::" + restList);
		System.out.println("@menuList@::" + menuList);
		return mav;
	}
	
	


	@GetMapping("/maptest") // 현재위치
	public void maptest() {

	}

	@RequestMapping(value = "restList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public ModelAndView restList(String RES_CODE, ResVO vo, ResMenuVO menu) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<ResVO> restList = restaurantService.restList();
		mav.setViewName("restList");
		mav.addObject("restList", restList);
		System.out.println("@rsetList@::" + restList);
		return mav;
	}

	@GetMapping("/foodmaptest") // 음식점 마커
	public void foodmaptest() {

	}

	@GetMapping("/accessError") // 403페이지 (접근제한)
	public String accessDenied(Authentication auth) {

		return "/exception/error403";
	}

	@Autowired
	private MemberService memberservice;

	@GetMapping("/insertCustomer") // 회원가입
	@ResponseBody
	public String insertCustomer(Locale locale, CustomerVO csVO, Model model) {
		log.info("test");
		System.out.println("InsertCustomer start" + csVO.getId());
		String check = "";

		check = memberservice.selectCustomer(csVO);
		System.out.println("result " + check);
		check = "0";
		PasswordEncoder encode = new BCryptPasswordEncoder();
		csVO.setPw(encode.encode(csVO.getPw()));

		int check2 = memberservice.insertCustomer(csVO);
		check = check2 + "";

		// }
		return check + "";
	}

	@GetMapping("/enabled")
	public String enabled(String ID, String RES_ID, Model model) {
		return "";
	}

}
