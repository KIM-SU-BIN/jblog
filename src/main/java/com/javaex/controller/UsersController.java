package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UsersService;
import com.javaex.vo.UsersVo;

@RequestMapping(value = "/users", method = {RequestMethod.GET, RequestMethod.POST })
@Controller
public class UsersController {
	// 필드
	@Autowired
	UsersService usersService;

	// 생성자

	// 메소드

	// 일반 메소드
	
//--------------------------------------------------로그아웃--------------------------------------------------//
	//로그아웃
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		System.out.println("UsersController>logout");
		
		//저장되어있는 로그인 정보 (authUser)삭제
		session.removeAttribute("authUser");
		
		//밖에 있는 빈통(session) 삭제
		session.invalidate();
		
		return "redirect:/";
	}
	
//--------------------------------------------------로그인--------------------------------------------------//
	// 로그인폼
	@RequestMapping(value = "/loginForm")
	public String loginForm() {
		System.out.println("UsersController>loginForm");
		
		return "users/loginForm";
	}
	

	// 로그인 -> usersNo, id 필요 
	//	로그인 성공과 실패인 경우 리턴 주소값이 다르기 때문에 서비스가 아닌 컨트롤러에 작성
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute UsersVo usersVo, HttpSession session) {
		System.out.println("UsersController>login");
		
		//서비스로 보내기
		UsersVo authUser = usersService.login(usersVo);
		
		
		if(authUser != null) {
			
			//로그인 성공
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/";
			
		}else {
			System.out.println("로그인 실패");
			return "redirect:/users/loginForm?login=fail";
		}
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

	
	// 아이디 중복찾기 => ajax 보승이한테 배울 예정

	}
