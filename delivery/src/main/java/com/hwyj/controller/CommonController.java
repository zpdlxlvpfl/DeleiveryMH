package com.hwyj.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
   private EmailService emailService;
   
   @Setter(onMethod_ = @Autowired)
   private RestaurantService restaurantService;

   // 로그인 테스트용 나중에 지우기
   @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')") // auth가 ROLE_ADMIN이랑 ROLE_MEMBER일때만 페이지 열 수 있음
   @GetMapping("/test/securityTest") // 이 주소 요청하면 아래 /login 페이지 열림
   public void securityTest() {

   }

   @GetMapping("/login") // 로그인 페이지
   public void login(String error, Model model) {
      log.info("에러: "+error);
      if(error != null) { //로그인실패
         model.addAttribute("error", "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
      }

   }

   @PostMapping("/logout") // 로그아웃 버튼 누르면 로그아웃 되고 로그인페이지로 이동
   public String logout() {
      return "redirect:/login";
   }
   
   @GetMapping("findId") //아이디 찾기
   public void findId() {
      
   }
   
//   @PostMapping("findId")
//   public String findIdSuccess(CustomerVO customerVO, RedirectAttributes rttr) {
//      CustomerVO cusVO=memberservice.findId(customerVO); //아이디 찾기(아이디, 이메일)
//      if(cusVO!=null) { //해당 회원이 있으면
//         EmailVO emailVO = new EmailVO();
//         emailVO.setReceiveMail(cusVO.getEmail()); //회원정보에 있는 메일로
//         emailVO.setContent(cusVO.getId()); //아이디 보내기
//         emailService.sendEmail(emailVO, "findId");   
//         rttr.addFlashAttribute("result","메일을 발송했습니다. 메일을 확인해주세요."); //메일 발송하면 나오는 메세지
//         return "redirect:/findId";
//      }else {
//         rttr.addFlashAttribute("result","회원정보를 찾을 수 없습니다."); //회원 정보가 없으면 나오는 메세지
//         return "redirect:/findId";
//      }   
//   }
   
   @GetMapping("/findPw")
   public void findPw() {
	   
   }
   
//   @PostMapping("findPw2")
//   public String findPwPost(@RequestBody CustomerVO customerVO) {
//	   
//	   boolean a=false;
//		if(memberservice.findPw(customerVO)) {
//			System.out.println("멤버있음!!!");
//			a=true;
//		}else {
//			System.out.println("없는회원!!!!!!!!!!");
//		}
//	   System.out.println(a);
//	   return "/findPw2";
//   }

   @GetMapping("/join") // 가입
   public void join() {

   }

	//메뉴목록보기 (템플릿 메인 사진 아래)
   @RequestMapping(value = "/index", method = RequestMethod.GET, produces ="application/json; charset=utf8")
	public String menuList(ModelMap model, ResMenuVO menuvo) throws Exception {
		HashMap<String, Object> hashMap = new HashMap<>();	//HashMap 인스턴스화
		List<String> list = new ArrayList<>();				//List 인스턴스화
		
		list =  restaurantService.menuList();
		hashMap.put("HashMapList", list);
		model.addAttribute("HashMapList", list);
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println("model@@@@@@@@@@@@@@@@@@@@@" + model);
		System.out.println("hashMap@@@@@@@@@@@@@@@@@@@@" + hashMap);
		return "index";
	}
   

	
	
	@GetMapping("/get")
	public void get(String res_code,String res_menu_code,Model model,ResMenuVO menuvo) {
		model.addAttribute("res_code",restaurantService.get(res_code));
		model.addAttribute("menucode",restaurantService.menuread(res_menu_code));
		System.out.println(model.addAttribute("res",restaurantService.get(res_code)));
		System.out.println(model.addAttribute("res_menu_code",restaurantService.menuread(res_menu_code)));
	}


   @GetMapping("/maptest") // 현재위치 테스트중
   public void maptest() {

   }

   @GetMapping("/foodmaptest") // 음식점 마커
   public void foodmaptest() {

   }

   @GetMapping("/accessError") // 403페이지 (접근제한) //accessError.jsp 수정 해야됨//
   public void accessDenied(Authentication auth) {

      // log .info(auth);
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
//      if (check == "0") {   //패스워드 암호화
//         check = "0";
//      } else {
         check = "0";
         PasswordEncoder encode = new BCryptPasswordEncoder();
         csVO.setPw(encode.encode(csVO.getPw()));
   
         int check2 = memberservice.insertCustomer(csVO);
         check = check2 + "";
   
      //}
      return check + "";
      }
   
   
}

   

      