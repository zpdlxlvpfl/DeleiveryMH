package com.hwyj.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CartVOList {
	
	private List<CartVO> list;
	
	public CartVOList() {
		list = new ArrayList<>();
	}

}
