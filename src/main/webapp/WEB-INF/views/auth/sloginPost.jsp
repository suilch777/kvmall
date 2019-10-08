<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#login-box{
margin-top:300px;
text-align: center;
}
</style>
</head>
<body>
<div id="login-box">
<script type="text/javascript">

</script>
<p> login 에 실패 했습니다</p>
<a href = "${pageContext.request.contextPath}/auth/sLogin"><button style="width:100pt; height:80px; background-color:red;">로그인</button> </a><br><br><br><br>
<a href = "${pageContext.request.contextPath}/member/sregister"><button>회원가입</button> </a>
<a href = "${pageContext.request.contextPath}/product/listAll"><button>상품보기</button> </a>

</div>

</body>
</html>