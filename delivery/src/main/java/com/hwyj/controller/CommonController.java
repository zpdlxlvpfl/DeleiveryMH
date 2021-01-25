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

	@GetMapping("findId") //아이디 찾기 페이지
	public void findId() {

	}

	@GetMapping("/findPw") //비번 찾기 페이지
	public void findPw() {

	}


	@GetMapping("/join") // 가입
	public void join() {

	}
	
	@GetMapping("/index") // 가입
	public void index() {

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
	   
		/*
		 * //메뉴목록보기 (템플릿 메인 사진 아래)
		 * 
		 * @RequestMapping(value = "index", method = RequestMethod.GET, produces
		 * ="application/json; charset=utf8") public String menuList(ModelMap model,
		 * ResMenuVO menuvo) throws Exception { HashMap<String, Object> HashMapList =
		 * new HashMap<>(); //HashMap 인스턴스화 List<ResMenuVO> menuList = new
		 * ArrayList<>(); //List 인스턴스화
		 * 
		 * menuList = restaurantService.menuList(); HashMapList.get("menuList");
		 * HashMapList.put("menuList", menuList); HashMapList.put("HashMapList",
		 * HashMapList); model.addAttribute("menuList", menuList);
		 * model.addAttribute("HashMapList", HashMapList);
		 * 
		 * System.out.println("model@@@@@@@@@@@@@@@@@@@@@" + model);
		 * System.out.println("hashMap@@@@@@@@@@@@@@@@@@@@" + HashMapList);
		 * System.out.println("menuList@@@@@@@@@@@@@@@@@@@@" + menuList); return
		 * "/index"; }
		 */
		
		@GetMapping("/get")
		public void get(String res_code,String res_menu_code,Model model,ResMenuVO menuvo) {
			model.addAttribute("res_code",restaurantService.get(res_code));
			model.addAttribute("menucode",restaurantService.menuread(res_menu_code));
			System.out.println(model.addAttribute("res",restaurantService.get(res_code)));
			System.out.println(model.addAttribute("res_menu_code",restaurantService.menuread(res_menu_code)));
		}

	@RequestMapping(value = "restList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String restList(ModelMap model, RedirectAttributes rttr, HttpSession session, String RES_CODE)
			throws Exception {
		ResVO vo = new ResVO();
		rttr.getFlashAttributes();
		RES_CODE = (String) session.getAttribute("RES_CODE");
		List<ResVO> restList = new ArrayList<>();
		restList = restaurantService.restList();
		System.out.println(restList + "RestList@@@@@@@@@@@@@");
		model.addAttribute("restList", restList);
		restaurantService.read(RES_CODE);
		System.out.println("=======list====" + restList);
		// rttr.addAttribute("RES_CODE", RES_CODE);
		return "restList";
	}

	@GetMapping("/maptest") // 현재위치
	public void maptest() {

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

	@GetMapping("/insertCustomer") // ㅎㅗㅣㅇㅜㅓㄴㄱㅏㅇㅣㅂ
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
