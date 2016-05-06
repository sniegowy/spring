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
					<h1><spring:message code="users.list" /></h1>
				</div> 
				<table class="table table-hover">
					<thead>
						<tr>
							<th><spring:message code="customers.firstName" /></th>
							<th><spring:message code="customers.lastName" /></th>
							<th><spring:message code="customers.phone" /></th>
							<th><spring:message code="customers.email" /></th>
						</tr>
					</thead>
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.phone}</td>
							<td>${customer.email}</td>
							<td style="width: 300px; text-align: right;">
								<div class="btn-group">
									<a href="${customer.id}-editCustomer.html" class="btn btn-default" type="button">
										<spring:message code="users.edit" />
									</a>
									<a href="${customer.id}-deleteCustomer.html" class="btn btn-default" type="button">
										<spring:message code="users.delete" />
									</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				<a href="addCustomer.html" class="btn btn-success"><spring:message code="users.newUser" /></a>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>