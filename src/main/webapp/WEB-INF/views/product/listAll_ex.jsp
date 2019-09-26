<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

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

<div id="body1">
		<ul>
		<c:forEach var ="kvp" items="${list }">
		<li>
		${kvp.pic }
		${kvp.pname}
		${kvp.pcontent}
		${kvp.price}
		${kvp.dcprice}	
		</li>	
		</c:forEach>
		
		</ul>
		<ul>
		<li>  <a><img alt="" src="${pageContext.request.contextPath}/resources/images/p1.jpg" id=" bimg2"> <br>
		<span style="text-decoration: underline;">[여우진1탄]어제오늘
					부츠컷데님팬츠 <br>
				<br>
			</span> ★기장 선택 가능!★"한번 입어보세요"완전반해요~<br> 신소재원단 핏과편안함의 끝판왕!!<br> <span
				style="text-decoration: line-through;">&#92;48,000 </span>할인가 &#92;  40,000
				
		</a>
		 </li>
		<li><a href="${pageContext.request.contextPath}/product/pRead" id="bimg"><img alt="" src="${pageContext.request.contextPath}/resources/images/p2.jpg"> </a>  </li>
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

</body>
</html>