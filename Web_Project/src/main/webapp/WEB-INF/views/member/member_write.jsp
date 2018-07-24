<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/member_menu.jsp"%>
<h2>회원등록폼</h2>

<form name="form1" method="post" action="${path}/member/insert.do">
<table border="1" width="50%">
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
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="확인">
			<input type="reset" value="취소">
		</td>
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
</form>
</body>
</html>