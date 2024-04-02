<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="<c:url value="/resources/img/bird.jpg"/>" alt="logo" style="width:40px;">
  </a>
<nav class="navbar navbar-expand-sm bg-light">
<!-- Links -->
 <ul class="navbar-nav">
   	<li class="nav-item">
     	<a class="nav-link" href="#">Link 1</a>
   	</li>
  	 <li class="nav-item">
     	<a class="nav-link" href="#">Link 2</a>
     </li>
   	<li class="nav-item">
    	<a class="nav-link" href="#">Link 3</a>
   	</li>
 </ul>
</nav>
</body>
</html>