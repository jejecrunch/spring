<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}common.css">
  <style>
    form { width: 700px; margin: auto;
      box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    form div { margin: 20px; }
    div.buttons label { margin-right: 20px; }
    button { margin: 10px; padding: 0.5em 2em; }
    ul { margin-top: 30px; }
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="form1">
    <div class="buttons">
        <form:radiobuttons path="departmentId1" itemValue="id" 
                           itemLabel="shortName" items="${ departments }" />
    </div>
    <div class="buttons">
        <form:radiobutton path="departmentId2" value="1" label="소프" />
        <form:radiobutton path="departmentId2" value="2" label="컴공" />
        <form:radiobutton path="departmentId2" value="3" label="정통" />
        <form:radiobutton path="departmentId2" value="4" label="글티" />
    </div>
    <hr />
    <button type="submit">저장</button>
  </form:form>  
  
  <ul>
    <li>departmentId1 : ${ form1.departmentId1 }</li>  
    <li>departmentId2 : ${ form1.departmentId2 }</li>  
  </ul>  
</div>
</body>
</html>

