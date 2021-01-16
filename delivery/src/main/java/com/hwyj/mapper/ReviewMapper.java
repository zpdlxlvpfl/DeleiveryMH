package com.hwyj.mapper;

import java.util.List;

import com.hwyj.domain.ReviewVO;

public interface ReviewMapper {
	
	//리뷰 등록 (주문내역 있는 id만 가능)
	public int insertReview(ReviewVO reviewVO);
	
	//리뷰 수정 (review_no이랑 id로)
	public int updateReview(ReviewVO reviewVO);
	
	//리뷰 삭제 (review_no이랑 id로)
	public int deleteReview(ReviewVO reviewVO);
	
	//매장 리뷰 목록 불러오기
	public List<ReviewVO> getReviewList(String res_code);
	
	//매장 평균별점
	public double getRate(String res_code);

}
