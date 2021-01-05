<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
  <style>
    td:nth-child(1) { text-align: center; min-width: 30px; }  
  </style>
</head>
<body>
<div class="container">
  <h1>학과목록</h1>
  
  <form method="post" action="insert">
    <table class="list condensed">
      <thead>
        <tr>
          <th>ID</th>
          <th>학과명</th>
          <th>단축명</th>
          <th>전화</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="department" items="${ departments }">
          <tr>
            <td>${ department.id }</td>
            <td>${ department.name }</td>
            <td>${ department.shortName }</td>
            <td>${ department.phone }</td>
          </tr>
        </c:forEach>
        <tr>
           <td></td>
           <td><input type="text" name="name" style="width: 250px;" /></td>
           <td><input type="text" name="shortName" style="width: 80px;" /></td>
           <td><input type="text" name="phone" style="width: 120px;" /></td>
           <td><button type="submit" class="btn">저장</button></td>
        </tr>
      </tbody>
    </table>
  </form>

</div>
</body>
</html>

