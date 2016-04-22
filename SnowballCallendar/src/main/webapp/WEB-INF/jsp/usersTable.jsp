<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h2>Lista uzytkownikow</h2>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Imie</th>
					<th>Nazwisko</th>
				</tr>
			</thead>
			<c:forEach items="${usres}" var="user">
				<tr>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>