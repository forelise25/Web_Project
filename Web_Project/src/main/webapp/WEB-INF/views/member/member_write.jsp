<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/member_header.jsp" %>
<script>
$(function(){
	  $('input').addClass('form-control');
});
</script>
</head>
<body>
<%@ include file="../include/member_menu.jsp"%>
<div class="container" style="width:50%;">

<h2>회원등록폼</h2>

<form name="form1" method="post" action="${path}/member/insert.do">
<table class="table table-hover" width="50%">
	<tr>	
		<td>아이디</td>
		<td><input name="userId"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="userPw"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input name="userName"></td>
	</tr>
	<tr>
		<td>이메일주소</td>
		<td><input name="userEmail"></td>
	</tr>
	
	<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.userId}</td>
			<td>${row.userName}</td>
			<td>${row.userEmail}</td>
			<td>${row.userRegdate}</td>
		</tr>
	</c:forEach>
</table>
<center>
	<input type="submit" style="width:100px; display: inline;" value="확인">
	<input type="reset" style="width:100px; display: inline;" value="취소">
</center>
</form>
</div>
</body>
</html>