package com.hwyj.service;

import java.util.List;

import com.hwyj.domain.ReviewVO;

public interface ReviewService {
	
	//리뷰 등록
	public boolean registerReview(ReviewVO reviewVO);
	
	//리뷰 수정 (review_no이랑 id로)
	public boolean modifyReview(ReviewVO reviewVO);
	
	//리뷰 삭제 (review_no이랑 id로)
	public boolean removeReview(ReviewVO reviewVO);
	
	//매장 리뷰 목록 불러오기
	public List<ReviewVO> getReviewList(String res_code);
	
	//매장 평균별점
	public String getRate(String res_code);

}
