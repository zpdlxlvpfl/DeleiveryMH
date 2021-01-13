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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.AuthVO;
import com.hwyj.domain.CartVO;
import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.OrderVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.mapper.MemberMapper;
import com.hwyj.mapper.RestaurantMapper;
import com.hwyj.service.AllListDao;
import com.hwyj.service.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/restaurant/*")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_RES')")

public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	// 식당 기본페이지
	@GetMapping("res") // 페이지 이름 뭘로하지????
	public void res(Model model) {
	}

	@GetMapping(value = "/test", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public String test(ModelMap model, String RES_CODE) throws Exception {
		List<ResVO> list = restaurantService.restList();
		System.out.println(list + "RestList@@@@@@@@@@@@@");
		model.addAttribute("RestList", list);
		restaurantService.read(RES_CODE);

		for (ResVO temp : list) {
			System.out.println(list);
		}
		return "/restaurant/test";
	}

	@GetMapping("/ResInfo")
	public void ResInfo() {

	}

	@GetMapping("/reswrite")
	public void reswrite() {

	}

	/*
	 * @GetMapping("menuread") public String menuread(ModelMap model, String
	 * RES_CODE, RedirectAttributes rttr) { rttr.getFlashAttributes();
	 * HashMap<String, Object> hashlist = new HashMap<String, Object>();
	 * List<ResMenuVO> list = new ArrayList<>(); list =
	 * restaurantService.menuread(RES_CODE); hashlist.put("RES_CODE", RES_CODE);
	 * hashlist.put("list", list); model.addAttribute("RES_CODE",
	 * restaurantService.menuread(RES_CODE)); model.addAttribute("list", list);
	 * model.addAttribute("hashlist", hashlist); System.out.println(model +
	 * "@@@@@@@model@@@@@"); System.out.println(list + "@@@@@@@list@@@@@");
	 * System.out.println(hashlist + "@@@@@@@hashlist@@@@@");
	 * 
	 * return "/restaurant/menuread?RES_CODE=" + RES_CODE; }
	 */

	@GetMapping("/reshome")
	public void reshome(String RES_CODE, ModelMap model, HttpSession session, RedirectAttributes rttr)
			throws Exception {
		rttr.getFlashAttributes();
	}

	@RequestMapping(value = "/menuread", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String menuread(ModelMap model, String res_code,ResMenuVO menuvo, RedirectAttributes rttr) throws Exception {
		rttr.getFlashAttributes();
		restaurantService.menuread(res_code);
		return res_code;
	}

	@GetMapping("/menuwrite")
	public void menuwrite() {

	}

	// 매장 등록
	@RequestMapping(value = "/insertres", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String insertres(ResMenuVO menuvo, HttpSession session, ResVO resvo, Model model, RedirectAttributes rttr) {
		String RES_ROLE = (String) session.getAttribute("RES_ROLE");
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";

		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}

		String RES_CODE = ymd + "_" + subNum;
		resvo.setRES_CODE(RES_CODE);
		restaurantService.insertres(resvo);
		log.info(RES_CODE);
		System.out.println(resvo);
		// rttr.addAttribute("insertres");
		session.setAttribute("RES_CODE", resvo.getRES_CODE());
		System.out.println(session);
		return "redirect:/restaurant/reshome";
	}

	// 메뉴 등록
	@RequestMapping(value = "insertmenu", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String insertmenu(ResMenuVO menuvo, HttpSession session, RedirectAttributes rttr) {
		// HttpSession session = null;
		// String RES_CODE = (String)session.getAttribute("RES_CODE");
		rttr.getFlashAttributes();
		String RES_ROLE = (String) session.getAttribute("RES_ROLE");
		ResVO vo = new ResVO();

		String RES_CODE = (String) session.getAttribute("RES_CODE");

		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";

		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}

		String res_menu_code = ymd + "_Menu" + subNum;
		menuvo.setRes_menu_code(res_menu_code);
		menuvo.setRES_CODE(RES_CODE);

		restaurantService.insertmenu(menuvo);
		System.out.println(menuvo);
		System.out.println(session + "RESROLE@@@@@@@@@@@@\n" + RES_ROLE);

		return "redirect:/restaurant/reshome";

	}

	@RequestMapping(value = "menuList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public List<ResMenuVO> menuList(ModelMap model, ResMenuVO menuvo, RedirectAttributes rttr, String RES_CODE)
			throws Exception {
		// HttpSession session = null;
		// RES_CODE = (String)session.getAttribute("RES_CODE");
		rttr.getFlashAttributes();
		UtilController util = new UtilController();
		
		List<ResMenuVO> menuList = new ArrayList<>();
		menuList = restaurantService.menuList();
		menuList = restaurantService.menuread(RES_CODE);
		model.addAttribute("menuList", menuList);
		restaurantService.menuread(RES_CODE);
		System.out.println(menuList + "LIST@@@@@@@@@@@@@@@@@@@");
		return menuList;
		// return "restaurant/menuList";
	}

	@RequestMapping(value = "restList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public List<ResVO> restList(ModelMap model, RedirectAttributes rttr, HttpSession session, String res_code)
			throws Exception {
		ResVO vo = new ResVO();
		rttr.getFlashAttributes();
		res_code = (String) session.getAttribute("RES_CODE");
		List<ResVO> restList = new ArrayList<>();
		restList = restaurantService.restList();
		System.out.println(restList + "RestList@@@@@@@@@@@@@");
		model.addAttribute("restList", restList);
		restaurantService.read(res_code);
		model.addAttribute("RES_CODE", restaurantService.menuread(res_code));
		System.out.println("=======list====" + restList);
		rttr.addAttribute("RES_CODE", res_code);

		return restList;
	}

	@RequestMapping(value = "ResInfo", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public List<ResVO> ResInfo(Model model, String RES_CODE, RedirectAttributes rttr) throws Exception {
		rttr.getFlashAttributes();
		HashMap<String, Object> hashlist = new HashMap<String, Object>();

		List<ResVO> list = new ArrayList<>();
		UtilController util = new UtilController();
		hashlist.put("hashlist", restaurantService.ResInfo());
		list = restaurantService.ResInfo();
		// model.addAttribute("RES_CODE",RES_CODE);
		model.addAttribute("ResInfo", list); // model.addAttribute("HashList",HashList);
		System.out.println("@@@@@@ResInfo@@@@@@@@@" + list);
		System.out.println("@@@@@@hashlist ResInfo@@@@@@@@@" + hashlist);
		String callback = util.getJsonCallBackString("", list);
		System.out.println("callback::" + callback);
		return list;

	}

	@GetMapping("/list")
	public void ResInfo(String RES_CODE, Model model) {
		model.addAttribute("list");
		log.info(RES_CODE);
	}

	@GetMapping("/UpdateRes")
	public void UpdateRes() {

	}

	@GetMapping("/get")
	public void get(String RES_CODE, Model model) {
		model.addAttribute("get");
	}

	@GetMapping("/UpdateMenu")
	public void UpdateMenu() {

	}

	@GetMapping("/deleteMenu")
	public void deleteMenu() {

	}

	@GetMapping("/deleteRes")
	public void deleteRes() {

	}
}
