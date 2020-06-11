<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		<!-- 부트스트랩 -->
    	<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    	<script src="/resources/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<ul class="nav mt-3">
			  <li class="nav-item">
			    <a class="nav-link" href="/">HOME</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link active" href="/insert.do">파일업로드</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#">Link</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link disabled" href="#">Disabled</a>
			  </li>
			</ul>

			<h1 class="mt-3">이미지 뷰 화면</h1>	
			<img src="/resources/uploadimg/${param.imgName }" class="rounded mx-auto d-block"/>
		</div>
</body>
</html>
