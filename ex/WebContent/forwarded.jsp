<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int r = (Integer)request.getAttribute("number");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwarded</title>
</head>
<body>
	<h1>forwarded</h1>
	<p>偶数だよ <%= r %></p>
	<p><a href="/ex/ex62">もう一度やる</a></p>
</body>
</html>