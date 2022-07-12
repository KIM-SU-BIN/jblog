package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	//필드
	@Autowired
	SqlSession sqlSession;
	
	//생성자
	
	//메소드
	
	//메소드 일반
	
	//블로그 생성후 카테고리 생성
	public int join(CategoryVo categoryVo) {
		System.out.println("CategoryDao>join");
		
		//"category.insert" 안에 틀려도 오류 안남
		int count = sqlSession.insert("category.insert", categoryVo);
	
		return count;		
	}

}
