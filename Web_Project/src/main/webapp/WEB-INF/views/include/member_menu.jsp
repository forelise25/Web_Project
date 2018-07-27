<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- context 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/global.css">
    <div style="text-align: center; margin-top:17px;">
        <a href="${path}/member/list.do">회원관리</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="${path}/board/list.do">게시판</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="${path}/member/write.do">회원가입</a>
        <c:choose>
        <c:when test="${sessionScope.userId==null}">
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="${path}/login/login.do">로그인</a>
        </c:when>
        <c:otherwise>
       	 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	<a href="${path}/login/logout.do">로그아웃</a>
        </c:otherwise>
        </c:choose>
    </div>
    <hr>
