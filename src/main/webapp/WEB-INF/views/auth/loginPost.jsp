<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
alert("login 에 실패 했습니다")
</script>
<p> 회원가입을 하시겠습니까</p>
<a href = "${pageContext.request.contextPath}/member/register"><button>회원가입</button> </a>
<a href = "${pageContext.request.contextPath}/product/listAll"><button>상품보기</button> </a>

</body>
</html>