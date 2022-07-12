package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	// 필드

	// 생성자

	// 메소드

	// 메소드 일반

	// 메인
	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST })
	public String main() {
		System.out.println("MainController>main");
		
		return "main/index";
	}

}
