package com.hwyj.service;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwyj.domain.ReviewVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReviewServiceTest {
	
	@Autowired
	private ReviewService service;
	
	@Test //리뷰 등록 서비스 테스트
	public void testInsertReview() {
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setId("user15");
		reviewVO.setRes_code("res_01");
		reviewVO.setContent("콜라가 시원함");
		reviewVO.setRate(5);
		
		log.info("리뷰등록: "+service.registerReview(reviewVO));
	}
	
	@Test //매장 리뷰 목록
	public void testGetReviewList() {
		List<ReviewVO> reviewList = service.getReviewList("res01");
		for(ReviewVO temp : reviewList) {
			log.info("리뷰목록: "+temp);
		}
	}
	
//	@Test //매장 평균별점
//	public void testGetRate() {
//		
//		log.info("평균 별점은? "+service.getRate("res01"));
//	}

}
