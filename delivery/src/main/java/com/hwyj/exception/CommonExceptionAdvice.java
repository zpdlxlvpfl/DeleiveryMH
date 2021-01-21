package com.hwyj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
//	//접근권한 (403)
//	@ExceptionHandler(AccessDeniedException.class)
//    public String handleAccessDeniedException(AccessDeniedException e) {
//        log.error("handleAccessDeniedException", e);
//        
//        return "/login";
//    }
	
	//자바코드에서 에러발생 시 (400)
	@ExceptionHandler(BindException.class) 
	public String except(Exception e, Model model) { 
		log.error("exception......."+e.getMessage());
		model.addAttribute("exception", e);
		log.error(model);
		return "/exception/error400";
	}
	
	
	//url요청에러 시 (404)
	@ExceptionHandler(NoHandlerFoundException.class) 
	@ResponseStatus(HttpStatus.NOT_FOUND) //404로 응답하라는 뜻
	public String handle404() {
		return "/exception/error404";
	}

}
