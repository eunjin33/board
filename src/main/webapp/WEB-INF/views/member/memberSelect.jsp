<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 세부사항</title>
</head>
<body>
<jsp:include page="../home/header.jsp"></jsp:include>
	<div align="center">
		<div><h1>로그인 회원 조회</h1></div>
		<div>
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td width="200" align="center">${member.id }</td>
				</tr>
				<tr>
					<th width="100">이 름</th>
					<td width="200" align="center">${member.name }</td>
				</tr>
				<tr>
					<th width="100">주 소</th>
					<td width="200" align="center">${member.address }</td>
				</tr>
				<tr>
					<th width="100">전화번호</th>
					<td width="200" align="center">${member.tel }</td>
				</tr>
			</table>
			<div>
				<form id="frm" action="" method="post">
					<input type="hidden" id="id" name="id" value="${member.id }">
				</form>
			</div>
		</div>
	</div>
</body>
</html>