<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<h1>게시글 상세</h1>
	<div>
		<label>제목</label>
		<div class ="form-control">${board.bo_title}</div>
	</div>
	<div>
		<label>작성자</label>
		<div class ="form-control">${board.bo_me_id}</div>
	</div>
	<div>
		<label>조회수</label>
		<div class ="form-control">${board.bo_title}</div>
	</div>
	<div class="input-group mb-3 mt-3">
		<button class="btn btn-outline-success btn-up col-6" data-state ="1">추천(<span class="text-up"> ${board.bo_up}</span>)</button>
		<button class="btn btn-outline-success btn-down col-6" data-state ="-1">비추천(<span class="text-down">${board.bo_down}</span>)</button>
	</div>
	<div>
		<label>내용</label>
		<div class ="form-control" style ="min-height:400px">${board.bo_content}</div>
	</div>
	<div>
		<c:choose>
			<c:when test="${fileList.size() != 0}">
				<label>첨부파일</label>
				<c:forEach items="${fileList }" var="file">
					<a href="<c:url value="/download${file.fi_name}"/>" 
						class="form-control"
						download="${file.fi_ori_name}">${file.fi_ori_name}</a>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div>첨부파일 없음</div>
		</c:otherwise>
	</c:choose>
	</div>
	
	<div class = "container-comment mt-3 mb-3">
		<h2>댓글(<span class = "comment-total">2</span>)</h2>
		<div class ="box-comment-list">
			<div class="box-comment row">
				<div class="col-3">아이디</div>
				<div class= "col-9">내용</div>
			</div>
		</div>	
		<div class ="box-pagination">
			<ul class="pagination justify-content-center"></ul>
		</div>
		<div class ="box-comment-insert">
			<div class="input-group mb-3">
			       <textarea class="form-control textarea-comment"></textarea>
				   <button class="btn btn-outline-success btn-comment-insert">댓글 등록</button>
			 </div>
		</div>
		<hr>
	</div>
	
	<c:url value="/board/list" var="url">
 			<c:param name="page" value="${cri.page}"/>
 			<c:param name="type" value="${cri.type}"/>
 			<c:param name="search" value="${cri.search}"/>
 		</c:url>
	<a href ="${url}" class ="btn btn-outline-dark">목록으로</a>
	<!-- 로그인한 회원이 작성자인지 확인하는 코드 -->
	<c:if test="${user.me_id == board.bo_me_id}">
		<a href="<c:url value="/board/delete?boNum=${board.bo_num}"/>" class="btn btn-outline-success">삭제</a>
		<a href="<c:url value="/board/update?boNum=${board.bo_num}"/>" class="btn btn-outline-warning">수정</a>
	</c:if>
</div>
<!-- 댓글 리스트 조회 -->
<script type="text/javascript">
//댓글 페이지 정보를 가지고 있는 객체를 선언
let cri = {
	page: 1,
	search : "${board.bo_num}"
}

getCommentList(cri);

function getCommentList(cri){
	$.ajax({
		async : true, //비동기 : true(비동기), false(동기)
		url : '<c:url value ="/comment/list"/>', 
		type : 'post', 
		data : JSON.stringify(cri),
		//서버로 보낼 데이터 타입
		contentType : "application/json; charset=utf-8",
		//서버에서 보낸 데이터의 타입
		dataType : "json", 
		success : function (data){
			displayCommentList(data.list);
			displayCommentPagination(data.pm);
			$('.comment-total').text(data.pm.totalCount);
		}, 
		error : function(jqXHR, textStatus, errorThrown){
		
		}
	});
}
function displayCommentList(list){
	let str = '';
	if(list == null || list.length == 0){
		str ='<h5>등록된 댓글이 없습니다.</h5>';
		$('.box-comment-list').html(str);
		return;
	}
	
	for(item of list){
	  let boxBtns =
		`<span class ="box-btn float-right">
			<button class ="btn btn-outline-danger btn-comment-del" 
				data-num="\${item.cm_num}">삭제</button>
			<button class ="btn btn-outline-danger btn-comment-update" 
				data-num="\${item.cm_num}">수정</button>
		 </span>`;
		let btns = '${user.me_id}'== item.cm_me_id ? boxBtns : ''; 
		str += 
		`
			<div class = "box-comment row">
				<div class ="col-3">\${item.cm_me_id}</div>
				<div class ="col-9 clearfix input-group">
					<span class ="text-comment">\${item.cm_content}</span>
					\${btns}
				</div>
			</div>
		`
	}
	$('.box-comment-list').html(str);
}
function displayCommentPagination(pm){
	
	let str = '';
	if(pm.prev){
		str += `
			<li class="page-item">
				<a class="page-link" href="javascript:void(0); "data-page="\${pm.startPage - 1}">이전</a>
			</li>`;
	
	}
	for(let i = pm.startPage; i<=pm.endPage; i++){
		let active = pm.cri.page == i ? 'active' : '';
		str += `
			<li class="page-item \${active}">
				<a class="page-link" href="javascript:void(0);"data-page="\${i}">\${i}</a>
			</li>`;	
	}
	if(pm.next){
		str += `
			<li class="page-item">
				<a class="page-link" href="javascript:void(0);"data-page="\${pm.endPage + 1}">다음</a>
			</li>`;
	
	}
	$('.box-pagination ul').html(str);
}
$(document).on('click','.box-pagination .page-link',function(){
	cri.page - $(this).data('page');
	getCommentList(cri);
})

</script>
<!-- 댓글 등록 -->
<script type="text/javascript">
//댓글 등록 버튼의 클릭 이벤트를 등록
$(".btn-comment-insert").click(function(){
	//로그인이 안되어있으면 return; : 로그인 확인
	if(!checkLogin()){
		return;
	}
	//서버에 보낼 데이터를 생성 => 댓글 등록을 위한 정보 => 댓글 내용, 게시글 번호, (x)작성자 아이디(세션에서 가져오는게 나음)
	let comment = {
			/* vo의 이름과 같아야 자동으로 들어감 */
			cm_content : $('.textarea-comment').val(),
			cm_bo_num : '${board.bo_num}'
	}
	
	//내용이 비어있으면 내용을 입력하라고 알림
	if(comment.cm_content.length == 0){
		alert('댓글 내용을 작성하세요.');
		return;
	}
	//서버에 데이터를 전송
	
	$.ajax({
		async : true,
		url : '<c:url value="/comment/insert"/>', 
		type : 'post', 
		data : JSON.stringify(comment), 
		contentType : "application/json; charset=utf-8",
		dataType : "json", 
		success : function (data){
			if(data.result){
				alert('댓글을 등록했습니다.');
				$('.textarea-comment').val('');
				cri.page = 1;
				getCommentList(cri);
			}else{
				alert('댓글을 등록하지 못했습니다.');
			}
		}, 
		error : function(jqXHR, textStatus, errorThrown){
			console.log(xhr);
			console.log(textStatus);
		}
	});
}); 

function checkLogin(){
	//로그인을 했을 때
	if('${user.me_id}' != ''){
		return true;
	}
	//안했을 때
	if(confirm("로그인이 필요한 기능입니다.\n 로그인 페이지로 이동하겠습니까?")){
	   location.href = '<c:url value="/login"/>';
	}
	return false;
}

/* 댓글은 비동기 통신으로 새로 뿌려주는 경우 btn.click */
/* html로 고정이 안되는 경우, 화면에 다시 뿌리는 경우는 document.on('click')' */
</script>
<!-- 댓글 삭제 -->
<script type="text/javascript">
//댓글 삭제 버튼 클릭 시 alert(1)이 실행되도록 작성
$(document).on('click','.btn-comment-del', function(){
	//서버로 보낼 데이터 생성
	let comment = {
		cm_num : $(this).data('num')
	}
	//서버로 데이터를 전송
	$.ajax({
		async : true,
		url : '<c:url value ="/comment/delete"/>', 
		type : 'post', 
		data : JSON.stringify(comment),
		contentType : "application/json; charset=utf-8",
		dataType : "json", 
		success : function (data){
				if(data.result){
					alert('댓글을 삭제했습니다.');
					getCommentList(cri);
				}else{
					alert('댓글을 삭제하지 못했습니다.');
				}
			}, 
		error : function(jqXHR, textStatus, errorThrown){
			console.log();
		}
	});


});

</script>
<!-- 댓글 수정 -->
<script type="text/javascript">
$(document).on('click','.btn-comment-update', function(){
	initComment();
	//곳곳에서 쓰일 예정이라서 따로 빼주기
	let contentBox = $(this).parents(".box-comment").find(".text-comment");
	//댓글을 수정할 수 있는 textarea로 변경
	let content = contentBox.text();
	/* console.log(content) */
	let str = 
	`<textarea class ="form-control">\${content}</textarea>`;
	contentBox.after(str);
	contentBox.hide();
	//수정/삭제버튼을 감추고
	$(this).parents(".box-comment").find('.box-btn').hide();
	
	//수정 완료 버튼을 추가
	let cm_num = $(this).data("num");
	str = `<button class="btn btn-outline-warning btn-complete" data-num ="\${cm_num}">수정완료</button>`;
	$(this).parents(".box-comment").find('.box-btn').after(str);
});
//수정완료 버튼 클래스에 btn-complete추가 후 여기 넣어주기 이벤트 등록하기위해.
$(document).on('click','.btn-complete',function(){
		//전송할 데이터를 생성 => 댓글 수정 =>댓글 번호, [댓글 내용],
		let comment = {
				cm_content : $('.box-comment').find('textarea').val(),
				cm_num : $(this).data("num")
		}
				
		//서버에서 ajax로 데이터를 전송 후 처리
		$.ajax({
			async : true, //비동기 : true(비동기), false(동기)
			url : '<c:url value ="/comment/update"/>', 
			type : 'post', 
			data : JSON.stringify(comment), 
			contentType :"application/json; charset=utf-8",
			dataType : "json",
			success : function (data){
				if(data.result){
					alert('댓글을 수정했습니다.');
					getCommentList(cri);
				}else{
					alert('댓글을 수정하지 못했습니다.')
				}
			}, 
			error : function(jqXHR, textStatus, errorThrown){

			}
		});
		
})
//수정버튼을 누른 상태에서 다른 수정 버튼을 누르면 기존에 누른 댓글을 원상태로 돌려주는 함수
function initComment(){
	$('.btn-complete').remove();
	$('.box-comment').find('textarea').remove();	
	$('.box-btn').show();
	$('.text-comment').show();
}
</script>
<!-- 추천/비추천 -->
<script type="text/javascript">
/* ,는 또는 */
$(".btn-up,.btn-down").click(function(){
	//로그인 여부를 체크
	if(!checkLogin()){
		return;
	}
	//서버에 보낼 데이터 생성
	let state = $(this).data('state');
	let boNum = '${board.bo_num}';
	let recommend = {
			re_state : state,
			re_bo_num : boNum
	}
	//서버에 전송 json => json
	$.ajax({
		async : true, //비동기 : true(비동기), false(동기)
		url : '<c:url value = "/recommend/check"/>', 
		type : 'post', 
		data : JSON.stringify(recommend), 
		contentType : "application/json; charset=utf-8",
		dataType : "json", 
		success : function (data){
			switch(data.result){
				case 1:
					alert('추천했습니다.');
					break;
				case 0:
					let str = recommend.re_state == 1 ? '추천' : '비추천';
					alert(`\${str}을 취소했습니다.`);
					break;
				case -1:
					alert('비추천했습니다');
					break;
				default:
					alert('추천/비추천을 하지 못했습니다.');
				}
				getRecommend();
			}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
});
//로그인한 회원의 추천/비추천 여부와 게시글의 추천/비추천 수를 가져오는 함수
function getRecommend(){
	//서버로 보낼 데이터를 생성 => 게시글 번호
	let num = '${board.bo_num}'
	let obj = {
			num : num
	}
	//url남기는건get, 남기지 않는건 post
	//서버로 데이터를 전송. object => json 하나밖에 없기 때문에 object. 굳이 담아서 보낼 필요 없음.
	$.ajax({
		async : true, 
		url : '<c:url value="/recommend"/>', 
		type : 'post',
		data : obj, 
		dataType : "json", 
		success : function (data){
			displayUpdateRecommend(data.board);
			displayRecommend(data.state);
			
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});
	
}
function displayUpdateRecommend(board){
	$(".text-up").text(board.bo_up);
	$(".text-down").text(board.bo_down);
}
function displayRecommend(state){
	$('.btn-up,.btn-down').addClass("btn-outline-success");
	$('.btn-up,.btn-down').removeClass("btn-success");
	if(state == 1){
		$('.btn-up').removeClass("btn-outline-success");
		$('.btn-up').addClass("btn-success");
	}else if(state == -1){
		$('.btn-down').removeClass("btn-outline-success");
		$('.btn-down').addClass("btn-success");
	}
}

</script>
</body>
</html>