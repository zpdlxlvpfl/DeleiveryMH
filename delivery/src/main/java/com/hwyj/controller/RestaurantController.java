package com.hwyj.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request; 

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Generated;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.OrderVO;
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
	}

	@GetMapping("/menulist")
	public void menulist() {

	}

	@GetMapping("/reswrite")
	public void reswrite() {

	}

	@GetMapping("/reshome")
	public void reshome() {

	}

	@GetMapping("/menuwrite")
	public void menuwrite() {

	}

	@GetMapping("/insertres") // 매장 등록
	public String insertres(Locale locale, ResVO resvo) {
		HttpSession session = null;
		
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		 
		String res_code = ymd + "_" + subNum;
		resvo.setRES_CODE(res_code);;
		restaurantService.insertres(resvo);
		log.info(res_code);
		System.out.println(resvo);
		System.out.println(session);
		return "redirect:/restaurant/reshome";
	}

	

	@GetMapping("/insertmenu") // 메뉴 등록
	public String insertmenu(ResMenuVO menuvo, RedirectAttributes rttr) {
		 HttpSession session = null;
		 
		
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		 
		String res_menu_code = ymd + "_Menu" + subNum;
		String res_code = ymd + "_" + subNum;
		
		menuvo.setRes_code(res_code);
		menuvo.setRes_menu_code(res_menu_code);
		restaurantService.insertmenu(menuvo);
		System.out.println(menuvo);
		return "redirect:/restaurant/reshome";
	}

	// 메뉴목록보기 (템플릿 사진 아래)
	@RequestMapping(value = "menuList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String menuList(ModelMap model, ResMenuVO menuvo) throws Exception {
		HashMap<String, Object> hashMap = new HashMap<>(); // HashMap 인스턴스화
		List<String> list = new ArrayList<>(); // List 인스턴스화

		list = restaurantService.menuList();
		hashMap.put("HashMapList", list);

		System.out.println(list);
		model.addAttribute("HashMapList", list);

		return "/restaurant/menuList";
	}

	@GetMapping("/get")
	public void get(String res_code, String res_menu_code, Model model, ResMenuVO menuvo) {
		model.addAttribute("res_code", restaurantService.get(res_code));
		model.addAttribute("menucode", restaurantService.menuread(res_menu_code));
		System.out.println(model.addAttribute("res", restaurantService.get(res_code)));
		System.out.println(model.addAttribute("res_menu_code", restaurantService.menuread(res_menu_code)));
	}

	@RequestMapping(value = "restList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String restList(ModelMap model, ResVO resvo) throws Exception {
		HashMap<String, Object> hashMap = new HashMap<>();
		List<String> list = new ArrayList<>();

		list = restaurantService.restList();
		hashMap.put("HashMapList", list);

		System.out.println(list);
		model.addAttribute("HashMapList", list);

		return "/restaurant/restList";
	}

}
