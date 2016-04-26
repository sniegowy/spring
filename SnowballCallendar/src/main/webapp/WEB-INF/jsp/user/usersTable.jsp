<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="container-fluid">
				<div class="page-header">
					<h1><spring:message code="users.list" /></h1>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th><spring:message code="users.firstName" /></th>
							<th><spring:message code="users.lastName" /></th>
						</tr>
					</thead>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.firstName}</td>
							<td>${user.lastName}</td>
							<td style="width: 200px; text-align: right;">
								<div class="btn-group">
									<a href="edit-user-${user.id}.html" class="btn btn-success" type="button"><spring:message code="users.edit" /></a>
									<a href="delete-user-${user.id}.html" class="btn btn-default" type="button"><spring:message code="users.delete" /></a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<a href="add-user.html" class="btn btn-success"><spring:message code="users.newUser" /></a>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>