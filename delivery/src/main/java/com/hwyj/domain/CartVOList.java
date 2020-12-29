package com.hwyj.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CartVOList {
	
	private List<CartVO> cartList;
	
	public CartVOList() {
		cartList = new ArrayList<CartVO>();
	}

}
