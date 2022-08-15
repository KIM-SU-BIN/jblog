package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;

@Controller
public class CategoryController {
	
	//필드
	@Autowired
	BlogService blogService;
	
	//생성자
	
	//메소드
	
	//메소드-일반
	
	//카테고리 메인
	@RequestMapping(value = "{id}/admin/category", method = {RequestMethod.GET, RequestMethod.POST})
	public String category (Model model, @PathVariable String id) {
		System.out.println("CategoryController");
		
		//map으로 user 정보 가져오기 (기존 blogService에서 사용한 방식과 동일)
		Map<String, Object> blogMap = blogService.getBlog(id);
		
		//보내기
		model.addAttribute("blogMap",blogMap);
		
		return "blog/admin/blog-admin-cate";
	}
}
