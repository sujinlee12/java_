<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가</title>
</head>
<body>
<div class="container">
	<h2>게시글 등록</h2>
	<form action="<c:url value='/post/insert'/>" method="post">
 		 <div class="form-group">
			   <label for="title">제목:</label>
			   <input type="text" class="form-control" id="title" name="bo_title" required>
 		 </div>
  		 <div class="form-group">
			   <label for="content">내용:</label>
			   <textarea class="form-control" id="content" name="bo_content" required rows="10">
	  		   </textarea>
  		 </div>
	 	 <button type="submit" class="btn btn-primary col-12">게시글 등록</button>
	</form>
</div>
</body>
</html>