package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UsersDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UsersVo;

@Service
public class UsersService {
	
	//필드
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	BlogDao blogDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	//생성자
	
	//메소드
	
	//메소드 일반

	//로그인
	public UsersVo login(UsersVo usersVo) {
		System.out.println("UsersService>login");
		
		return usersDao.login(usersVo);
		
	}
	
	//아이디 중복확인
	public String idCheck(String idCheck) {
		System.out.println("UsersService>idCheck");
		
		String usersVo = usersDao.getId(id);
		
		if (usersVo == null) {
			
			// 중복된게 없을때 성공
			return "success";
			
		} else {
			return "fail";
		}
		
	}
	
	//회원가입
	public int join(UsersVo usersVo) {
		System.out.println("UsersService>join");
		
		int count = usersDao.join(usersVo);
		
		if(count >= 1) {
			
			//새로운 Vo  생성하여 저장
			BlogVo blogVo = new BlogVo();
			
			//값 저장 (실질적으로 화면에 보이는 애들)
			blogVo.setId(usersVo.getId());
			blogVo.setBlogTitle(usersVo.getUserName()+"의 블로그입니다.");
			blogVo.setLogoFile("/assets/images/spring-logo.jpg");
			
			//서비스에 저장후 다오->db로 보내기(다오로 보낼 때 @Autowired확인하기)
			int count2 = blogDao.join(blogVo); 

			//카테고리 추가
			//새로운 Vo  생성하여 저장
			CategoryVo categoryVo = new CategoryVo();
			
			//값저장 -> users, blog 테이블 둘 중 아무거나 참조해도 상관 없음
			categoryVo.setId(usersVo.getId());
			categoryVo.setCateName("미분류");
			categoryVo.setDescription ("카테고리 없음");
			
			//카테고리 저장
			int count3 = categoryDao.join(categoryVo);
		}
		
		return count;
	}

}
