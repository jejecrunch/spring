<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- spring security 확장 태그를 사용하기 위한 선언 -->
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}res/common.css">
  <style>
    div.box { padding: 50px; width: 300px; }
  </style>
</head>
<body>
<div class="container">
  <div class="box">
    <h1>첫 페이지</h1>

	<!-- 로그인하지 않은 사용자에게만 로그인, 사용자 등록 버튼이 출력됨 -->
    <sec:authorize access="not authenticated">
      <a class="btn" href="${R}login">로그인</a>
      <a href="register" class="btn">사용자 등록</a>
    </sec:authorize>
    <!-- 로그인한 사용자에게는 이 두 버튼이 출력됨 -->
    <sec:authorize access="authenticated">
      <a class="btn" href="${R}user/index">사용자 페이지</a>
      <!-- href 값은 security config에서 설정한 값과 일치해야함 -->
      <a class="btn" href="${R}logout_processing">로그아웃</a>
    </sec:authorize>
  </div>
</div>
</body>
</html>

