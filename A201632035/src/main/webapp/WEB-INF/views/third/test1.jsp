<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <table border="1">
	<tr align="center" >
	<th>ID</th> <th>학번</th> <th>이름</th> <th>이메일</th>
	</tr>
    <tr>
    <td>${ std.id }</td> <td>${ std.studentNumber }</td> <td>${ std.studentName }</td> <td>${ std.email }</td>
    </tr>
    </table>
</body>
</html>

