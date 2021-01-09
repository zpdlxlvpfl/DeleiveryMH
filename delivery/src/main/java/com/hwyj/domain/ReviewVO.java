package com.hwyj.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	
	private int review_no; //리뷰번호
	private String id; //리뷰 쓴 사람 아이디
	private String m_name; //리뷰 쓴 사람 이름
	private String res_code; //매장
	private String content; //리뷰 내용
	private Date review_date; //리뷰쓴날짜
	private double rate; //별점
	private double avgRate; //평균별점
}
