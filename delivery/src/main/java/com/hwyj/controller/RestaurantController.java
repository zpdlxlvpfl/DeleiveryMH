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
@PreAuthorize("hasAnyRole('ROLE_RES')")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	// 식당 기본페이지
	@GetMapping("res") // 페이지 이름 뭘로하지????
	public void res(Model model) {
	}
	
	
	//test 
	@RequestMapping(value = "test", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String tset(String RES_CODE,ModelMap model,RedirectAttributes rttr) throws Exception {
		HashMap<String, Object> hashMap = new HashMap<>();
		List<String> list = new ArrayList<>();

		list = restaurantService.restList();
		hashMap.put("RestList", list);

		System.out.println(list+"RestList@@@@@@@@@@@@@");
		model.addAttribute("RestList", list);
		return "/restaurant/test";
	}
	
	
	
	
	

	@GetMapping("/reswrite")
	public void reswrite() {

	}

	@GetMapping("/reshome")
	public void reshome(String RES_CODE,Model model,HttpSession session, RedirectAttributes rttr) throws Exception {
		ResVO vo = new ResVO ();
		AuthVO authVO = new AuthVO();
	}

	@GetMapping("/menuwrite")
	public void menuwrite() {

	}

	
	// 매장 등록
	@RequestMapping(value = "/insertres", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String insertres(ResMenuVO menuvo,HttpSession session, ResVO resvo,Model model,RedirectAttributes rttr) {
		 String RES_ROLE = (String)session.getAttribute("RES_ROLE");
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		 
		String RES_CODE = ymd + "_" + subNum;
		resvo.setRES_CODE(RES_CODE);
		restaurantService.insertres(resvo);
		log.info(RES_CODE);
		System.out.println(resvo);
		rttr.addAttribute("insertres");
		//session.setAttribute("RES_CODE",resvo.getRES_CODE());
		return "redirect:/restaurant/insertmenu";
	}

	

	 // 메뉴 등록
	@RequestMapping(value = "insertmenu", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public String insertmenu(ResMenuVO menuvo,RedirectAttributes rttr) {
		// HttpSession session = null;
		// String RES_CODE = (String)session.getAttribute("RES_CODE");
		 rttr.getFlashAttributes();

		 ResVO vo = new ResVO();
		 
		 String RES_CODE = vo.getRES_CODE();
		 
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
		  subNum += (int)(Math.random() * 10);
		 }
		
		String res_menu_code = ymd + "_Menu" + subNum;
		menuvo.setRes_menu_code(res_menu_code);
		menuvo.setRES_CODE(RES_CODE);
		
		restaurantService.insertmenu(menuvo);
		System.out.println(menuvo);
		
		return "redirect:/restaurant/reshome";
	
	}
	
	

	// 메뉴목록보기 
	  @RequestMapping(value = "menuList", method = RequestMethod.GET, produces ="application/json; charset=utf8")
		public String menuList(String RES_CODE,ModelMap model, ResMenuVO menuvo,RedirectAttributes rttr) throws Exception {
		    //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		  //  HttpSession session = null;
		    //String RES = (String)session.getAttribute("RES_CODE");
		    rttr.getFlashAttributes(); 
		    List<String> list = new ArrayList<>();	
			list =  restaurantService.menuList();
			model.addAttribute("menuList",list);
			restaurantService.read(RES_CODE);
			//rttr.addAttribute("RES_CODE", RES_CODE);
			return "/restaurant/menuList";
		}
	
	

	
	  @RequestMapping(value = "restList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
		public String restList(String RES_CODE,ModelMap model,RedirectAttributes rttr) throws Exception {
		 // HttpSession session = null;
		 // String RES = (String)session.getAttribute("RES_CODE");
		    rttr.getFlashAttributes(); 
		    List<String> list = new ArrayList<>();
			list = restaurantService.restList();
			System.out.println(list+"RestList@@@@@@@@@@@@@");
			model.addAttribute("RestList", list);
			//rttr.addAttribute("RES_CODE", RES_CODE);
			return "/restaurant/restList";
		}
	  
	
	@RequestMapping(value = "ResInfo", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public void ResInfo(Authentication auth,Model model) {
		
		UserDetails resdetails = (UserDetails)auth.getPrincipal();
		model.addAttribute("ResInfo",restaurantService.read(resdetails.getUsername()));
}
}

