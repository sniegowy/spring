<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="container-fluid">
				<div class="page-header">
					<h2>Lista użytkowników</h2>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Imię</th>
							<th>Nazwisko</th>
						</tr>
					</thead>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td style="width: 100px; border-right: none;">
								<a href="edit-user-${user.id}.html" class="btn btn-success">Edit</a>
							</td>
							<td style="width: 100px;">
								<a href="delete-user-${user.id}.html" class="btn btn-default">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				<a href="add-user.html" class="btn btn-default">Add new user</a>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>