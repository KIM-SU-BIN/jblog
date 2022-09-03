package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {

	//필드	
	@Autowired
	CategoryDao categoryDao;
	
	//리스트 불러오기
	public List<Map<String, Object>> getCateList(String id) {
		System.out.println("CategoryService>getCateList");
		
		return categoryDao.getCateList(id);
		
	}
	
	//카테고리 추가 + 보이기 
	public Map<String, Object> addCategory(CategoryVo categoryVo) {
		System.out.println("CategoryService>addCategory");
		
		int count = categoryDao.addCategory(categoryVo);
		System.out.println(categoryVo);
		
		Map<String, Object> caVo = categoryDao.getCate(categoryVo);
		
		return caVo;
	}
}
