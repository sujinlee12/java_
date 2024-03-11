<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="//code.jquery.com/jquery-3.6.1.js"></script>
	</head>
<body>
<jsp:include page ="/WEB-INF/views/header.jsp"/>
<div class ="container">
	<!--
	1.버튼을 추가해서 버튼을 클릭하면 ajax(post, url은 /) 로 숫자 1을 서버에 전송.
	2. 서버에서 넘겨받은 1을 콘솔에 출력한 후 abc를 전송.
	3. 화면에서 서버에서 보낸 abc를 alert으로 출력
	 -->
	<button class="btn btn-outline-success" id="test">ajax 테스트</button>
	<script type="text/javascript">
	$("#test").click(function(){
		$.ajax({
			url : '<c:url value ="/"/>',
			method : 'post',
			data : {
				num : 1
				
			},
			success : function(data){
				alert(data);
			},
			error : function(xhr,status,error){
				
			}
		})
	});
	/* 내가 한 것  
	function("click",)
	$.ajax({
			url : '<c:url value="/"/>',
			method : "post",
			data : {
				content, //객체 content : content
				num 	//num : num
			},
			success : function(data){
				if(data == "ok"){
					alert("댓글을 등록했습니다.");
					cri.page = 1; //내가 쓴 댓글 확인하기 위해 + 댓글 최신순으로 
					getCommentList(cri);
					$(".comment-content").val("");//댓글창 입력하고 다시 비워짐 
				}else{
					alert("댓글을 등록하지 못했습니다.");
				}
			},
			error : function(a,b,c){
				
				}
	 */		
	 </script>
	</div>
</body>
</html>