package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	//필드
	@Autowired
	BlogDao blogDao;
	
	//생성자
	
	//메소드
	
	//메소드 일반
	
	//블로그 수정(이미지 파일도 수정 가능)
	public int modify (String id, String blogTitle, MultipartFile file) {
		System.out.println("BlogService>modify");
		
		String logoFile;
		
		//기존 이미지 변경하지 않아도 불러로기 위해 if문 사용
		if(file.getSize() > 0) {
			String orgName = file.getOriginalFilename();
			String exName = orgName.substring(orgName.lastIndexOf("."));
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
			//currentTimeMillis 시간을 1000분의 1초 간격으로 현재시간 제공, UUID 랜덤으로 부여하는 문자
			
			//로고 파일 저장 => 경로 생성
			logoFile = "/upload/" + saveName;

			//filePath를 저장할 실제 경로
			String filePath = "C:\\javastudy\\upload\\" + saveName;
			
			try {															//실제 파일 업로드 과정	
				byte[] fileData = file.getBytes();
				
				OutputStream os = new FileOutputStream(filePath);			//logoFile 경로로 이미지가 저장됨
				BufferedOutputStream bos = new BufferedOutputStream(os);
				bos.write(fileData);
				bos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} else {															//이미지 사진 변경하지 않아도 유지하기
			logoFile = blogDao.getImg(id);
		}
		//Vo 생성 (빈통생성)
		BlogVo blogVo = new BlogVo();
		
		//Vo에 넣기 
		blogVo.setId(id);
		blogVo.setBlogTitle(blogTitle);
		blogVo.setLogoFile(logoFile); //=> blogVo에 있는 setLogoFile 안에 logoFile 저장
		System.out.println(blogVo);
		
		//다오로 보내기
		int count = blogDao.modify(blogVo);
		
		return 0;
	}
	
	//내블로그 관리폼 수정
	public BlogVo getBasic (String id) {	
		System.out.println("BlogService>getBasic");
		
		//blogVo
		BlogVo blogVo = blogDao.getBasic(id);
		
		return blogVo;
	}
	
	//메인화면
	public Map<String, Object> getBlog(String id) {
		System.out.println("BlogService>getBlog");
		
		Map<String, Object> blogMap = blogDao.getBlog(id);
		
		return blogMap;
	}
}
