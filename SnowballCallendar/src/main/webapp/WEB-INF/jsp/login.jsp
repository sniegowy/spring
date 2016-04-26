<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="page-header">
					<h1><spring:message code="login.header" /></h1>
				</div>
				<div style="padding: 10px; padding-bottom: 20px; text-align: right;">
				<div class="btn-group">
						<a href="?language=en" class="btn btn-default" type="button">English</a>
						<a href="?language=pl" class="btn btn-default" type="button">Polski</a>
					</div>
				</div>
				
				<c:if test="${not empty errorMessage}">
					<div style="color: red;">
						${errorMessage}
						<br/><br/>
					</div>
				</c:if>
				
				<form:form commandName="loginCredentials" class="form-horizontal">
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="login"
								style="font-weight: normal;"><spring:message code="login.login" /></label>
							<div class="col-md-7">
								<form:input type="text" path="login" id="login"
									class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="login" class="help-inline" style="color: red;"/>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="password"
								style="font-weight: normal;"><spring:message
									code="login.password" /></label>
							<div class="col-md-7">
								<form:input path="password" id="password"
									class="form-control input-sm" type="password"/>
								<div class="has-error">
									<form:errors path="password" class="help-inline" style="color: red;"/>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row" style="padding-top: 20px;">
						<div class="form-actions floatRight">
							<spring:message code="login.submit" var="submitMsg" />
							<input type="submit" value="${submitMsg}" class="btn btn-success" style="margin-left: 10px;"/>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>