<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="/common.js"></script>
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>제품 목록</h1>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>제품명</th>
        <th>카테고리</th>
        <th>가격</th>
        <th>수량</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="product" items="${ products }">
        <tr data-url="edit?id=${ product.id }">
          <td>${ product.id }</td>
          <td>${ product.name }</td>
          <td>${ product.title }</td>
          <td>${ product.price }</td>
          <td>${ product.quantity }</td>
         </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

