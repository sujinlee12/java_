<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<script src="//code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<button class="btn1">json - json</button>
	<br>
	<button class="btn2">object - json</button>
	<br>
	<!-- 
	화면에서 이름과 나이를 입력받아 서버에 ajax로 전송하고,
	서버에서는 화면에서 보내준 이름과 나이를 콘솔에 출력하고,
	화면에 result값으로 "성공"을 전송.
	화면에서는 서버에서 보낸 result를 alert으로 출력.
	
	1. 화면 구성
	2. 이벤트를 등록
	3. 이벤트에서 ajax로 통신
		-화면에 입력된 정보를 가져옴
		-ajax로 서버에 전송
		-서버에서는 화면에서 보낸 정보를 받아서 콘솔에 출력
		-서버에서 화면에 데이터를 전송
		-화면에서는 서버에서 보낸 데이터를 alert으로 출력
	
	-->
	<form>
		<input type = "text" name="name" placeholder="이름을 입력하세요">
		<br>
		<input type = "text" name="age"placeholder="나이를 입력하세요">
		<br>
		<button type="submit" class="btn3">전송</button>
	</form>
	<button type="button" class="btn4">objct - object </button>
	<br>
	<script type="text/javascript">
		function clickTest1(obj){
			let name = ""; //함수내에 지역변수를 만들어서 ajax 작업이 끝날 때 까지 기다렸다가
			//서버에서 보낸 이름을 저장을 하고 다 끝난다음 이름을 return 
	
			$.ajax({
				//동기는 작업1이 다 끝날때까지 기다린 후 작업2가 실행
				//비동기는 작업1이 실행된 후, 끝날때까지 기다리지 않고 작업2가 실행
				async : false,//생략하면 true
				url : '<c:url value="/ajax/json/json"/>', 
				type : 'post', 
				data : JSON.stringify(obj), //객체를 json형태의 문자열로 변환
				//서버로 보내는 데이터의 타입. 위에 있는 data의 타입
				contentType : "application/json; charset=utf-8",
				//서버에서 화면으로 보내는 데이터의 타입. 아래에 있는 success의 data 타입
				dataType : "json", 
				success : function (data){
					console.log(data.member.id);
					console.log(data.member.pw);
					console.log(data.name);
					$(this);//2번
					//1번 this와 2번 this는 같다(x)
					//
					//clickTest1의 return을 원하지만 success에 구현한 함수에 
					//return을 지정하면 success함수의 결과를 리턴
					name = data.name;
					
				}, 
				error : function(jqXHR, textStatus, errorThrown){
	
				
				}
				
				});
				return name;
			}
			$(".btn1").click(function(){
				let obj = {
					id : "abc",
					pw : "def"
				}	
				$(this);
				let name = clickTest
			
			//작업2
		});
	</script>

	<script type="text/javascript">
		//2번째 버튼 object-> get,post 상관없음.
		$(".btn2").click(function(){
			let obj = {
				//필요한건 객체 안에서 만들든 밖에서 만들든 상관없다./ 안에서 만들면 일회용
				id : "abc",
				name : "홍길동" //각각 가져올 수 있다. 이렇게 만들면
			}
			$.ajax({
				async : true, 
				url : '<c:url value="/object/json"/>', 
				type : 'get', 
				data : obj,
				dataType : "json", 
				success : function (data){
					console.log(data);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>

	<script type="text/javascript">
	$("form").submit(function() {
       	//form에 있는 입력 태그들을 하나의 문자열로 만듬. name명 = 값& 형태로
	let obj = $(this).serialize();
        $.ajax({
           async : true,
           url : '<c:url value="/ajax/object/json2" />',
           type : 'get',
           data : obj,
           dataType : "json",
           success : function(data) {
              alert(data.result);
           },
           error : function(jqXHR, textStatus, errorThrown) {

           }
        }); //ajax end;
        return false;
       
        
     }); // function end;
			
	</script>
	
<script type="text/javascript">
$(".btn4").click(function(){
	let obj = { name : "홍길동"};
	$.ajax({
		async : true, 
		url : '<c:url value="/ajax/object/object"/>', 
		type : 'get', 
		data : obj,
		success : function (data){
			console.log(data);
		}, 
		error : function(jqXHR, textStatus, errorThrown){

		}
	});//ajax end;
});// function end;

</script>

	
	
</body>
</html>