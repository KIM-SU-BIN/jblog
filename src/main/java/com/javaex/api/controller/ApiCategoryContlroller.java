package com.javaex.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@RequestMapping(value = "api/category", method = {RequestMethod.GET, RequestMethod.POST})
@Controller
public class ApiCategoryContlroller {
	
//필드
@Autowired
CategoryService categoryService;
	
	//리스트 불러오기 ( 1개만 가져오는 경우 Vo, 여러 개 가져오는 경우 List )
	@ResponseBody
	@RequestMapping(value = "/getCateList", method = {RequestMethod.GET, RequestMethod.POST})
	public List<Map<String, Object>> getCateList(@RequestBody String id) {
		System.out.println("ApiCategoryContlroller>getCateList");
		
		return categoryService.getCateList(id);
	}

	//카테고리 추가
	@ResponseBody
	@RequestMapping(value = "/addCategory", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> addCategory(@RequestBody CategoryVo categoryVo) {
		System.out.println("ApiCategoryContlroller>addCategory");
		//System.out.println(categoryVo);
		
		Map<String, Object> caVo = categoryService.addCategory(categoryVo);
		
		return caVo;
	}
	
}
