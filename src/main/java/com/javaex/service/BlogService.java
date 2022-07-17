package com.javaex.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;

@Service
public class BlogService {

	//필드
	@Autowired
	BlogDao blogDao;

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
