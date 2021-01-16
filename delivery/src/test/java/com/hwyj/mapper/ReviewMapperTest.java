package com.hwyj.mapper;

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
public class ReviewMapperTest {
	
	@Autowired
	private ReviewMapper mapper;
	
	@Test //리뷰 등록 테스트
	public void testInsertReview() {
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setId("user30");
		reviewVO.setRes_code("res_02");
		reviewVO.setContent("피클이 맛있어요");
		reviewVO.setRate(5);
		
		log.info("리뷰 등록 "+mapper.insertReview(reviewVO));
	}
	
	@Test //리뷰 수정 테스트
	public void testUpdateReview() {
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setId("user0");
		reviewVO.setReview_no(6);
		reviewVO.setContent("그럭저럭 괜찮아요");
		reviewVO.setRate(3);
		mapper.updateReview(reviewVO);
	}
	
	@Test //리뷰 삭제 테스트
	public void testDeleteReview() {
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setId("user4");
		reviewVO.setReview_no(4);
		mapper.deleteReview(reviewVO);
	}
	
	@Test //매장 리뷰 목록 불러오기
	public void testGetReviewList() {
		
		List<ReviewVO> reviewList = mapper.getReviewList("res01");
		for(ReviewVO temp : reviewList) {
			log.info("리뷰목록: "+temp);
		}
	}
	
	@Test //매장 평균 별점
	public void testGetRate() {
		log.info("res01매장의 별점은: "+mapper.getRate("res01"));
	}

}
