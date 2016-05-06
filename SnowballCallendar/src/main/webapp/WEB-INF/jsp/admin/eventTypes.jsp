<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored="false" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="container-fluid">
				<div class="page-header">
					<h1><spring:message code="menu.eventTypes" /></h1>
				</div> 
				<table class="table table-hover">
					<thead>
						<tr>
							<th><spring:message code="eventType.name" /></th>
							<th><spring:message code="eventType.color" /></th>
							<th></th>
						</tr>
					</thead>
					<c:forEach items="${eventTypes}" var="eventType">
						<tr>
							<td>${eventType.name}</td>
							<td>${eventType.color}</td>
							<td style="width: 300px; text-align: right;">
								<div class="btn-group">
									<a href="eventType-${eventType.id}-delete.html" class="btn btn-default" type="button">
										<spring:message code="users.delete" />
									</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<a href="addEventType.html" class="btn btn-success"><spring:message code="eventType.newEventType" /></a>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>