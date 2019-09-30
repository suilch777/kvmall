<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
	#f1{
	width:75%;
	text-align:center;
	margin-top: 200px;
	
	}
	</style>
	
</head>
<body>
<div id="f1">
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h1><a href="${pageContext.request.contextPath}/product/listAll ">List</a></h1>
</div>

</body>
</html>
