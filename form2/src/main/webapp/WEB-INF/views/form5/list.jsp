<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>  
  <script src="${R}common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
  <style>
    table.list { display: inline-block; }
    td:nth-child(1) { text-align: center; }
    td:nth-child(2) { text-align: center; min-width: 30px; }
    input[name=name] { width: 250px; }
    input[name=shortName] { width: 80px; }
    input[name=phonename] { width: 120px; }
  </style>
</head>
<body>
<div class="container">
  <h1>학과목록</h1>
  
  <form method="post" action="process">
    <table class="list">
      <thead>
        <tr>
          <th><button type="submit" class="btn-mini" name="cmd" value="delete"
                      data-confirm-delete>삭제</button></th>
          <th>ID</th>
          <th>학과명</th>
          <th>단축명</th>
          <th>전화</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="department" items="${ departments }">
          <tr>
            <td><input type="checkbox" name="idChecked" value="${ department.id }" /></td>
            <td><input type="hidden" name="id" value="${ department.id }" /> ${ department.id }</td>
            <td><input type="text" name="name" value="${ department.name }" /></td>
            <td><input type="text" name="shortName" value="${ department.shortName }" /></td>
            <td><input type="text" name="phone" value="${ department.phone }" /></td>
          </tr>
        </c:forEach>
        <tr>
           <td></td>
           <td><input type="hidden" name="id" value="0" /></td>
           <td><input type="text" name="name" /></td>
           <td><input type="text" name="shortName" /></td>
           <td><input type="text" name="phone" /></td>
        </tr>
      </tbody>
    </table>
    <button type="submit" class="btn" name="cmd" value="save">저장</button>    
    
  </form>
</div>
</body>
</html>

