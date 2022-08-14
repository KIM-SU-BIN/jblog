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
	//logo file 가져오기
	public String getImg(String id) {
		System.out.println("BlogDao>getImg");
		
		String getImg = sqlSession.selectOne("blog.getImg", id);
				
		return getImg;
	}
	
	//블로그 수정(이미지 파일도 수정 가능)
	public int modify(BlogVo blogVo) {
		System.out.println("BlogDao>modify");
		
		//db로 넘기기
		int count = sqlSession.update("blog.modify", blogVo);
		
		return 0;
	}
	
	//내블로그 관리폼 수정
	public BlogVo getBasic(String id) {
		System.out.println("BlogDao>getBasic");
		
		//blogVo
		BlogVo blogVo = sqlSession.selectOne("blog.getBasic",id);
		
		return blogVo;
	}
	
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
