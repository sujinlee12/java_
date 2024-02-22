<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ %>taglib
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<!-- 부트스트랩5 css/js -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>	
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="<%= request.getContextPath() %>/">이수진</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="collapsibleNavbar">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link" href="<%= request.getContextPath() %>/signup">회원가입</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="<%= request.getContextPath() %>/login">로그인</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	<div class = "container">
	<h1>메인페이지입니다.</h1>
	<c:forEach begin="1"end ="4" var="i">
	${i },
	</c:forEach>
	</div>
	
	<!-- /signup을 처리하는 서블릿을 추가한 후 signup.jsp와 연결하는 작업 -->
	
</body>
</html>