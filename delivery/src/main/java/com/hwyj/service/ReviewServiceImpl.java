package com.hwyj.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	@Override //리뷰 등록 (주문내역 있는 id만 가능)
	public boolean registerReview(ReviewVO reviewVO) {
		
		return reviewMapper.insertReview(reviewVO)==1;
	}
	
	@Override //리뷰 수정
	public boolean modifyReview(ReviewVO reviewVO) {
		
		return reviewMapper.updateReview(reviewVO)==1;
	}

	@Override //리뷰 삭제
	public boolean removeReview(ReviewVO reviewVO) {
		
		return reviewMapper.deleteReview(reviewVO)==1;
	}
 
	@Override //매장 리뷰 목록 + 평균별점 +별점 별모양으로 바꿔주기 +날짜포맷 바꾸기
	public List<ReviewVO> getReviewList(String res_code) {
		
		DecimalFormat form = new DecimalFormat("#.#"); //소수점 첫째자리까지만
		form.format(reviewMapper.getRate(res_code));
		
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd"); //날짜포맷
		
		List<ReviewVO> reviewList=reviewMapper.getReviewList(res_code);
		
		if(reviewList.size()!=0) { //리뷰리스트가 있다면
			reviewList.get(0).setAvgRate(form.format(reviewMapper.getRate(res_code))); //평균 별점
			
			for(ReviewVO temp : reviewList) { 			
				temp.setS_date(format.format(temp.getReview_date())); //리뷰 작성일 포맷 바꾸기
				
				for(int i=1; i<=5; ++i) { //리뷰리스트에서 별점 찾아서 별점 숫자만큼 별모양 찍기	
					if(temp.getRate()==i) {
						temp.setS_Rate(i);
					}
				}			
			}
		}
		
		return reviewList;
	}
	

}
