package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	//필드
	@Autowired
	SqlSession sqlSession;
	
	//생성자
	
	//메소드
	
	//메소드 일반
	
	//회원가입시 블로그 생성
	
	//메인화면
	public Map<String, Object> getBlog(String id) {
		System.out.println("BlogDao>getBlog");
		
		Map<String, Object> blogMap = sqlSession.selectOne("blog.getBlog",id);
		
		return blogMap;
	}
	
	
	//join (로그인시 블로그 생성)
	public int join(BlogVo blogVo) {
		System.out.println("BlogDao>join");
		
		int count = sqlSession.insert("blog.insert", blogVo);
		
		return count;
	}

}
