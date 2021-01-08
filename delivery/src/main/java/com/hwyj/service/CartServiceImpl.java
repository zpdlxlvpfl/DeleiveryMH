package com.hwyj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.CartVOList;
import com.hwyj.mapper.CartMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
	
	private CartMapper cartMapper;

	
//	@Override //장바구니 담기 서비스(이미 다른 매장의 메뉴가 담겨있을 경우에는 담지 못한다)
//	public boolean ShoppingCart(CartVO cartVO) {
//		
//		List<CartVO> cartList=cartMapper.cartList(cartVO.getId());
//		if(cartList.size()!=0) { //회원의 장바구니에 메뉴가 이미 있으면		
//			//장바구니에 있는 첫번째 메뉴의 메뉴코드로 검색해서 얻은 매장코드와
//			//담으려는 메뉴의 매장코드 값이랑 비교해서 같으면
//			if(cartVO.getRes_code().equals(cartMapper.compare(cartList.get(0).getRes_menu_code()))){			
//				return cartMapper.insertCart(cartVO)==1; //장바구니 담고 true 리턴
//			}else { //비교 결과 다르면 insert하지 않고 false 리턴
//				return false;
//			}
//		}else { //장바구니가 비어있으면
//			return cartMapper.insertCart(cartVO)==1; //장바구니 담고 true 리턴
//		}	
//	}
	
	//테스트중!!!!!
	@Override //장바구니 담기 서비스(이미 다른 매장의 메뉴가 담겨있을 경우에는 담지 못한다)
	public boolean ShoppingCart(CartVO cartVO) {

		List<CartVO> cartList=cartMapper.cartList(cartVO.getId());
		if(cartList.size()!=0) { //회원의 장바구니에 메뉴가 이미 있으면		
			//장바구니에 있는 첫번째 메뉴의 메뉴코드로 검색해서 얻은 매장코드와
			//담으려는 메뉴의 매장코드 값이랑 비교해서 같으면
			if(cartVO.getRes_code().equals(cartMapper.compare(cartList.get(0).getRes_menu_code()))){
				
				for(CartVO temp : cartList) { //장바구니에 있는 메뉴코드들 중에 담으려는 메뉴코드와 같은게 있으면
					if(temp.getRes_menu_code().equals(cartVO.getRes_menu_code())) {
						int sumAmount = temp.getAmount()+cartVO.getAmount(); //수량을 꺼내서 추가된 수량 더하기
						cartVO.setSumAmount(sumAmount);
						cartVO.setCart_no(temp.getCart_no());
						return cartMapper.sumAmount(cartVO)==1;
					}
				}
				return cartMapper.insertCart(cartVO)==1; //장바구니 담고 true 리턴
				
			}else { //비교 결과 다르면 insert하지 않고 false 리턴
				return false;
			}
		}else { //장바구니가 비어있으면
			return cartMapper.insertCart(cartVO)==1; //장바구니 담고 true 리턴
		}	
	}

	@Override //장바구니 보기 서비스
	public List<CartVO> cartList(String id) {
		log.info("장바구니 보기: "+cartMapper.cartList(id));
		return cartMapper.cartList(id);
	}

	@Override //장바구니 메뉴 수량 수정 서비스
	public boolean modifyAmount(CartVO cartVO) {
		
		return cartMapper.updateAmount(cartVO)==1;
	}

	@Override //장바구니 메뉴 삭제 서비스
	public boolean removeMenu(int cart_no) {
		
		return cartMapper.deleteMenu(cart_no)==1;
	}

	@Override //장바구니 전체삭제 서비스
	public boolean removeAll(String id) {
		
		return cartMapper.deleteAll(id)>=1; //삭제된게 1개 이상이면 true
	}


//	@Override //장바구니 (메뉴 한번에 여러개 넣는 서비스)
//	public int ShoppingCart(CartVOList cartVOList) {
//			
//		log.info("장바구니 한번에 여러개 담기----------");	
//		List<CartVO> cartList=cartVOList.getList();
//		
//		return cartMapper.insertCart(cartList);
//	}
	
	
	

}
