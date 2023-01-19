<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nyuuge-zya-（どこつぶ版）</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/oza.css">
</head>
<body>
	<span data-mce-type="bookmark" style="display: inline-block; width: 0px; overflow: hidden; line-height: 0;"
    class="mce_SELRES_start"></span>

	<div id="wrap">
	    <h1>nyuuge-zya-（どこつぶ版）</h1>
	    <nav>
	      <ul>
	        <li><a href="/docoTsubu13/Main">マルチ</a></li>
	        <li><a href="https://www.google.com">先生</a></li>
	        <li><a href="https://ja.wikipedia.org/wiki/%E5%B0%BE%E5%B4%8E%E4%B8%96%E7%95%8C%E8%A6%B3">世界観</a></li>
	        <li><a href="/docoTsubu13/game">getElementHeroes2体験版</a></li>
	      </ul>
	    </nav>
	    
	    <article>
	      <h1>マルチ</h1>
	      <p>マルチ中に放置、電源やタスクを切るなどの行為はおやめください</p>
	      <h2><a href="#">ゲットエレメントヒーローズ２のバージョンアップが１月２３日に開始‼</a></h2>
	    </article>
    
		<section>
	      <h1>つぶやき募集一覧</h1>
	      <ol>
	        <li>ファイナルファンタジー</li>
	        <li>モンスターストライク</li>
	        <li>ゲットエレメントヒーローズ</li>
	        <li>授業でわからない事等</li>
	      </ol>
	   	</section>
		</div>
		
  	 	<div id="wrap">
			<p>
				<c:out value="${loginUser.name}" />さん、ログイン中
			<a href="/docoTsubu13/Logout">ログアウト</a>
			</p>
			<p><a href="/docoTsubu13/Main">更新</a></p><br>
			<form action="/docoTsubu13/Main" method="post">
			<input type="text" name="text">
			<input type="submit" value="つぶやく">
			</form><br>
			
			<c:if test="${not empty errorMsg}">
				<p style="color:red:">${errorMsg}</p>
			</c:if>
			<c:forEach var="mutter" items="${mutterList}">
				<p>
					<c:out value="${mutter.fd}" /> 
					<c:out value="${mutter.userName}" />:
					<c:out value="${mutter.text}" />
				</p>
			</c:forEach>
		</div>
</body>
</html>