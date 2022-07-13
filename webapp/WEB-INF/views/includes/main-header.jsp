<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!-- 메인 로고 이미지를 링크하세요 logo.jpg -->
	 	<a href="">
			<img class="logo" src="${pageContext.request.contextPath}/assets/images/logo.jpg">
		</a>
		<ul class="menu">
		
			<!-- 로그인 전 메뉴 -->
			<c:if test="${empty authUser}">
			<li><a href="${pageContext.request.contextPath}/users/loginForm">로그인</a></li>
			<li><a href="${pageContext.request.contextPath}/users/joinForm">회원가입</a></li>
 			</c:if>
 		
			<!-- 로그인 후 메뉴 -->
			<c:if test="${not empty authUser}">
			<li><a href="${pageContext.request.contextPath}/users/logout">로그아웃</a></li>
			<li><a href="">내블로그</a></li>
 			</c:if>
 			
 		</ul>