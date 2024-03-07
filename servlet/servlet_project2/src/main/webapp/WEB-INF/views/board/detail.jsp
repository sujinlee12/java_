<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
	<c:choose>
		<c:when test="${board != null }">
			<h1>게시글 상세</h1>
			<div class="mb-3 mt-3">
				<label class="form-label">게시판</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.community.co_name}">
			</div>
			<div class="mb-3 mt-3">
				<label class="form-label">제목</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_title}">
			</div>
			<div class="mb-3 mt-3">
				<label class="form-label">작성자</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_me_id}">
			</div>
			<div class="mb-3 mt-3">
				<label for="title" class="form-label">조회수</label>
				<input type="text" class="form-control" readonly="readonly" value="${board.bo_view}">
			</div>
			<div class="mb-3 mt-3 clearfix">
				<button type ="button" id= "btnUp" data-state="1" class="btn btn-outLine-sucess btn-up float-start col-6">추천</button>
				<button type ="button" id="btnDown" data-state ="-1"class="btn btn-outline-sucess btn-down floar-end col-6">비추천</button>
			</div>
			<div class="mb-3 mt-3">
				<label for="content" class="form-label">내용</label>
				<div class ="form-control" style ="min-height:400px;">${board.bo_content }</div>
			</div>
		<c:if test="${fileList != null && fileList.size() != 0 }">
				<div class="mb-3 mt-3">
					<label class="form-label">첨부파일</label>
					<c:forEach items="${fileList}" var="file">
				<a href ="<c:url value = "/downLoad?filename =${file.fi_name}"/>" class=form-control download="${file.fi_ori_name}">${file.fi_ori_name}</a>
					</c:forEach>
				</div>
		</c:if>
		<a href="<c:url value="/board/list"/>" class="btn btn-outline-primary">목록으로</a>
			<c:if test="${user.me_id == board.bo_me_id }">
			<a href="<c:url value="/board/delete?num=${board.bo_num }"/>" class="btn btn-outline-danger">삭제</a>
			<a href="<c:url value="/board/update?num=${board.bo_num }"/>" class="btn btn-outline-danger">수정</a>
			</c:if>
	</c:when>
		<c:otherwise>
			<h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
		</c:otherwise>	
	</c:choose>
	</div>
	<script src="//code.jquery.com/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		$(".btn-up,.btn-down").click(function(){
			let state = $(this).date('state');
			let boNum = '${board.bo_num}';
			$.ajax({
				url : '<c:url value="/recommend"/>',//어딛로 보낼ㄹ지
				method : 'get',
				async : true, //동기/비동기 선택, true : 비동기, false : 동기
				data : {//보낼 데이터는 무엇인지
					//왼쪽은 속성이름 오른쪽은 변수명 ""는 안써도 됨
					"state" : state,
					"boNum" : boNum
				},
				//성공했을 때
				sucess : function(data){
					console.log(data);
				},
				//실패했을 때 
				error : function(a, b, c){
					console.error("예외 발생");
				}
			});//ajax end
			
		 });//click end
	
	</script>
<%-- 	/* 
	
		let btnUp = document.getElementById("btnUp");
		let btnDown = document.getElementById("btnDown");
	
		btnUp.onclick = recommend;
		
		btnDown.onclick = recommend;
		
		function recommend(){
			if('{user.me_id}' == ''){
				//확인 누르면 로그인 페이지로
				if(confirm("로그인이 필요한 서비스입니다 .로그인으로 이동하시겠습니까?"))
					location.href = "<c:url value ='/login'/>"			
			}
			//취소 누르면 현재 페이지에서 추천/비추천 동작을 안함
			else{
				return;
			}
		}
		
		let boNum = '${board.bo_num}';
		let state = this.getAttribute("data-state");
		
		fetch(`<c:url value ="/recommend"/>?boNum=\${boNum}&state=\${state}`)
		.then(response => response.text())
		.then(data =>{
			let str = state == 1 ? '추천' : '비추천';
			initRecommendBtn(btnUp);
			initRecommendBtn(btnDown);
			
			switch(data){
				case "1":	
					alert('게시글을 추천했습니다.'); 
					selectRecommendBtn(btnUp);
					break;
				case "-1":	
					alert('게시글을 비추천했습니다.');
					selectRecommendBtn(btnDown);
					break;
				case "0":	alert(`게시글 \${str}을 취소했습니다.`); break;
				default: 	alert(data);
			}
		})
		.catch(error => console.error(error));
	}
	fuction initRecommendBtn(btn){
		btn.classList.remove('btn-danger');
		btn.classList.add('btn-outline-danger');
	}
	function selectRecommend(btn){
		btn.classList.remove('btn-outline-danger');
		btn.classList.add('btn-danger');
	}
	<c:if test = "${recommend != null}">
		if(${recommend.re_state == 1}){
			selectRecommend(btnUp);
		}else if(${recommend.re_state == -1}){
			selectRecommendBtn(btnDown);
		}
		
		</c:if> */ --%>
	
	

</body>
</html>