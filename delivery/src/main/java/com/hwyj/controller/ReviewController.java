package com.hwyj.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hwyj.domain.CartVO;
import com.hwyj.domain.ReviewVO;
import com.hwyj.service.ReviewService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/review/")
@AllArgsConstructor
public class ReviewController {
	
	private ReviewService reviewService;
	
	//리뷰 등록
	@PostMapping(value="/register", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> registerReview(@RequestBody ReviewVO reviewVO, Authentication authentication){
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		reviewVO.setId(userDetails.getUsername()); //로그인한 사용자 아이디
		
		boolean register=reviewService.registerReview(reviewVO);
		
		return register==true ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//리뷰 수정
	@RequestMapping(method= { RequestMethod.PUT, RequestMethod.PATCH }, value="/{review_no}",
			consumes="application/json", produces= { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody ReviewVO reviewVO, @PathVariable("review_no") int review_no, Authentication authentication){
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		reviewVO.setId(userDetails.getUsername()); //로그인한 사용자 아이디
		reviewVO.setReview_no(review_no); //리뷰번호
		
		return reviewService.modifyReview(reviewVO)==true
				? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	//리뷰 삭제
	@DeleteMapping(value="/{review_no}", produces= { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("review_no") int review_no, Authentication authentication){
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setId(userDetails.getUsername()); //로그인한 사용자 아이디
		reviewVO.setReview_no(review_no); //리뷰번호
		
		return reviewService.removeReview(reviewVO)==true
				? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//매장 리뷰 목록
	@GetMapping(value="/reviewList/{res_code}", produces= { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<ReviewVO>> getReviewList(@PathVariable("res_code") String res_code){
		
		List<ReviewVO> reviewList=reviewService.getReviewList(res_code);

		return new ResponseEntity<>(reviewList, HttpStatus.OK);
	}


}
