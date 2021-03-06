<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호변경</title>
<style type="text/css">
input:nth-child(1) {
	display: none;
}
</style>
<style>
* {
	margin: 0 auto;
}

form {
	margin-top: 100px;
	padding: 50px;
	border: 1px solid blue;
	border-radius: 10px;
	width: 460px;
}

input {
	text-align: center;
}

p {
	margin: 20px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#f2").submit(
				function() {

					/*    //빈 input태그가 존재하면 submit을 막도록 한다.
					if (checkInputEmpty($("input[name]")) == false) {
						
						return false;
					}      */
				 	
					var passReg = /^[a-z0-9!@#$%^&]{8,20}$/;
					var pass = $("input[name='newPwd']").val();
					
		 						
					if (passReg.test(pass) == false) {
						//	$("input[name='password']").next().css("display","inline");
						alert("암호(영어,숫자,특수문자 8~20)를 입력하세요");
						return false;
					}
					//password일치하지 않을때
					if ($("input[name='newPwd']").val() != $(
							"input[name='confirmPwd']").val()) {
						//$("input[name='confirmPassword']").next().next().css("display","inline");	
						alert("새비밀번호가 일치하지 않습니다");
						return false;
					}
 
				});
	});
</script>


</head>
<body>
	<form action="${pageContext.request.contextPath }/spms/changePwd.do"
		method="post" id="f2">
		<p>

			${Auth.name }님의 암호를 변경 하시겠습니까? <input type="text" name="userid"
				value="${Auth.id }">
		</p>
		<p>
			현재암호:<br> <input type="password" name="curPwd">
			<c:if test="${errors.curPwd }">현재암호를 입력하세요</c:if>
			<c:if test="${badCurPwd == true }">
			<script>
					alert("현재암호가 일치 하지 않습니다");
				</script></c:if>
			
		</p>
		<p>
			새암호:<br> <input type="password" name="newPwd">
			<c:if test="errors.newPwd">새 암호를 입력 하세요</c:if>
		</p>

		<p>
			새암호확인:<br> <input type="password" name="confirmPwd">
			<c:if test="errors.confirmPwd">암호 확인란을 입력하세요</c:if>
		</p>
		<input type="submit" value="암호변경" id="smtf2"> <a
			href="${pageContext.request.contextPath }/index.jsp">[홈페이지 가기]</a>



	</form>
</body>
</html>