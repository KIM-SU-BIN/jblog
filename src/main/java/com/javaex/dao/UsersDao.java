package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UsersVo;

@Repository
public class UsersDao {

	//필드
	@Autowired
	SqlSession sqlSession;
	
	//생성자
	
	//메소드
	
	//메소드 일반

	//로그인
	public UsersVo login(UsersVo usersVo) {
		System.out.println("UsersDao>login");
		
		return sqlSession.selectOne("users.select", usersVo);
	}
	
	//아이디 중복확인
	public String getId(String idCheck) {
		System.out.println("UsersDao>idCheck");
		
		return sqlSession.selectOne("users.idCheck", idCheck);
		
	}
	
	//회원가입
	public int join(UsersVo usersVo) {
		System.out.println("UsersDao>join");
		
		//""괄호 안은 주소이기 때문에 쌍따옴표 써 주어야함
		int count = sqlSession.insert("users.insert", usersVo);
		
		return count;
	}
}
