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


<style>

* {
	margin: 0 auto;
}
#bodyall {
	width : 75%;
	position: relative;
	
}

#top{
position: fixed;
width: 75%;
	text-align: center;
	background: white;
	opacity: 0.5;
}

#comlogo {
	float: left;
	color: red;
	font-weight: bold;
	text-decoration: none;
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
	text-align: center;
	margin-top: 50px;
}

#content2 {
	display: inline-block;
	font-size: 12px;
	margin: 10px 0;
}

hr#hr1 {
	clear: both;
	width: 100%;
	border: 0.5px solid #D8D8D8;
}

img {
	width: 100%;
}

#pbuyform {

	position: fixed;
	
	top: 50px;
	right: 10px;
	width: 200px;
	height: 700px;
	font-size: 20px;
	border: 1 px solid #D8D8D8s;
	background-color: white;
	opacity: 0.5;
	
}
#pbuyformin{
display: none;
}

#buybtn{
border-radius:10px;
width: 200px;
height: 50px;
background: red;
}
#body1{
	text-align: center;;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript">
var image1=new Image();
image1.src="${pageContext.request.contextPath}/resources/images/slide-1.jpg";
var image2 =new Image();
image2.src="${pageContext.request.contextPath}/resources/images/slide-2.jpg";
var image3 = new Image();
image3.src ="${pageContext.request.contextPath}/resources/images/slide-3.jpg";


</script>

<!-- =============== 헤더부분  끝지점 ======================= -->




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
				<a id="tmenu" href="${pageContext.request.contextPath}/auth/logout"
					id="logout"><span id="sp1">${Auther.username}님!</span>&nbsp;
					&nbsp;로그아웃</a>
			</c:if>

		</div>
	</div>

<!--  	<hr id="hr1"> -->


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


	<!--  <hr id="hr2"> -->

	<div id="body1">

		<img id="pimg" alt="" src="displayFile?filename=${kvp.pic}">

	</div>


	<div id="pbuyform">
		<form action="">
		<label></label><input type="text" name="pcode" value="${kvp.pcode}" id="pbuyformin"> <br> 
		<span style="text-decoration: underline;">${kvp.pname}<input type="text" name="pname" value="${kvp.pname}" id="pbuyformin"></span> <br>
		<br> ${kvp.pcontent}<br><br><br><br>
		<label>가격</label><span
			style="text-decoration: line-through;"> &#92;${kvp.price} </span>
			<input type="number" name="price" value="${kvp.price}"  id="pbuyformin"><br> <br> 
		<label>할인가</label>
			&#92; ${kvp.dcprice} <input type="number" name="price" value="${kvp.dcprice}"  id="pbuyformin"><br> <br> 
			<label>색상</label>&nbsp; <select name= "color">
			<option value="흰색">흰색</option>
			<option value= "빨강">빨강</option>
			<option value="파랑">파랑</option>
			<option value="검정">검정</option>
			
			</select>
			<br><br> 
		<label>사이즈</label> <select name= "size">
			<option value="85">85</option>
			<option value= "90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			
			</select>
		<br><br> 
		<label>수량</label><select id="count">
		     
					<c:forEach var="i" begin="1" end="10">
						<option>${i }</option>
					</c:forEach>
				</select>
		
		<br>
		<script type="text/javascript">
		
		var count = $("#count").val();
		var price= ${kvp.dcprice};
		
		alert(count);
		alert(price);
		var sum = count*price;
		alert(sum);
		
		</script>
	
		
		<label>총합계금액(수량)</label> 
		
		
		<input type="button" name="buybtn" value="바로구매" id="buybtn"><br><br> 
		<input type="button" name="cartbtn" value="장바구니담기">
		<input type="button" name="wishbtn" value="찜하기" >
				</form>
	
			 
	</div>
	
</body>
</html>