package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UsersService;
import com.javaex.vo.UsersVo;

@RequestMapping(value = "/users", method = { RequestMethod.GET, RequestMethod.POST })
@Controller
public class UsersController {
	// 필드
	@Autowired
	UsersService usersService;

	// 생성자

	// 메소드

	// 일반 메소드
//--------------------------------------------------카테고리--------------------------------------------------//

	
	
	
//--------------------------------------------------로그인--------------------------------------------------//
	// 로그인폼
	@RequestMapping(value = "/loginForm")
	public String loginForm() {
		System.out.println("UsersController>loginForm");
		
		return "users/loginForm";
	}
	

	// 로그인 -> usersNo, id 필요 
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute UsersVo usersVo) {
		System.out.println("UsersController>login");
		
		//UsersVo authUser = usersService.login(usersVo);
		
				
		return "users/main";
	}

//--------------------------------------------------회원가입(폼)--------------------------------------------------//

	// 회원가입폼
	@RequestMapping(value = "/joinForm")
	public String joinForm() {
		System.out.println("UsersController>joinForm");

		return "users/joinForm";
	}

	// 회원가입 join -> jsp에서 ModelAttribute를 통해 받은 정보를 컨트롤러에서 다시 db에 정보 저장
	@RequestMapping(value = "/join")
	public String join(@ModelAttribute UsersVo usersVo) {
		System.out.println("UsersController>join");

		// int count 유무 : 서비스에서 컨트롤러로 올 때 정보 저장 할 것인가 말 것 인가?
		// usersVo에 저장하여 jsp 정보를 보냄
		int count = usersService.join(usersVo);

		return "users/joinSuccess";
	}

	// 아이디중복찾기 => ajax 11일 보승이한테 배울 예정

}
