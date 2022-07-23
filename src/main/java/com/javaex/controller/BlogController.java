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
public class BlogController {
	
	//필드
	@Autowired
	BlogService blogService;

	//생성자
	
	//메소드
	
	//메소드 일반
	
	//내블로그 관리폼 수정
	@RequestMapping(value = "/{id}/admin/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public String basic(Model model, @PathVariable String id) {
		System.out.println("BlogController>adminbasic");
		
		//Vo에서 정보 가져오기 (id를 보내면 logofile, title이 리턴됨)
		//BlogVo blogVo = blogService.getBasic(id);
		Map<String, Object> blogMap = blogService.getBlog(id);
		
		//jsp에 저장하는 방식
		model.addAttribute("blogMap", blogMap);
		
		return "blog/admin/blog-admin-basic";
	}
	
	
	//메인화면 (class는 대문자!)
	@RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model, @PathVariable String id) {
		System.out.println("BlogController>main");
		
		Map<String, Object> blogMap = blogService.getBlog(id);
		model.addAttribute("blogMap", blogMap);
		
		return "blog/blog-main";
	}
}
