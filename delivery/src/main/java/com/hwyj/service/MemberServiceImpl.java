package com.hwyj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hwyj.domain.CustomerVO;
import com.hwyj.mapper.Custmapper;
import com.hwyj.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;

	//내정보 수정 서비스
	@Override
	public boolean modifyMyInfo(CustomerVO customerVO) {
		log.info("내정보수정:"+customerVO);
		return memberMapper.update(customerVO)==1; //수정처리가 정상적으로 되면 1리턴 -> 1==1이면 true
	}

	@Override //회원가입
	public int insertCustomer(CustomerVO csVO) {
		int a = memberMapper.insertCustomer(csVO);
		System.out.println(a);
		 return 0;
	}

	@Override //아이디 찾기(이메일, 이름으로)
	public CustomerVO findId(CustomerVO customerVO) {
		
		return memberMapper.findId(customerVO);
	}
	
	
	
	/*
	 * @Override public Integer selectCustomer (CustomerVO csVO) { int a =
	 * memberMapper.selectCustomer(csVO.getId()); if(a!=0) { a =2; } return a; }
	 */
	

}
