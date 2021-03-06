package com.hwyj.service;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;  

import com.hwyj.domain.CustomerVO;
import com.hwyj.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;
	
	//내정보 보기 서비스
	@Override
	public CustomerVO getMyInfo(String id) {
		
		return memberMapper.read(id);
	}
	
	//내정보 수정 서비스
	@Override
	public boolean modifyMyInfo(CustomerVO customerVO) {
		log.info("내정보수정:"+customerVO);
		return memberMapper.update(customerVO)==1; //수정처리가 정상적으로 되면 1리턴 -> 1==1이면 true
	}
	

	@Override //회원가입 +권한등록
	public int insertCustomer(CustomerVO csVO) {		
		int a = memberMapper.insertCustomer(csVO);
		int b = memberMapper.insertAuth(csVO); //(권한등록)
		int c = a+b;
		System.out.println(a);
		if(c==2) {
			return 1;
		}
		 return 0;
	}
	
	
	@Override
	
	public boolean updateowner(CustomerVO customerVO) {
	
		return memberMapper.updateowner(customerVO)==1;
	}
	
	@Override
	public String enabled(CustomerVO csVO) {
		String a = memberMapper.enabled(csVO);
		System.out.println(a);
		return "";
	} 

	@Override //아이디 찾기(이메일, 이름으로)
	public CustomerVO findId(CustomerVO customerVO) {
		
		return memberMapper.findId(customerVO);
	}
	
	@Override //비밀번호 찾기(이메일,이름,아이디로 해당회원 있는지 확인)
	public boolean findPw(CustomerVO customerVO) {
		
		return memberMapper.findPw(customerVO)==1;
	}
	
	@Override //비밀번호 변경
	public boolean updatePw(CustomerVO customerVO) {
		PasswordEncoder pwencoder=new BCryptPasswordEncoder();
		//회원이 새로 입력한 비밀번호를 가져와서 암호화한 후 다시 비밀번호 셋팅
		customerVO.setPw(pwencoder.encode(customerVO.getPw()));
		return memberMapper.updatePw(customerVO)==1;
	}
	
	@Override //비밀번호 체크
	public boolean checkPw(CustomerVO customerVO) {
		PasswordEncoder pwencoder=new BCryptPasswordEncoder();	
		//회원이 입력한 비밀번호와 회원 id로 검색해서 나온 비밀번호 비교
		return pwencoder.matches(customerVO.getPw(), memberMapper.checkPw(customerVO.getId()));
	}
	
	@Override //회원 탈퇴 서비스
	public boolean withdrawal(String id) {
		
		return memberMapper.withdrawal(id)==1;
	}
	
	@Override
	public String selectCustomer(CustomerVO csVO) {
		memberMapper.selectCustomer(csVO);
		System.out.println(csVO);
		return "";
	}

	
	
	/*
	 * @Override public Integer selectCustomer (CustomerVO csVO) { int a =
	 * memberMapper.selectCustomer(csVO.getId()); if(a!=0) { a =2; } return a; }
	 */
	

}
