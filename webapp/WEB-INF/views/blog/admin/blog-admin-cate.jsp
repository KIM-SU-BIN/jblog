<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>
<body>
	<div id="wrap">
	
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
		<!-- 개인블로그 해더 -->


		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogMap.ID}/admin/basic">기본설정</a></li>
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${blogMap.ID}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogMap.ID}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
		      			
					</tbody>
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" name="cateName" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" name="description"></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
		<!-- 개인블로그 푸터 -->
		
	</div>
	<!-- //wrap -->
	
</body>
<script>
//user에 저장되어 있는 id 불러옴, ready, click 모두 사용
var id = '${authUser.id}'; 

//리스트 불러오기 추가하기
$(document).ready(function(){
	
	$.ajax({
		//보낼때
		url : "${pageContext.request.contextPath}/api/category/getCateList",
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(id),
		//받을때
		dataType : "json",
		success : function(result){
			
			//컨트롤러 함수 실행 후 코드
			//if(result=="")
			for(var i=0; i<result.length; i++){
				render(result[i], 'down');
			}
		},
		
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
	});	
});

//카테고리 항목 추가
$("#btnAddCate").on("click", function() {
	
	//value 값 가져오기 / [속성 = 속성값] => html태그의 속성
	var cateName = $("[name=cateName]").val();
	var description = $("[name=description]").val();
	
	
	var cVo = {
			cateName : cateName,
			description : description,
			id : id
	}
	
	$.ajax({
		//보낼때
		url : "${pageContext.request.contextPath}/api/category/addCategory", //컨트롤러 RequestMapping url 작성하기
		type : "post",
		contentType : "application/json", 							//@RequestBody로 파라미터 가져오기 위해 필수 (정보 보낼거 없으면 필요없음)
		data : JSON.stringify(cVo), 								//@RequestBody로 데이터 보낼때 필수 (정보 보낼거 없으면 필요없음)
																	//@ModelAttribute나 @RequestParam으로 데이터 보낼때 이용 (정보 보낼거 없으면 필요없음)
		//받을때
		dataType : "json",
		success : function(result){
			console.log(result);
			
			render(result, 'up');
			//컨트롤러 함수 실행 후 코드
			//if(result=="")
			
			
		},
		
		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}
	});	
});

//화면 보이기
var render = function(caVo, order){
	if(caVo.PCOUNT == undefined) {
		caVo.PCOUNT = 0;
	}
	
	var str = '';
	str += '<tr>';
	str += '	<td>' + caVo.CATENO + '</td>';
	str += '	<td>' + caVo.CATENAME + '</td>';
	str += '	<td>' + caVo.PCOUNT + '</td>';
	str += '	<td>' + caVo.DESCRIPTION + '</td>';
	str += '	<td class="text-center">';
	str += '		<img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg">';
	str += '	</td>';
	str += '</tr>';
	
	if(order == 'down'){
		$("#cateList").append(str);
	} else {
		$("#cateList").prepend(str);
	}
	
};
</script>
</html>