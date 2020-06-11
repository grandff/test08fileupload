<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
			    <a class="nav-link " href="/">HOME</a>
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

			<h1 class="mt-3">입력화면(파일 업로드)</h1>

			<form action="insertOK.do" method="POST" enctype="multipart/form-data">
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="name">이름</label> 
					<input type="text" class="form-control" name="name" id="name" 	placeholder="이름입력" maxlength="10">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="tel">전화번호</label> 
					<input type="text" class="form-control" name="tel" id="tel" 	placeholder="전화번호입력" maxlength="10">
			    </div>
			  </div>					
				<div class="form-group">
					<label for="multipartFile">파일 업로드</label> 
					<input type="file" class="form-control-file" id="multipartFile" name="multipartFile">
				</div>
				<div class="text-center mt-3">
					<input type="submit" value="등록" class="btn btn-primary">
					<a href="/selectAll.do" class="btn btn-secondary">목록</a>
				</div>	
			</form>
			
			<h1 class="mt-5">입력화면(Spring Tag, @ModelAttribute)</h1>
			<form:form modelAttribute="tvo" action="insertOK.do" method="POST" enctype="multipart/form-data">
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="name">이름</label> 
					<input type="text" class="form-control" name="name" id="name" 	placeholder="이름입력" maxlength="10">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="tel">전화번호</label> 
					<input type="text" class="form-control" name="tel" id="tel" 	placeholder="전화번호입력" maxlength="10">
			    </div>
			  </div>					
				<div class="form-group">
					<label for="multipartFile">파일 업로드</label> 
					<input type="file" class="form-control-file" id="multipartFile" name="multipartFile">
				</div>
				<div class="text-center mt-3">
					<input type="submit" value="등록" class="btn btn-primary">
					<a href="/selectAll.do" class="btn btn-secondary">목록</a>
				</div>	
			</form:form>
			
			<h1 class="mt-5">입력화면(@RequestParam)</h1>
			<form action="insertOK2.do" method="POST" enctype="multipart/form-data">
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="key01">이름</label> 
					<input type="text" class="form-control" name="key01" id="key01" 	placeholder="이름입력" maxlength="10">
			    </div>
			    <div class="form-group col-md-6">
			      <label for="key02">전화번호</label> 
					<input type="text" class="form-control" name="key02" id="key02" 	placeholder="전화번호입력" maxlength="10">
			    </div>
			  </div>					
				<div class="form-group">
					<label for="key03">파일 업로드</label> 
					<input type="file" class="form-control-file" id="key03" name="key03">
				</div>
				<div class="text-center mt-3">
					<input type="submit" value="등록" class="btn btn-primary">
					<a href="/selectAll.do" class="btn btn-secondary">목록</a>
				</div>	
			</form>
		</div>
</body>
</html>
