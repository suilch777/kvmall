<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
	$(function() {
		$('.bxslider').bxSlider({
			auto : true,
			mode : 'fade',
			captions : true,
			slideWidth : 800,
			pause : 2000,
			autoControls : true,

			minSlides : 3
		});
	});

	/* $(function() {
		$("#bimg1").mouseover(function(e) {
			$("#bimg2").css({
				"width" : "270px",
				"height" : "270px"
			})
			$("bimg2").css({
				"box-shadow" : "5px 5px"
			})
		});
		$("#bimg").mouseout(function(e) {
			$("#bimg2").css({
				"width" : "250px",
				"height" : "250px"
			})

		});
	}); */
</script>



<style type="text/css">
* {
	margin: 0 auto;
}

div#top {
	width: 75%;
}

a:first-child {
	float: left;
	color: red;
	font-weight: bold;
	
}

a {
	margin-bottom:10px;
	float: right;
	margin-top: 15px; 
	text-decoration: none;
	color: gray;
	font-size: 12px;
	margin-left: 25px;
}
span#sp1{
	font-weight: bold;
}
hr#hr1 {
	clear: both;
	width: 100%;
	border: 0.5px solid #D8D8D8;
}
div#top2{
width: 75%;
height: 150px;
}

hr#hr2 {
	clear: both;
	width: 100%;
	border: 0.5px solid #D8D8D8;
}
div#body1 {
	clear: both;
	text-align: center;
	width: 80%;
}

img {
	width: 300px;
	height: 300px;
}
#logout{
display:hidden;
}


</style>
<script >



</script>
</head>
<body>
	<!-- top부분 -->
	<div id="container">
		<div id="top">
			<a href="#" id="comlogo">kvmall</a> 
			<a href="${pageContext.request.contextPath}/product/register">상품등록</a>
			<a href="bord.jsp">고객센타</a> 
			<a href="bord.jsp">장바구니</a>
			 <a href="timeTable.jsp">나의kvmall</a>
			  <a href="${pageContext.request.contextPath}/member/register">회원가입</a>
			
			<!-- 로그인 처리 -->
			  <c:if test="${Auther == null }"><!-- 로그아웃 상태 -->
		<a href="join.do">회원가입</a>		
		<a href="${pageContext.request.contextPath}/auth/login" id="login">로그인</a> 
		</c:if>
		
		<c:if test="${Auth != null }"><!-- 로그인 상태 -->
		
		<a href="logout.do" id="logout"><span id="sp1">${loginDTO.username}님!</span>&nbsp; &nbsp;로그아웃</a> 
		</c:if>
			 			 
		</div>
		
		
		<hr id="hr1">
		<div id="top2">
		
		
		</div>
		<hr id="hr2">
		
		<div id="wrap">
			<div class="bxslider">
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/p1.jpg" title="Funky roots">
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/p2.jpg" title="The long and winding road">
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/p5.jpg" title="Happy trees">
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/p6.jpg" title="slider 4">
				</div>
			</div>
		</div>

		<div id="body1">

			<img alt="" src="${pageContext.request.contextPath}/resources/images/p1.jpg"> 
			<img alt=""	src="${pageContext.request.contextPath}/resources/images/p2.jpg">
			<img alt="" src="${pageContext.request.contextPath}/resources/images/p5.jpg">
			<img alt="" src="${pageContext.request.contextPath}/resources/images/p6.jpg">
			<img alt="" src="${pageContext.request.contextPath}/resources/images/p7.jpg">
			<img alt="" src="${pageContext.request.contextPath}/resources/images/p1.jpg">
			<img alt="" src="${pageContext.request.contextPath}/resources/images/p2.jpg">
			<img alt="" src="${pageContext.request.contextPath}/resources/images/p5.jpg"> 
			<img alt="" src="${pageContext.request.contextPath}/resources/images/p6.jpg"> 
			<img alt="" src="${pageContext.request.contextPath}/resources/images/p7.jpg">
		</div>
	</div>
</body>
</html>