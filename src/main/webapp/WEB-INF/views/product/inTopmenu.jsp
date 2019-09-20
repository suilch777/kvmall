<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<a href="#">kvmall</a>
		<a href="productReg.do">상품등록</a>
		<a href="bord.jsp">고객센타</a>
		<a href="bord.jsp">장바구니</a> 
		<a href="timeTable.jsp">나의kvmall</a>
		<a href="join.do">회원가입</a>		
		<a href="login.do">로그인</a> 
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