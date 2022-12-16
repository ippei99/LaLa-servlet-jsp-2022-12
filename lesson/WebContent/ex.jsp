<%@ page contentType="text/html; charset=UTF-8" import="ex.*" %>
<% Employee emp = new Employee("0001", "湊 雄輔"); %>
<!DOCTYPE html>
<html>
<head>
<body>
<% for (int i=0; i<10; i++){ %>
	<% if(i % 3 == 0){%>
		<div style="color: red">
	<% } else { %>
		<div>
	<% } %>
	IDは <%=emp.getId()%>、名前は<%=emp.getName()%>です。</div>
<% } %>
</body>
</html>