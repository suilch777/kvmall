<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- head부분 시작 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


<style type="text/css">

 
* {
	margin: 0 auto;
}

#bodyall {
	width: 75%;
}

div#top {
	width: 75%;
}

#comlogo {
	float: left;
	color: red;
	font-weight: bold;
}

a#tmenu {
	margin-bottom: 10px;
	float: right;
	margin-top: 15px;
	text-decoration: none;
	color: #0B3B39;
	font-size: 12px;
	margin-left: 25px;
}

#slide {
	border: 1px solid #000;
}

#content1 {
	display: inline-block;
	font-size: 12px;
	margin: 10px 0;
	text-align: center;
}

#content2 {
	display: inline-block;
	font-size: 12px;
	margin: 10px 0;
	
}

/*=============== 헤더부분  끝지점 =======================*/

hr#hr1 {
	clear: both;
	width: 100%;
	border: 0.5px solid #D8D8D8;
}

ul {
	list-style: none;
}

#body1 {
	float: left;
	margin-top: 50px;
}

#pwrap {
padding:20px;
	display: inline-block;
	width: 300px;
	height: 500px;
	text-align: left;
}

#pbodya {
	text-decoration: none;
	color:gray;
}

#pimg {
	width: 250px;
	height: 250px;
}

#pimg:hover {
	width: 260px;
	height: 260px;
	
}

hr#hr2 {
	clear: both;
	width: 100%;
	border: 0.5px solid #D8D8D8;
}
</style>
<script type="text/javascript">
var image1=new Image();
image1.src="${pageContext.request.contextPath}/resources/images/slide-1.jpg";
var image2 =new Image();
image2.src="${pageContext.request.contextPath}/resources/images/slide-2.jpg";
var image3 = new Image();
image3.src ="${pageContext.request.contextPath}/resources/images/slide-3.jpg";

</script>


</head>
<body id="bodyall">
	<!-- top부분 -->
	<div id="container">
		<div id="top">
			<a href="#" id="comlogo">kvmall</a>

			<!-- 로그인 처리 -->
			<c:if test="${Auther == null }">
				<!-- 로그아웃 상태 -->

				<a id="tmenu" href="bord.jsp">고객센타</a>
				<a id="tmenu" href="bord.jsp">장바구니</a>
				<a id="tmenu" href="timeTable.jsp">나의kvmall</a>
				<a id="tmenu"
					href="${pageContext.request.contextPath}/member/register">회원가입</a>
				<a id="tmenu" href="${pageContext.request.contextPath}/auth/login"
					id="login">로그인</a>
			</c:if>

			<!-- 로그인 상태 -->
			<c:if test="${Auther != null }">

				<a id="tmenu" href="bord.jsp">고객센타</a>
				<a id="tmenu" href="bord.jsp">장바구니</a>
				<a id="tmenu" href="timeTable.jsp">나의kvmall</a>
				<a id="tmenu"
					href="${pageContext.request.contextPath}/product/register">상품등록</a>
				<a id="tmenu" href="${pageContext.request.contextPath}/auth/logout" id="logout"><span id="sp1">${loginDTO.username}님!</span>&nbsp;
					&nbsp;로그아웃</a>
			</c:if>

		</div>

		<hr id="hr1">


		<div id="content1">

			<img id="slide"
				src="${pageContext.request.contextPath}/resources/images/slide-1.jpg"
				name="slide" width="600" height="500"> <br>
		</div>
		<script type="text/javascript">
			var step=1;
			function slideit(){
				if (!document.images)
					return
				document.images.slide.src=eval("image"+step+".src");
				if(step<3)
					step++;
				else 
					step=1;
				setTimeout("slideit()",2500);
			}
			slideit();
			
			</script>


		<hr id="hr2">

		<div id="body1">
			<div>
				<ul>
					<c:forEach var="kvp" items="${list }">
						<li id="pwrap">
							<a id="pbodya" href="pRead?pcode=${kvp.pcode}" id="bimg"> 
											
							 <img id="pimg" alt=""
								src="displayFile?filename=${kvp.pic}"> 
								<br> <span style="text-decoration: underline;">${kvp.pname}</span> <br>
								<br> ${kvp.pcontent}<br> <span
								style="text-decoration: line-through;"> &#92;${kvp.price}
							</span>할인가 &#92; ${kvp.dcprice}<br> <br> <br>

						</a></li>

					</c:forEach>


				</ul>
			</div>

		</div>
	</div>
</body>
</html>