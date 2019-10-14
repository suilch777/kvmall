<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	width: 75%;
	position: relative;
}

#top {
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

#slide {
	border: 1px solid #000;
	width: 700px;
	height: 400px;
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
	text-align: center;
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
	top: 100px;
	right: 10px;
	width: 200px;
	height: 700px;
	font-size: 14px;
	border: 1 px solid #D8D8D8s;
}

#pbfname {
	font-size: 16px;
	font-weight: bold;
}

#output {
	font-size: 16px;
	font-weight: bold;
}

#pbuyformin {
	display: none;
}

#buybtn {
	border-radius: 5%;
	width: 200px;
	height: 50px;
	background: red;
}

#body1 {
	text-align: center;
}

#totalprice{
display: none;
}
</style>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	//======================================test=======================$
	var ajaxsale = function(url, data){
	   
			
		        var smid = "${kvp.smid}";
				var pcode = "${kvp.pcode}";
				var pname = "${kvp.pname}";
				var cnt = $("#count").val(); 
				var tprice= $("#tprice").html();
				var price = Number(tprice);
				var cmid ="${Auther.userid}" 
					if(cmid == ""){
					
						alert("로그인이 필요합니다")
						location.href = "${pageContext.request.contextPath}/auth/login";
						
					}
				
					

				var cmid ="${Auther.userid}"
				/* var list ={
					smid :"${kvp.smid}",
				 	pcode : "${kvp.pcode}",
					pname :"${kvp.pname}",
					cnt : $("#count").val()
				}; */
				
				$.ajax({					
					type : "post",
					data : {
					 	 "cmid" : cmid,
						"smid":smid,
						"pcode" : pcode,
						"pname" : pname,
						"cnt" : cnt,
						"totalprice":price

						
					},
					url : url,
					dataType : "Json",
					success : data
					});
				}	
	//=================== 장바구니 담기  ==============================
		
		
		$(function() {
			$("#regcart").click(function() {
					
				
				ajaxsale(
						"${pageContext.request.contextPath}/sale/register",
						function(data){
							if(data!=0){
								alert("장바구니에 담았습니다!");
							}else{
								alert("이미 장바구니에 있습니다");
							}
						
					}
					
			)
		});
	});

	$(function() {
		$("#buybtn").click(function() {
				
			
			ajaxsale(
					"${pageContext.request.contextPath}/sale/saleregister",
					function(data){
						if(data!=0){
							alert("결제성공!");
						}else{
							alert("결제실패!");
							}
						
					}
					
			)
		});
	});


	
	
	
	//=================== 장바구니 담기  ==============================
	
		
	/* 	$(function() {
			$("#regcart").click(function() {
				  var smid = "${kvp.smid}";
				var pcode = "${kvp.pcode}";
				var pname = "${kvp.pname}";
				var cnt = $("#count").val(); 
				var tprice= $("#tprice").html();
				var price = Number(tprice);
				var cmid ="${Auther.userid}"
			
				if(cmid == ""){
					alert("로그인이 필요합니다")
					

         			location.href = "${pageContext.request.contextPath}/auth/login";
					
				}
				$.ajax({					
					type : "post",
					 async: false,
					data : {
					 	 "cmid" : cmid,
						"smid":smid,
						"pcode" : pcode,
						"pname" : pname,
						"cnt" : cnt,
						"totalprice":price
						
					},
					url : "${pageContext.request.contextPath}/sale/register",
					dataType : "Json",
					success : function(data) {
						if(data!=0){
						alert("장바구니에 담았습니다!");
						}else{
							alert("이미 장바구니에 있습니다");
						}
					}

				});
			});
		});

		//=================== 바로구매하기  ==============================
			
			$(function() {
			$("#buybtn").click(function() {
				var smid = "${kvp.smid}";
				var pcode = "${kvp.pcode}";
				var pname = "${kvp.pname}";
				var cnt = $("#count").val(); 
				var tprice= $("#tprice").html();
				var price = Number(tprice);
				var cmid ="${Auther.userid}"
			
				
				if(cmid == ""){
					alert("로그인이 필요합니다")
					

         			location.href = "${pageContext.request.contextPath}/auth/login";
					
				}
				$.ajax({					
					type : "post",
					async: false,
					data : {
						"pcode" : pcode,
						"smid":smid,
					 	"cmid" : cmid,												
						"pname" : pname,
						"totalprice":price,
						"cnt" : cnt						
					},
					url : "${pageContext.request.contextPath}/sale/salegister",
					dataType : "Json",
					success : function(data) {
						if(data!=0){
							alert("결제성공!");
							}else{
								alert("결제실패!");
							}
						
					}

				});
			});
		});

 */
	</script>





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
			<a href="${pageContext.request.contextPath}/product/listAll" id="comlogo">kvmall</a>

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
				<a id="tmenu" href="${pageContext.request.contextPath}/sale/cartlist">장바구니</a>
				<a id="tmenu" href="timeTable.jsp">나의kvmall</a>
				<a id="tmenu"
					href="${pageContext.request.contextPath}/product/register">상품등록</a>
				<a id="tmenu"
					href="${pageContext.request.contextPath}/sale/salelist">판매리스트</a>
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
			name="slide"> <br>
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

	<div id="content2">

		<img id="slide"
			src="${pageContext.request.contextPath}/resources/images/banner2.jpg"
			name="slide"> <br>
	</div>
	<script type="text/javascript">
				var step=1;
				function slideit2(){
					if (!document.images)
						return
					document.images.slide.src=eval("image"+step+".src");
					if(step<3)
						step++;
					else 
						step=1;
					setTimeout("slideit()",2500);
				}
				slideit2();
			</script>


	<!--  <hr id="hr2"> -->

	<div id="body1">

		<img id="pimg" alt="" src="displayFile?filename=${kvp.pic}">

	</div>


	<div id="pbuyform">
		<form action="${pageContext.request.contextPath}/sale/register" method="post">
			<input type="hidden" name="smid" value="${kvp.smid}">
			<label></label><input type="text" name="pcode" value="${kvp.pcode}"
				id="pbuyformin"> <br> <span id="pbfname"
				style="text-decoration: underline;">${kvp.pname}<input
				type="text" name="pname" value="${kvp.pname}" id="pbuyformin"></span>
			<br> <br> <br> ${kvp.pcontent}<br> <br> <br>
			<label>가격</label><span style="text-decoration: line-through;">
				&#92;${kvp.price} </span> <input type="number" name="price"
				value="${kvp.price}" id="pbuyformin"><br> <br> <label>할인가</label>
			&#92; ${kvp.dcprice} <input type="number" name="dcprice"
				value="${kvp.dcprice}" id="pbuyformin"><br> <br> <br>
			<label>색상</label>&nbsp; <select name="color">
				<option value="흰색">흰색</option>
				<option value="빨강">빨강</option>
				<option value="파랑">파랑</option>
				<option value="검정">검정</option>

			</select> <br> <br> <label>사이즈</label> <select name="size">
				<option value="85">85</option>
				<option value="90">90</option>
				<option value="95">95</option>
				<option value="100">100</option>
			</select> <br> <br> <label>수량</label><select id="count">
				<c:forEach var="i" begin="1" end="10">
					<option><c:out value="${i}" /></option>
				</c:forEach>
			</select> <br> <br> <label>총&nbsp;합계금액&nbsp;(수량)</label> <br> <br>
			<div id="output"></div>
			
			<div id="tprice"></div>

<!-- ==================body--footer ============================ -->


			<script type="text/javascript">
				$("#count").change(onSelectChange); //select  id를 이용하여 셀렉트 변경시마다 onSelectChange함수 실행
				$("#count").change();
				function onSelectChange() {
					var selected = $("#count option:selected");
					var output = "";
					if (selected.val() != 0) {
						output = selected.text();
					}
					var num = output;
					var price = ${kvp.dcprice};
					var sum = num * price;

					function numberWithCommas(x) {
						return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g,
								",");
					}

					$("#output").html(
							"&#8361;" + numberWithCommas(sum) + "원" + "&nbsp;("
									+ num + ")"); //div에 output 변수에 담은 text HTML로 출력하기
									$("#tprice").html(sum);
				}
				
			</script>


			<br> <br>
			
		</form>
		
		<input type="button" name="buybtn" value="바로구매" id="buybtn"><br>
		<br> <input type="button" name="cartbtn" value="장바구니담기" id="regcart"> 
		<input type="button" name="wishbtn" value="찜하기">
	</div>


<h1>${Auther.userid}</h1>
</body>
</html>