package com.hwyj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.OrderVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ReviewVO;
import com.hwyj.service.CartService;
import com.hwyj.service.OrderService;
import com.hwyj.service.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/cart/*")
@AllArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_MEMBER')") // 일반사용자 전용 페이지
public class CartController {

	private CartService cartService;

	@GetMapping("myCart")
	public void myCart() {

	}
	/*
	 * @GetMapping("myCart") // 장바구니 페이지 public void myCart(Authentication
	 * authentication, Model model) {
	 * 
	 * }
	 */

//	  @RequestMapping(value = "/myCart", method = RequestMethod.GET, produces ="application/json; charset=utf8")
//		public void menuList(ModelMap model,Authentication authentication, ResMenuVO menuvo) throws Exception {
//			HashMap<String, Object> hashMap = new HashMap<>();	//HashMap 인스턴스화
//			List<ResMenuVO> list = new ArrayList<>();				//List 인스턴스화
//			
//			list =  restaurantService.menuList();
//			hashMap.put("HashMapList", list);
//			model.addAttribute("HashMapList", list);
//			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//			System.out.println("model@@@@@@@@@@@@@@@@@@@@@" + model);
//			System.out.println("hashMap@@@@@@@@@@@@@@@@@@@@" + hashMap);
//		//	return "myCart";
//		}

	@GetMapping("cartTest")
	public void test() {

	}

	// 메뉴 페이지에서 res_code랑 res_menu_code랑 amount값 가져와야함(cartVO에 담아서)
	@GetMapping("insert") // 장바구니 담기(이미 다른 매장의 메뉴가 담겨있을 경우에는 담지 못함 + 동일한 메뉴코드를 담으려고 하면 수량을 합쳐줌)
	public String insert(Authentication authentication, CartVO cartVO, Model model, HttpSession session) {
		HashMap<String, Object> HashMapList = new HashMap<String, Object>();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		cartVO.setId(userDetails.getUsername()); // 현재 로그인한 사용자 id 셋팅

		if (cartService.ShoppingCart(cartVO) == false) { // 장바구니 담기
			// 이미 다른 매장 메뉴가 담겨있을 경우 등록 안되고 메세지 띄우기
			model.addAttribute("result", "장바구니에는 같은 가게의 메뉴만 담을 수 있습니다. 장바구니를 비워주세요");
		}
		session.setAttribute("cartList", cartService.cartList(userDetails.getUsername()));
		session.setAttribute("cart_no", cartVO.getCart_no());
		HashMapList.put("cart_no", cartVO.getCart_no());
		return "redirect:/cart/myCart"; // 보고있던 페이지로??????? (###수정해야됨###)
	}

//	@GetMapping("insert") //장바구니 담기 (주문하기 눌렀을 때) -메뉴 여러개 한번에 담기 테스트중
//	public String insert(CartVOList list) {
//		//String id=authentication.getName();
//		
//		//String id=(String)session.getAttribute("id");
//		//log.info("아이디 왜 없어"+id);
////		if(id!=null) {
//			
//			cartService.ShoppingCart(list);
//			return "redirect:/cart/myCart";
//			
////		}else {
////			return "redirect:/login";
////		}	
//	}

	@RequestMapping(value = "/OrderList", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	public List<String> OrderList(ModelMap model, RedirectAttributes rttr, HttpSession session,
			Authentication authentication, CartVO vo) throws Exception {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String id = userDetails.getUsername();
		// List<String> cartList = (List) session.getAttribute("cartList");
		rttr.getFlashAttributes();
		HashMap<String, Object> HashMapList = new HashMap<String, Object>();
		List<String> OrderList = new ArrayList<String>();
		UtilController util = new UtilController();
		OrderList = cartService.getList(id);

		// HashMapList.put("ID", userDetails.getUsername());
		HashMapList.put("OrderList", OrderList);
		model.addAttribute("OrderList", OrderList);
		rttr.addFlashAttribute("OrderList", OrderList);
		int a = (int) session.getAttribute("cart_no");
		System.out.println("cart_no" + a + vo);
		System.out.println("==22====OrderList=====\n" + OrderList);
		return OrderList;

	}

	@GetMapping("updateOrder")
	public String updateOrder(ModelMap model, RedirectAttributes rttr, HttpSession session,
			Authentication authentication) throws Exception {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String id = userDetails.getUsername();
		CartVO vo = new CartVO();
		int a = vo.getCart_no();
		rttr.getFlashAttributes();
		vo.setId(id);
		vo.setPayment("Y");
		vo.setCart_no(a);
		System.out.println("updateorder" + vo);
		System.out.println("--------" + cartService.updateOrder(vo));

		if (cartService.updateOrder(vo)) {
			rttr.addFlashAttribute("result", "Success");
		}

		return "forward:/cart/myOrderList";
		// return "forward:/restaurant/orderInfo";
	}

	@GetMapping("/myOrderList")
	public void myOrderList() {

	}

}