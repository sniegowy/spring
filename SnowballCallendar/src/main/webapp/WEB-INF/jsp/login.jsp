<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Language: <a href="?language=en">English</a> | <a href="?language=pl">Polish</a>
	<form:form commandName="loginCredentials">
		<table>
			<tr>
				<td><spring:message code="login.login"/></td>
				<td><form:input path="login"/></td>
			</tr>
			<tr>
				<td><spring:message code="login.password"/></td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Enter"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>