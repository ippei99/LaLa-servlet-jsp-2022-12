<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Health" %>
<%
// リクエストスコープに保存されたHealthインスタンスを取得
Health health = (Health)request.getAttribute("health");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
	<h1>スッキリ健康診断</h1>
	<p>
	身長:<%= health.getHeight() %>
	体重:<%= health.getWeight() %>
	BMI:<%= health.getBmi() %>
	体型:<%= health.getBodyType() %>
	</p>
	<a href="/mvc7/HealthCheck">戻る</a>
</body>
</html>