<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Hero" %>
<%@ page import="model.Dragon" %>
<%
Hero hero = (Hero) application.getAttribute("hero");
Dragon dragon = (Dragon) application.getAttribute("dragon");
String dragonAttack = (String)request.getAttribute("dragonAttack");
String heroAttack = (String)request.getAttribute("heroAttack");

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ゲットエレメントヒーローズ2</title>

</head>
<body>
	<h1>ゲットエレメントヒーローズ2</h1>
	<% if (heroAttack != null){ %>
	<p><%= heroAttack %></p>
	<% } %>
	<% if (dragonAttack != null){ %>
	<p><%= dragonAttack %></p>
	<% } %>
	<p><%= dragon %></p>
		<div class="q-img">
        	<img src="img/medama.png" alt="キャラクター1">
    	</div>
	<p><%= hero %></p>
		<div class="q-img">
        	<img src="img/shinsyakaijin.png" alt="キャラクター2">
    	</div>
	<p>どうする？</p>
	<form action="/docoTsubu13/game" method="post">
		<input type="radio" name="action" value="attack">攻撃する
		<input type="radio" name="action" value="runaway">逃げる
		<input type="submit" value="決定">
	</form>
	<a href="/docoTsubu13/Main">戻る</a>
</body>
</html>