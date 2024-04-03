<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>로그인</title>
	<!--이 페이지에서만 쓰는 링크가 있을 수 있으므로 header, footer 빼고는 남겨둠  -->
</head>
<body>
<div class="container">
	<h2>로그인</h2>
<form action="<c:url value='/login'/>" method="post">
	<div class="form-group">
		<label for="id">아이디:</label>
		<!-- 멤버VO에 멤버변수와 name이름 맞추기 -->
			<input type="text" class="form-control" id="id" name="me_id" required>
	</div>
	<div class="form-group">
			<label for="pw">비밀번호:</label>
			<input type="password" class="form-control" id="pw" name="me_pw"required>
	</div>
	<button type="submit" class="btn btn-success">로그인</button>
</form>
</div>
</body>
</html>