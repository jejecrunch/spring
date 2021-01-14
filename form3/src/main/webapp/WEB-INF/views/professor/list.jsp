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
    td:nth-child(1) { text-align: center; }
    td:nth-child(2) { text-align: center; min-width: 30px; }
    input[name=name] { width: 100px; }
    input[name=phone] { width: 120px; }
    input[name=email] { width: 150px; }
    input[name=office] { width: 70px; }
  </style>
</head>
<body>
<div class="container">
  <h1>교수목록</h1>
  
  <form method="post" action="process">
    <table class="list condensed">
      <thead>
        <tr>
          <th><button type="submit" class="btn-mini" name="cmd" value="delete"
                      data-confirm-delete>삭제</button></th>
          <th>ID</th>
          <th>이름</th>
          <th>학과</th>
          <th>전화</th>
          <th>이메일</th>
          <th>연구실</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="professor" items="${ professors }">
          <tr>
            <td><input type="checkbox" name="idChecked" value="${ professor.id }" /></td>
            <td><input type="hidden" name="id" value="${ professor.id }" /> ${ professor.id }</td>
            <td><input type="text" name="name" value="${ professor.name }" /></td>
            <td>
              <select name="departmentId">
                <c:forEach var="department" items="${ departments }">
                  <option value="${ department.id }" 
                          ${ department.id == professor.department.id ? "selected" : "" }>
                      ${ department.name }
                  </option>
                </c:forEach>
              </select>
            </td>
            <td><input type="text" name="phone" value="${ professor.phone }" /></td>
            <td><input type="text" name="email" value="${ professor.email }" /></td>
            <td><input type="text" name="office" value="${ professor.office }" /></td>
          </tr>
        </c:forEach>
        <tr>
           <td></td>
           <td><input type="hidden" name="id" value="0" /></td>
           <td><input type="text" name="name" /></td>
           <td>
             <select name="departmentId">
               <c:forEach var="department" items="${ departments }">
                 <option value="${ department.id }">${ department.name }</option>
               </c:forEach>
             </select>
           </td>
           <td><input type="text" name="phone" /></td>
           <td><input type="text" name="email" /></td>
           <td><input type="text" name="office" /></td>
        </tr>
      </tbody>
    </table>
    <button type="submit" class="btn" name="cmd" value="save">저장</button>    
    
  </form>
</div>
</body>
</html>

