<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${R}common.css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${R}common.js"></script>
</head>
<body>
	<div class="container">
		<h1>주소록</h1>
		<table class="list">
			<thead>
				<tr>
					<th>id</th>
					<th>이름</th>
					<th>관계</th>
					<th>성별</th>
					<th>전화</th>
					<th>이메일</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="person" items="${ people }">
					<tr data-url="edit?id=${ person.id }">
						<td>${ person.id }</td>
						<td>${ person.name }</td>
						<td>${ person.relationship.title }</td>
						<td>${ person.sex }</td>
						<td>${ person.phone }</td>
						<td>${ person.email }</td>
						<td>${ person.address }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

