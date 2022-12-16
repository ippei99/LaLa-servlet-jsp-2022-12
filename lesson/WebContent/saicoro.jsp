<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="toba.*" %>
<%
Saicoro sai = new Saicoro();
int me = sai.getEye();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>丁半</title>
</head>
<body>
<div>
<% if(me % 2 == 0){ %>
	丁
<% } else {%>
    半
<% } %>
です。</div>
</body>
</html>