package com.javaex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UsersService;

@RequestMapping(value = "/api/users", method = {RequestMethod.GET, RequestMethod.POST })
@Controller
public class ApiUsersController {
	@Autowired
	UsersService usersService;
	
	// 아이디 중복찾기
	@ResponseBody
	@RequestMapping(value="/idCheck", method={RequestMethod.GET, RequestMethod.POST})
	public boolean idCheck(@RequestBody String idCheck) {
		System.out.println("UsersController>idCheck");
		
		return usersService.idCheck(idCheck);
	}
}
