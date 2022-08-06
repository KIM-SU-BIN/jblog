package com.javaex.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	//필드
	@Autowired
	BlogDao blogDao;
	
	//내블로그 관리폼 수정
	public BlogVo getBasic (String id) {	
		System.out.println("BlogService>getBasic");
		
		//blogVo
		BlogVo blogVo = blogDao.getBasic(id);
		
		return blogVo;
	}
	
	

	//메인화면
	public Map<String, Object> getBlog(String id) {
		System.out.println("BlogService>getBlog");
		
		Map<String, Object> blogMap = blogDao.getBlog(id);
		
		return blogMap;
	}
	
	//생성자
	
	//메소드
	
	//메소드 일반

}
