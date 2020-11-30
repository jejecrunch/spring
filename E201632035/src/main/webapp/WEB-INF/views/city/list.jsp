<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>도시목록</h1>
  <a href="create" class="btn">도시등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>도시</th>
        <th>도</th>
        <th>인구</th>
        <th>면적</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="city" items="${ cities }">
        <tr data-url="edit?id=${ city.id }">
          <td>${ city.id }</td>
          <td>${ city.name }</td>
          <td>${ city.district.districtName }</td>
          <td>${ city.population }</td>
          <td>${ city.area }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

