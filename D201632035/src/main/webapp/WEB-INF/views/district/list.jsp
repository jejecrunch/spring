<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="/common.js"></script>
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    h3 { margin-bottom: 2px; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
    td:nth-child(3), td:nth-child(4) { text-align: right; }
  </style>
</head>
<body>
<div class="container">
  <h1>도별 도시</h1>
  <c:forEach var="district" items="${ districts }">
    <h3>${ district.id } - ${ district.districtName }</h3>
    <table class="list">
      <thead>
        <tr>
          <th>id</th>
          <th>도시</th>
          <th>인구</th>
          <th>면적</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="city" items="${ district.cities }">
          <tr>
            <td>${ city.id }</td>
            <td>${ city.name }</td>
            <td>${ city.population }</td>
            <td>${ city.area }</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </c:forEach>
</div>
</body>
</html>

