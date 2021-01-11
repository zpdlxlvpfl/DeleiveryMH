package com.hwyj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public interface AllListDao {

	
	public HashMap<String,Object> selectAllRow(); 
	
	
	}
