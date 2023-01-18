<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ゲットエレメントヒーローズch</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/oza.css">
</head>
<body>
	<span data-mce-type="bookmark" style="display: inline-block; width: 0px; overflow: hidden; line-height: 0;"
    class="mce_SELRES_start"></span>

	<div id="wrap">
	    <h1>nyuuge-zya-改め<br>ゲットエレメントヒーローズch</h1>
	    <nav>
	      <ul>
	        <li><a href="/docoTsubu13/Main">マルチ</a></li>
	        <li><a href="https://www.google.com">先生</a></li>
	        <li><a href="/docoTsubu13/game">ゲットエレメントヒーローズ２体験版</a></li>
	      </ul>
	    </nav>
	    
	    <article>
	      <h1>マルチ</h1>
	      <p>マルチ中に放置、電源やタスクを切るなどの行為はおやめください</p>
	      <h2><a href="#">ゲットエレメントヒーローズ２のバージョンアップが１月２３日に開始‼</a></h2>
	    </article>
    
		<section>
	      <h1>くちこみ募集一覧</h1>
	      <ol>
	        <li>ファイナルファンタジー(中止)</li>
	        <li>モンスターストライク（中止）</li>
	        <li>ゲットエレメントヒーローズ（絶賛受付中）</li>
	      </ol>
	   	</section>
		</div>
		
  	 	<div id="wrap">
			<p>
				<c:out value="${loginUser.name}" />さん、ログイン中
			<a href="/docoTsubu13/Logout">ログアウト</a>
			</p>
			<p><a href="/docoTsubu13/Main">更新</a></p>
			<form action="/docoTsubu13/Main" method="post">
			<input type="text" name="text">
			<input type="submit" value="つぶやく">
			</form>
			
			<c:if test="${not empty errorMsg}">
				<p style="color:red:">${errorMsg}</p>
			</c:if>
			<c:forEach var="mutter" items="${mutterList}">
				<p>
					<c:out value="${mutter.userName}" />:
					<c:out value="${mutter.text}" />
				</p>
			</c:forEach>
		</div>
</body>
</html>