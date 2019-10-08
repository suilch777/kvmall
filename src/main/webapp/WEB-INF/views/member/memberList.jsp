<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		width:600px;
		border-collapse: collapse;
	}
	th, td{
		padding:5px 10px;
		border:1px solid gray;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>비번</th>
			<th>이름</th>
			<th>날짜</th>
		</tr>
	
	<c:forEach var="member" items="${list }">
		<tr>
			<td>${member.cmid }</td>
			<td>${member.password }</td>
			<td>${member.name }</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd  HH:mm:ss" value="${member.regdate }"/> </td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<a href="product/lastAll.jsp"><span style="color: red;">Kvmall</span></a>
</body>
</html>