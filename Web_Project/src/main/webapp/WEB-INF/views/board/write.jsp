<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/member_header.jsp" %>
<style>
form div{
	margin-top:20px;
	margin-bottom:20px;
}
span{
	font-weight: 600;
	margin-bottom: 10px;
}
</style>
</head>
<body>
<div class="container" style="width:50%;"> 
<%@ include file="../include/member_menu.jsp" %>
<%@ include file="../login/sessionCheck.jsp" %>
<h2>게시글 작성</h2>
<form name="form1" method="post" action="${path}/board/insert.do">
	<div><span>제 목</span>
		<input name="title" id="title" size="80" placeholder="제목을 입력하세요."/>
	</div>
	<div><span>내 용</span>
		<textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력하세요."></textarea>
	</div>
	<!-- 
	<div><span>작성자</span>
		<input name="writer" id="writer" placeholder="이름을 입력하세요."/>
	</div>
	 -->
	<div style="width:100%; text-align:center; margin-top:20px; margin-bottom:20px;">
		<button type="button"  class="btn btn-default"  id="btnSave">확인</button>
		<button type="reset"  class="btn btn-default" >취소</button>
	</div>
</form>
<script>
	$(function(){
		  $('input').addClass('form-control');
		  $('textarea').addClass('form-control');
	});
	$(document).ready(function(){
		$("#btnSave").click(function(){
			var title=$("#title").val();
			var content=$("#content").val();
			var writer=$("#writer").val();
			if(title==""){
				alert("제목을 입력하시오.");
				document.form1.title.focus();
				return;
			}
			if(content==""){
				alert("내용을 입력하시오.");
				document.form1.content.focus();
				return;
			}
			if(writer==""){
				alert("작성자를 입력하시오.");
				document.form1.writer.focus();
				return;
			}
			document.form1.submit();
		});
	});
</script>
</div>
</body>
</html>