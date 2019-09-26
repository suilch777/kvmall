<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

hr#hr1 {
	clear: both;
	width: 100%;
	border: 0.5px solid #D8D8D8;
}
#topbody1{
width: 75%;
height: 100px;
text-align: center;
padding-top: 20px;
}
#topbody2{
	color: red;
}


img {
	width: 300px;
	height: 300px;
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
		<a href="join.do">회원가입</a>		
		<a href="${pageContext.request.contextPath}/auth/login" id="login">로그인</a> 
		</c:if>
		
		<c:if test="${Auth != null }"><!-- 로그인 상태 -->
		
		<a href="logout.do" id="logout"><span id="sp1">${loginDTO.username}님!</span>&nbsp; &nbsp;로그아웃</a> 
		</c:if>
			 			 
		</div>
		
		<hr id="hr1">
		
		<div id="topbody1"><h3 id="topbody2">회원 가입에 성공하였습니다.!!!<br>
		[가입하신  ID로 로그인 하여 주세요.]
		</h3>
		</div>
		<div id="body1">

			<img alt="" src="images/p1.jpg"> 
			<img alt=""	src="images/p2.jpg">
			<img alt="" src="images/p5.jpg">
			<img alt="" src="images/p6.jpg">
			<img alt="" src="images/p7.jpg">
			<img alt="" src="images/p1.jpg">
			<img alt="" src="images/p2.jpg">
			<img alt="" src="images/p5.jpg"> 
			<img alt="" src="images/p6.jpg"> 
			<img alt="" src="images/p7.jpg">
		</div>
	</div>
</body>
</html>