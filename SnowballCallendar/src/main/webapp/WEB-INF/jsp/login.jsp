<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div style="padding: 10px; text-align: right;">
					Language: <a href="?language=en">English</a> | <a href="?language=pl">Polish</a>
				</div>
				<form:form commandName="loginCredentials">
					<table class="table">
						<tr>
							<td><spring:message code="login.login"/></td>
							<td><form:input path="login"/></td>
							<td><form:errors path="login"/></td>
						</tr>
						<tr>
							<td><spring:message code="login.password"/></td>
							<td><form:input path="password"/></td>
							<td><form:errors path="password"/></td>
						</tr>
						<tr>
							<td colspan="3">
								<input type="submit" value="Enter"/>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>