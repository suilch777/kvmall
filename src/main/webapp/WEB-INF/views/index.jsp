<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

#comlogo {
	float: left;
	color: red;
	font-weight: bold;
}

a {
	margin-bottom: 10px;
	float: right;
	margin-top: 15px;
	text-decoration: none;
	color: #0B3B39;
	font-size: 12px;
	margin-left: 25px;
}

hr#hr1 {
	clear: both;
	width: 100%;
	border: 0.5px solid #D8D8D8;
}

ul{
list-style: none;
}

#body1 a{
	width: 300px;
	height: 400px;
	text-align: left;
}

img{
	display: inline-block;
	width: 298px;
	height: 298px;
	}

img:hover{
	width: 300px;
	height: 300px;
	 box-shadow: 5px 5px 5px 5px gray inset;
}


#wrap {
	width: 75%;
	margin-top: 50px;
}

#body1{
	width: 75%;
}
</style>

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
	
		<a href="${pageContext.request.contextPath}/auth/login" id="login">로그인</a> 
		</c:if>
		
		<c:if test="${Auth != null }"><!-- 로그인 상태 -->
		
		<a href="logout.do" id="logout"><span id="sp1">${loginDTO.username}님!</span>&nbsp; &nbsp;로그아웃</a> 
		</c:if>
			 			 
		</div>
		<hr id="hr1">


		<div id="wrap">
			<div class="bxslider">
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/slide-1.jpg" title="Funky roots">
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/slide-2.jpg" title="The long and winding road">
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/slide-3.jpg" title="Happy trees">
				</div>
				<div>
					<img src="${pageContext.request.contextPath}/resources/images/slide-4.jpg" title="slider 4">
				</div>
			</div>
		</div>


		<div id="body1">
		
		<ul>
		<li>  <a><img alt="" src="${pageContext.request.contextPath}/resources/images/p1.jpg" id=" bimg2"> <br>
		<span style="text-decoration: underline;">[여우진1탄]어제오늘
					부츠컷데님팬츠 <br>
				<br>
			</span> ★기장 선택 가능!★"한번 입어보세요"완전반해요~<br> 신소재원단 핏과편안함의 끝판왕!!<br> <span
				style="text-decoration: line-through;">&#92;48,000 </span>할인가 &#92;  40,000
				
		</a>
		 </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p2.jpg"> </a>  </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p5.jpg"> </a>  </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p6.jpg"> </a>  </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p7.jpg"> </a>  </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p9.jpg"> </a>  </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p10.jpg"> </a>  </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p11.jpg"> </a>  </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p12.jpg"> </a>  </li>
		<li><a href="#" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p13.jpg"> </a>  </li>
		
		</ul>
			
			
		</div>
	</div>
</body>
</html>