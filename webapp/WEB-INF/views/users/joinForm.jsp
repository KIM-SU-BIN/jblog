<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>
<body>
	<div id="center-content">

		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		<!-- 메인 해더 -->
		<div>
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/users/join">
				<table>
					<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
					
					<tr>
						<td><label for="txtId">아이디</label></td>
						<td><input id="txtId" type="text" name="id"></td>
						<td><button id="btnIdCheck" type="button">아이디체크</button></td>
					</tr>
					<tr>
						<td></td>
						<td id="tdMsg" colspan="2">사용할 수 있는 아이디 입니다.</td>
					</tr>
					
					<tr>
						<td><label for="txtPassword">패스워드</label></td>
						<td><input id="txtPassword" type="password" name="password"
							value=""></td>
						<td></td>
					</tr>
					
					<tr>
						<td><label for="txtUserName">이름</label></td>
						<td><input id="txtUserName" type="text" name="userName" value=""></td>
						<td></td>
					</tr>
					
					<tr>
						<td><span>약관동의</span></td>
						<td colspan="3"><input id="chkAgree" type="checkbox" name="agree" value="y"> 
						<label for="chkAgree">서비스 약관에 동의합니다.</label></td>
					</tr>
					
				</table>
				<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit">회원가입</button>
				</div>

			</form>

		</div>

		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
		<!-- 메인 푸터  자리-->

	</div>

</body>
	
	<script type="text/javascript">
	
	<!-- ID 중복확인 -->	
	$("#btnIdCheck").on("click", function(){
		
		var id = $("#txtId").val();
		console.log(id);	
		
		$.ajax({
			url : "${pageContext.request.contextPath}/api/users/checkId", //컨트롤러 RequestMapping url 작성하기
			type : "post",
			//contentType : "application/json", ==>> @RequestBody로 파라미터 가져오기 위해 필수 (정보 보낼거 없으면 필요없음)
			data : JSON.stringify(id), //@RequestBody로 데이터 보낼때 필수 (정보 보낼거 없으면 필요없음)
			//data: Vo //@ModelAttribute나 @RequestParam으로 데이터 보낼때 이용 (정보 보낼거 없으면 필요없음)
			dataType : {id},
			success : function(result){				//컨트롤러 함수 실행 후 코드, 컨트롤러에서 return 값이 돌아옴
				
				console.log(result);	
			
			
			
				
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
		// ----------- ajax 끝 ----------- //
		
	});
	
	
	</script>
</html>