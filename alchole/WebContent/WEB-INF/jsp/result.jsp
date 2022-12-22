<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>    
<%
// リクエストスコープに保存されたUserインスタンスを取得
User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>
	<h1>飲酒許可判定</h1>
	<p>
	<%= user.getAns() %>
	</p>
	<a href="/alchole/ask">戻る</a>
</body>
</html>
