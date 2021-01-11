package com.hwyj.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hwyj.domain.ReviewVO;
import com.hwyj.mapper.ReviewMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewMapper reviewMapper;

	@Override //리뷰 등록
	public boolean registerReview(ReviewVO reviewVO) {
		
		return reviewMapper.insertReview(reviewVO)==1;
	}
 
	@Override //매장 리뷰 목록
	public List<ReviewVO> getReviewList(String res_code) {
	
		return reviewMapper.getReviewList(res_code);
	}

	@Override //매장 평균별점
	public String getRate(String res_code) {
		
		DecimalFormat form = new DecimalFormat("#.#"); //소수점 첫째자리까지만		
		
		return form.format(reviewMapper.getRate(res_code));
	}

}
