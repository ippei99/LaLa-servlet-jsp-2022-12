<%-- pageディレクティブ --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- スクリプトレット --%>
<%
String name = "湊　雄輔";
int age = 23;
%>

<%-- JSPコメント --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- HTMLのコメント --%>
<body>
	私の名前は<%=name%>。年齢は<%=age%>才です。
</body>
</html>