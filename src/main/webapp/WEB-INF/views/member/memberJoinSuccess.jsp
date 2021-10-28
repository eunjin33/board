<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../home/header.jsp"></jsp:include>
</head>
<body>
	<div align="center">
		<div><h1>${message }</h1></div>
		<button type="button" onclick="location.href='memberLoginform.do'">로그인</button>
	</div>
</body>
</html>