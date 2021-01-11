package com.hwyj.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
public class Criteria {

	private int pageNum; //페이지번호
	private int amount; //한페이지에 몇개를 보여줄지
	private String auth;


	public Criteria() { 
	    this(1, 10); //아무것도 없을 때는 1,10
	}

	public Criteria(int pageNum, int amount) { 
	    this.pageNum = pageNum;
	    this.amount = amount;
	}
	
	public Criteria(int pageNum, int amount, String auth) { //관리자-회원정보페이지 관련
	    this.pageNum = pageNum;
	    this.amount = amount;
	    this.auth = auth;
	}
	
	

	public int getPageNum() { //DB에서 limit에 연산이 안돼서 여기서 처리 
		
		return pageNum;
	}
	
	public int getStartNum() { //db에서 Limit의 시작값
		  
		return (pageNum-1)*amount; //ex>10개씩 보여줄 때 3페이지 보고싶다면 limit 20,10
	}

	public int getAmount() {
		return amount;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	

  
  
}
