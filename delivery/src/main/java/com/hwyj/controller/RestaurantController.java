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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.AuthVO;
import com.hwyj.domain.CartVO;
import com.hwyj.domain.CustomerVO;
import com.hwyj.domain.OrderVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.domain.ReviewVO;
import com.hwyj.mapper.MemberMapper;
import com.hwyj.mapper.RestaurantMapper;
import com.hwyj.service.MemberService;
import com.hwyj.service.RestaurantService;
import com.mysql.cj.xdevapi.Result;

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

	@Setter(onMethod_ = @Autowired)
	private MemberService member;


	@GetMapping("/reswrite")
	public void reswrite() { //매장등록

	}


	
	@RequestMapping(value = "/menuread", method = RequestMethod.GET, produces = "application/json; charset=utf8") //메뉴 갖고오기
	public String menuread(@RequestParam("res_code") String res_code, ModelMap model, ResMenuVO menuvo,
			RedirectAttributes rttr, Authentication authentication) throws Exception {
		rttr.getFlashAttributes();
		model.addAttribute("RES_CODE", restaurantService.menuread(res_code));
		log.info(restaurantService.menuread(res_code));
		return res_code;
	}

	@GetMapping("/menuwrite") //메뉴등록
	public void menuwrite() {

	}
	
	

	// 매장 등록
	@RequestMapping(value = "/insertres", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String insertres(Authentication authentication, ResMenuVO menuvo, HttpSession session, ResVO resvo, 
			Model model, RedirectAttributes rttr,CustomerVO cu) {
		String RES_ROLE = (String) session.getAttribute("RES_ROLE");
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		
		Calendar cal = Calendar.getInstance();
		CustomerVO vo = new CustomerVO();

		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";

		for (int i = 1; i <= 6; i++) {
			subNum += (int) (Math.random() * 10);
		}

		String RES_CODE = ymd + "_" + subNum;

		resvo.setRES_CODE(RES_CODE);
		cu.setId(userDetails.getUsername());
		cu.setRes_code(RES_CODE);
		restaurantService.insertres(resvo);
		log.info(RES_CODE);
		System.out.println(resvo);
		// rttr.addAttribute("insertres");
		session.setAttribute("RES_CODE", resvo.getRES_CODE());
		System.out.println(session);
		return "redirect:/restaurant/menuwrite";
	}

	
	
	//메뉴 목록겸 관리페이지
	@RequestMapping(value = "menuList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public ModelAndView menuList(ModelMap model, ResMenuVO menuvo, RedirectAttributes rttr, Authentication authentication,
			@RequestParam(value = "RES_CODE", required = false) String RES_CODE, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView();
		rttr.getFlashAttributes();
		UtilController util = new UtilController();
		HashMap<String, Object> HashMapList = new HashMap<>();
		List<ResMenuVO> menuList = new ArrayList<>();
		menuList = restaurantService.menuList();
		menuvo.setRES_CODE(RES_CODE);
		menuList = restaurantService.menuread(RES_CODE);
		HashMapList.put("HashMapList", menuList);
		model.addAttribute("menuList", menuList);
		model.addAttribute("res_menu_code", menuvo.getRes_menu_code());
		model.addAttribute("RES_CODE"+ menuvo.getRES_CODE());
		restaurantService.menuread(RES_CODE);
		System.out.println(menuList + "LIST@@@@@@@@@@@@@@@@@@@");
		rttr.addFlashAttribute("RES_CODE", menuvo.getRES_CODE());
		RES_CODE = menuvo.getRES_CODE();
		session.setAttribute("RES_CODE", RES_CODE);
		mav.addObject("menuList", menuList);
		mav.addObject("RES_CODE", menuvo.getRES_CODE());
		mav.addObject("res_menu_code", menuvo.getRes_menu_code());
		
		;
		return mav;
		// return "restaurant/menuList";
	}
	// 메뉴 등록
		@RequestMapping(value = "insertmenu", method = RequestMethod.GET, produces = "application/json; charset=utf8")
		public String insertmenu(ResMenuVO menuvo, HttpSession session, RedirectAttributes rttr, ModelMap model,
				Authentication authentication) {
			// HttpSession session = null;
			// String RES_CODE = (String)session.getAttribute("RES_CODE");
			ModelAndView mav = new ModelAndView();
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
			model.addAttribute("RES_CODE", menuvo);
			menuvo.setRES_CODE(RES_CODE);

			restaurantService.insertmenu(menuvo);
			System.out.println(menuvo);
			System.out.println(session + "RESROLE@@@@@@@@@@@@\n" + RES_ROLE);
			System.out.println(RES_CODE+ "RES_CODE@@");

			return "redirect:/restaurant/restList";

		}

	//매장리스트
	@RequestMapping(value = "restList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public List<ResVO> restList(ModelMap model, RedirectAttributes rttr, HttpSession session, String res_code,
			Authentication authentication) throws Exception {
		ResVO vo = new ResVO();
		rttr.getFlashAttributes();
		List<ResVO> restList = new ArrayList<>();
		restList = restaurantService.restList();

		System.out.println(restList + "RestList@@@@@@@@@@@@@");
		model.addAttribute("restList", restList);
		model.addAttribute("RES_CODE", restaurantService.menuread(res_code));
		System.out.println("=======list====" + restList);
		session.setAttribute("RES_CODE", res_code);
		return restList;
	}



	@GetMapping("/UpdateRes")
	public void UpdateRes(ResVO resvo) {
		restaurantService.UpdateRes(resvo);

	}

	@GetMapping("/get")
	public void get(String RES_CODE, Model model) {
		model.addAttribute("get");
	}

	@RequestMapping(value = "/updateMenu", method = RequestMethod.GET)
	@ResponseBody
	public ResMenuVO UpdateMenu(ResMenuVO menuvo, String res_code, ModelMap model, String res_menu_code,
			RedirectAttributes rttr) {
		rttr.getFlashAttributes();
        ModelAndView mav = new ModelAndView();
      
		ResMenuVO read = restaurantService.read(menuvo.getRes_menu_code());
		restaurantService.UpdateMenu(menuvo);

		if (restaurantService.UpdateMenu(menuvo))
			rttr.addFlashAttribute("res_menu_code", menuvo);
			mav.addObject("RES_CODE", read.getRES_CODE());
		System.out.println("업뎃 read" + restaurantService.read(menuvo.getRes_menu_code()));
		System.out.println(read + "@@@@@@@@" + read.getRES_CODE());
		return read;
	}

	@RequestMapping(value = "/deleteMenu", method = RequestMethod.GET)
	@ResponseBody
	public ResMenuVO deleteMenu(@RequestParam(value = "res_menu_code", required = false) String res_menu_code,
			String RES_CODE, RedirectAttributes rttr, Model model, ResMenuVO menuvo) throws Exception {
		rttr.getFlashAttributes();
        ModelAndView mav = new ModelAndView();
		ResMenuVO read = restaurantService.read(menuvo.getRes_menu_code());
		read.setRES_CODE(menuvo.getRES_CODE());
		restaurantService.deleteMenu(menuvo);
		if (restaurantService.deleteMenu(menuvo))
			rttr.addFlashAttribute("res_menu_code", menuvo);
		model.addAttribute("delete", menuvo);
		String url = "/restaurant/menuList?RES_CODE="+read.getRES_CODE();
		mav.addObject("URL", url);
		System.out.println("================\n" + res_menu_code + read + RES_CODE);
		System.out.println(restaurantService.deleteMenu(menuvo));
		System.out.println(read + "@@@@@@@@" + menuvo.getRES_CODE());

		return read;

	}


	
	

	@RequestMapping(value = "menu_pop_up", method = RequestMethod.GET)
	public String user_pop_up(@RequestParam("res_menu_code") String res_menu_code, Model model) {

		ResMenuVO menuvo = restaurantService.read(res_menu_code);
		model.addAttribute("RES_CODE", menuvo);
		System.out.println("@@@@@@@@@model@@@@@@@@" + model);
		System.out.println("팝업" + restaurantService.read(res_menu_code));

		return "restaurant/menu_pop_up";
	}
	
	
	
	
	
	@RequestMapping(value = "res_pop_up", method = RequestMethod.GET)
	public String rest_pop_up(@RequestParam("RES_CODE") 
		String RES_CODE,String res_menu_code, Model model) throws Exception {

		ResVO vo = restaurantService.ResInfo(RES_CODE);
		model.addAttribute("RES_CODE", vo);
		System.out.println("@@@@@@@@@model@@@@@@@@" + model);
		System.out.println("팝업" + restaurantService.ResInfo(RES_CODE));

		return "restaurant/res_pop_up";
	}
	
	

	@RequestMapping(value = "/deleteRes", method = RequestMethod.GET)
	public String deleteRes(@RequestParam(value = "RES_CODE", required = false) String RES_CODE,
			RedirectAttributes rttr, Model model, ResVO vo,ResMenuVO menuvo) throws Exception {
		rttr.getFlashAttributes();
		ResVO resRead = restaurantService.ResInfo(RES_CODE);
		resRead.setRES_CODE(vo.getRES_CODE());
		restaurantService.deleteRes(vo);
		if (restaurantService.deleteRes(vo))
			rttr.addFlashAttribute("res_code", vo);
		model.addAttribute("deleteres", vo);

		System.out.println("================\n" +  RES_CODE);
		System.out.println(restaurantService.deleteRes(vo));

		return "redirect:/restaurant/restList";

	}
	

	@RequestMapping(value = "/updateRes", method = RequestMethod.GET)
	@ResponseBody
	public ResVO Updateres(ResMenuVO menuvo,ResVO vo, String RES_CODE, ModelMap model, String res_menu_code,
			RedirectAttributes rttr) throws Exception {
		rttr.getFlashAttributes();
		ResVO resRead = restaurantService.ResInfo(RES_CODE);
		restaurantService.UpdateRes(vo);

		if (restaurantService.UpdateRes(vo))
			rttr.addFlashAttribute("res_code", vo);

		System.out.println("업뎃 read" + restaurantService.read(menuvo.getRes_menu_code()));
		System.out.println("================\n" + res_menu_code +  RES_CODE);
		System.out.println("update@@@" + restaurantService.UpdateRes(vo));

		return resRead;
	}	


}
