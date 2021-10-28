<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript">
	function CallValidation() {
		var pw = frm.password.value;
		var pw1 = frm.password1.value;
		
		if(frm.name.value == ""){
			alert("이름을 넣어주세요");
			frm.name.focus();
			return false;
		}
		
		if(pw == pw1){
			frm.submit();
		}else {
			alert("패스워드가 일치 하지 않습니다");
			frm.password.value="";
			frm.password1.value="";
			frm.password.focus();
			return false;
		}
	}
</script>
</head>
<body>
<jsp:include page="../home/header.jsp"></jsp:include>
	<div align="center">
		<div><h1>회 원 가 입</h1></div>
		<div>
			<form id="frm" action="memberJoin.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">아 이 디</th>
							<td width="200">
								<input type="text" id="id" name="id" required="required">
							</td>
						</tr>	
						<tr>
							<th width="150">패스워드</th>
							<td width="200">
								<input type="password" id="password" name="password" required="required">
							</td>
						</tr>	
						<tr>
							<th width="150">패스워드 확인</th>
							<td width="200">
								<input type="password" id="password1" name="password1" required="required">
							</td>
						</tr>	
						<tr>
							<th width="150">이 름</th>
							<td width="200">
								<input type="text" id="name" name="name" required="required">
							</td>
						</tr>	
						<tr>
							<th width="150">주 소</th>
							<td width="200">
								<input type="text" id="address" name="address">
							</td>
						</tr>	
						<tr>
							<th width="150">전화번호</th>
							<td width="200">
								<input type="text" id="tel" name="tel">
							</td>
						</tr>	
					</table>
				</div><br>
					<input type="hidden" id="author" name="author" value="USER">
					<input type="button" value="회원가입" onclick="CallValidation()">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취 소">
					
			</form>
		</div>
	</div>
</body>
</html>