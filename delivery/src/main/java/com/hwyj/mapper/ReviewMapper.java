package com.hwyj.mapper;

import java.util.List;

import com.hwyj.domain.ReviewVO;

public interface ReviewMapper {
	
	//리뷰 등록
	public int insertReview(ReviewVO reviewVO);
	
	//매장 리뷰 목록 불러오기
	public List<ReviewVO> getReviewList(String res_code);
	
	//매장 평균별점
	public double getRate(String res_code);

}
