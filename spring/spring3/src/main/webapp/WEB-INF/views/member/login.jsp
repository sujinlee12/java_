<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h2>로그인</h2>
<form action="<c:url value='/login'/>" method="post">
	<div class="form-group">
		<label for="id">아이디:</label>
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