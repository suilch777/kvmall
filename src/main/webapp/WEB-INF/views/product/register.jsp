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

div {
	margin-top: 100px;
	padding: 50px;
	border: 1px solid blue;
	border-radius: 10px;
	width: 460px;
}
p{
	
	margin: 20px;
	text-align: left;
	
}
input{
	margin-right: 100px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>

<script>
	$(function() {
	/* 	$("button[type=button]").click(function() {
			alert("   ");
			$(".error").css("display", "none");

			//빈 input태그가 존재하면 submit을 막도록 한다.
			if (checkInputEmpty($("input[name]")) == false) {
				return false;
			}
			
			alert("   ");
			$("#f1").submit();
		}) */
	})
</script>
</head>
<body>
<div>
	<form action="register"	method="post" id="f1" enctype="multipart/form-data">
		
				
		<p>
			<label>상품코드</label> <input type="text" name = "pcode" size="50" value="p">
			<!--  <span class="error">프로젝트 이름을 입력하세요.</span>  -->
		</p>
		<p>
			<label>상품이름</label>
			<input type="text" name="pname" size="50">
		</p>

		<p>
			<label>상품설명</label> 
			<textarea name="pcontent" rows="10" cols="60"></textarea>
		</p>

		<p>
			<label>상품가격</label><br> &nbsp;&nbsp;<input type="number" name="price">
		</p>
		<p>
			<label>상품할인가격</label><br>&nbsp; <input type="number" name="dcprice">
		</p>
		

		<p>
			<label>상품색상</label>&nbsp; <select name= "color">
			<option value="흰색">흰색</option>
			<option value= "빨강">빨강</option>
			<option value="파랑">파랑</option>
			<option value="검정">검정</option>
			
			</select>
		</p>
		<p>
			<label>상품사이즈</label> <select name= "size">
			<option value="85">85</option>
			<option value= "90">90</option>
			<option value="95">95</option>
			<option value="100">100</option>
			
			</select>
		</p>
		<p>
			<label>사진</label><input type="file" name ="imgFiles" value="등록" multiple="multiple">
		</p>
		
		<p>
			<label>상품갯수</label><input type="number" name ="stock" >
		</p>
		<p>
			<button type="submit">상품등록</button>
		</p>
	</form>

</div>

</body>
</html>