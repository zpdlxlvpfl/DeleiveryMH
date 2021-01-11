package com.hwyj.domain;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter
@ToString
public class PageDTO {
	
	private int startPage; //화면에 보여지는 페이지이동 시작값
	private int endPage; //화면에 보여지는 페이지이동 끝값
	private boolean prev, next; //이전, 다음 표시
	
	private int total; //전체데이터 수
	private Criteria criteria; //현재페이지, 한페이지에 보여줄 개수
	
	
	public PageDTO(Criteria criteria, int total) { //생성자
		this.criteria=criteria;
		this.total=total;
		
		//페이지바에 페이지개수를 10개씩 보여줌
		endPage = (int)(Math.ceil(criteria.getPageNum()/10.0)) * 10;
		startPage = endPage-9 ;
		
		int realEnd=(int)(Math.ceil((total*1.0) / criteria.getAmount())); //실제 마지막페이지
		
		if(realEnd < endPage) { //실제 끝페이지가 endPage보다 작으면 
			endPage=realEnd;
		}
		
		prev=startPage > 1; //1일 때만 안나옴
		
		next=endPage < realEnd; //제일 끝 페이지 전까지는 계속 보임
		
		
	}
	
	
}
