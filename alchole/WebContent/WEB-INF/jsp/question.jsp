<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問</title>
</head>
<body>
	<h1>質問</h1>
	<form action="/alchole/ask" method="post">
		名前:<input type="text" name="name"><br>
		年齢:<input type="text" name="age">才<br>
		<input type="submit" value="診断">
	</form>
</body>
</html>