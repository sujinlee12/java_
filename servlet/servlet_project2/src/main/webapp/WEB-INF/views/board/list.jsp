<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class ="container">
	<!-- 서버에서 보낸 데이터를 c:forEach를 이용하여 화면에 출력 -->
	<!-- 서버에서 보낸 게시글 리스트를 간단하게 출력 -->
	<!--  for (BoardVO board : board) 향상된 포문처럼 사용-->
<h1>게시글 리스트</h1>
		<form action="<c:url value="/board/list"/>" class="mt-3">
			<div class="input-group mb-3">
				<select name="type">
					<c:if test='${pm.cri.type == "all" }'>selected</c:if>
					<option value="all"
						<c:if test='${pm.cri.type == "all" }'>selected</c:if>>전체</option>
					<option value="title"
						<c:if test='${pm.cri.type == "title" }'>selected</c:if>>제목</option>
					<option value="writer"
						<c:if test='${pm.cri.type == "writer" }'>selected</c:if>>작성자</option>
				</select> <input type="text" class="form-control" placeholder="검색어"
					name="search" value="${pm.cri.search}" />
				<button class="btn btn-danger" type="submit">검색</button>
			</div>
		</form>
<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>게시판</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="board">
					<tr>
						<td>${board.bo_num }</td>
						<td>${board.community.co_name}</td>
						
						<td><c:url var="url" value="/board/detail">
								<c:param name="num" value="${board.bo_num}" />
							</c:url> <a href="${url }">${board.bo_title}</a></td>
						<td><c:url var="page" value="/board/list">
								<c:param name="type" value="writer" />
								<c:param name="search" value="${board.bo_me_id}" />
								<c:param name="page" value="1" />
							</c:url> <a href="${page}"> ${board.bo_me_id}</a></td>
						<td>${board.bo_view }</td>
					</tr>
				</c:forEach>
				<c:if test="${list.size() == 0 }">
					<tr>
						<th colspan="5">
							<h3 class="text-center">등록된 게시글이 없습니다.</h3>
						</th>
					</tr>
				</c:if>
			</tbody>
		</table>
  <a href="<c:url value = "/board/insert"/>" class= "btn btn-outline-primary">게시글 등록</a>

</div>
</body>
</html>