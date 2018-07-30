<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
<%@ include file="../include/member_header.jsp" %>
<script>
	$(function(){
		$("#btnLogin").click(function(){
			var userId = $("#userId").val();
			var userPw = $("#userPw").val();
			if(userId ==""){
				alter("아이디를 입력하세요");
				$("#userId").focus();
				return;
			}
			if(userPw ==""){
				alter("비밀번호를 입력하세요");
				$("#userPw").focus();
				return;
			}
			document.form1.action = "${path}/login/loginCheck.do";
			document.form1.submit();
		});
	});
</script>
</head>
<body>
<%@ include file="../include/member_menu.jsp"%>
<h2>로그인</h2>
<form name="form1" method="post">
	<table width="40%" class="table table-hover">
		<tr>
			<td>아이디</td>
			<td><input name="userId" id="userId"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw" id="userPw"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btnLogin">로그인</button>
				<c:if test="${msg=='failure'}">
					<div style="color:red">
						아이디 또는 비밀번호가 일치하지 않습니다.
					</div>
				</c:if>
				<c:if test="${msg=='logout'}">
					<div style="color:red">로그아웃되었습니다.</div>
				</c:if>
			</td>
		</tr>
	</table>
</form>
</body>
</html>