<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

*{
margin: 0 auto;
}

#bodyall {
	width: 75%;
	position: relative;
}

#top {
	margin-top:5px;
	position: fixed;
	width: 75%;
	text-align: center;
	/* background: white;
	opacity: 0.5; */
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
hr#hr1 {

clear:both;
	width: 100%;
	
	border: 0.5px solid #D8D8D8;
}


table{
margin-top: 200px;
width: 50%;
text-align: center;
border: 0;
}
tr, th, td{
border-bottom: 1px solid #D8D8D8;

}
#orderbtn{
background-color: red;
}
td{
padding:10px;
}
</style>
</head>
<body id="bodyall">

<div id="top">
			<a href="#" id="comlogo">kvmall</a>

			<!-- 로그인 처리 -->
			<c:if test="${Auther == null && sAuther == null }">
				<!-- 로그아웃 상태 -->
				<a id = "tmenu" href="${pageContext.request.contextPath}/auth/slogin" id="slogin">판매하기</a>
				<a id="tmenu" href="bord.jsp">고객센타</a>
				<a id="tmenu" href="${pageContext.request.contextPath}/sale/cartlist?cmid=${Auther.userid}">장바구니</a>
				<a id="tmenu" href="timeTable.jsp">나의kvmall</a>
				<a id="tmenu"
					href="${pageContext.request.contextPath}/member/register">회원가입</a>
				<a id="tmenu" href="${pageContext.request.contextPath}/auth/login" id="login">로그인</a>
			</c:if>

			<!-- 로그인 상태 -->
			<c:if test="${Auther != null}">

				<a id="tmenu" href="bord.jsp">고객센타</a>
				<a id="tmenu" href="${pageContext.request.contextPath}/sale/cartlist?cmid=${Auther.userid}">장바구니</a>
				<a id="tmenu" href="timeTable.jsp">나의kvmall</a>
				<a id="tmenu"
					href="${pageContext.request.contextPath}/product/register">상품등록</a>
				<a id="tmenu" href="${pageContext.request.contextPath}/auth/logout"
					id="logout"><span id="sp1"> ${Auther.username}님!</span>&nbsp;
					&nbsp;로그아웃</a>
			</c:if>
			
			<c:if test="${sAuther != null}">

				<a id="tmenu" href="bord.jsp">고객센타</a>
				<a id="tmenu" href="${pageContext.request.contextPath}/sale/cartlist?cmid=${Auther.userid}">장바구니</a>
				<a id="tmenu" href="timeTable.jsp">나의kvmall</a>
				<a id="tmenu"
					href="${pageContext.request.contextPath}/product/register">상품등록</a>
				<a id="tmenu" href="${pageContext.request.contextPath}/auth/logout"
					id="logout"><span id="sp1"> ${sAuther.username}님!</span>&nbsp;
					&nbsp;로그아웃</a>
			</c:if>

		</div>

	

<div id="cartlist">
	<hr id="hr1">
<table >
<tr>
<th>상품/옵션정보</th><th>수량</th><th>상품금액</th><th>할인금액</th><th>할인적용금액</th><th>배송비</th><th>주문</th>
</tr>
<c:forEach var="cart" items="${crt }">
								<tr>
									<td>${cart.pname }</td>
									<td>	${cart.cnt }		</td>
									<td>${cart.totalprice }</td>
									<td></td>
									<td>${cart.totalprice }</td>
									<td></td>
									<td><button id="orderbtn">주문하기</button><br><br>
									<button id="dellbtn">삭제하기</button>
									</td>
									
								</tr>
							</c:forEach>
</table>

</div>

 

</body>
</html>