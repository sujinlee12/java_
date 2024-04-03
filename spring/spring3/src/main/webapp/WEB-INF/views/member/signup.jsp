<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>회원가입</title>
	<!--이 페이지에서만 쓰는 링크가 있을 수 있으므로 header, footer 빼고는 남겨둠  -->
</head>
<body>
<div class="container">
	<h2>회원가입</h2>
	<form action="<c:url value='/signup'/>" method="post">
  		 <div class="form-group">
		   <label for="id">아이디:</label>
		   <input type="text" class="form-control" id="id" name="me_id" required>
  		 </div>
  		 <div class="form-group">
		   <label for="pw">비번:</label>
		   <input type="password" class="form-control" id="pw" name="me_pw"required>
  		 </div>
    	 <div class="form-group">
		   <label for="pw">비번확인:</label>
		   <input type="password" class="form-control" id="pw2" required>
  		 </div>
  		 <div class="form-group">
		   <label for="email">이메일:</label>
		   <input type="email" class="form-control" id="email" name="me_email"required>
  		 </div>
	 	 <button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>
</body>
</html>