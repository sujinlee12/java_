<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 	<!-- Brand -->
	<a class="navbar-brand" href="<c:url value="/"/>">Logogo</a>
	
	<!--Links  -->
	<ul class="navbar-nav">
		<c:if test="${user == null}">
	  		<li class="nav-item">
	    		<a class="nav-link" href="<c:url value="/signup"/>"> 회원가입</a>
	 		</li>
	 		<li class="nav-item">
	    		<a class="nav-link" href= "<c:url value="/login"/>"> 로그인</a>
	  		</li>
  		</c:if>
  		<li class="nav-item">
	    		<a class="nav-link" href= "<c:url value="/board/list"/>">게시글</a>
	  	</li>
	  	<!-- user가 널이 아닐 때 즉 유저가 로그인한 상태일 때 -->
	  	<c:if test="${user != null }">
	  		<li class="nav-item">
	    		<a class="nav-link" href= "<c:url value="/mypage"/>">마이페이지</a>
	  		</li>
	  		<li class="nav-item">
	    		<a class="nav-link" href= "<c:url value="/logout"/>">로그아웃</a>
	  		</li>
	  	</c:if>
	</ul>
</nav>