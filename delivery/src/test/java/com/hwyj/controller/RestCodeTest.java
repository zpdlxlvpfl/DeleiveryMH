package com.hwyj.controller;


import java.text.DecimalFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hwyj.domain.OrderVO;
import com.hwyj.domain.ResMenuVO;
import com.hwyj.domain.ResVO;
import com.hwyj.service.RestaurantService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
public class RestCodeTest {
	
	 
	   @Setter(onMethod_ = @Autowired)
	   private RestaurantService restaurantService;
	   
	@Test
	  public void reshome(HttpSession session, ResVO resvo, ResMenuVO menuVO) throws Exception {
	    
	     
	     resvo = (ResVO)session.getAttribute("res_code");  
	     
	     String res_code = resvo.getRES_CODE();
	     
	     Calendar cal = Calendar.getInstance();
	     int year = cal.get(Calendar.YEAR);
	     String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	     String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
	     String subNum = "";
	     
	     log.info(resvo);
	     
	     for(int i = 1; i <= 6; i ++) {
	      subNum += (int)(Math.random() * 10);
	     }
	     
	     res_code = ymd + "_" + subNum;
	     
	     resvo.setRES_CODE(res_code);
	      
	     restaurantService.insertres(resvo);
	     
	     System.out.println(resvo.getRES_CODE());
	     System.out.println(res_code);
	     // return "redirect:/reshome";  
	}

}
