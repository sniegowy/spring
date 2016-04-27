<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="page-header">
				<h1><spring:message code="registration.header" /></h1>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form:form method="POST" modelAttribute="user"
						class="form-horizontal">
						<form:input type="hidden" path="id" id="id" />

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="firstName"
									style="font-weight: normal;"><spring:message code="users.firstName" /></label>
								<div class="col-md-7">
									<form:input type="text" path="firstName" id="firstName"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="firstName" class="help-inline" style="color: red;"/>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="lastName"
									style="font-weight: normal;"><spring:message code="users.lastName" /></label>
								<div class="col-md-7">
									<form:input type="text" path="lastName" id="lastName"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="lastName" class="help-inline" style="color: red;"/>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable"
									style="font-weight: normal;" for="loginCredentials.login"><spring:message code="login.login" /></label>
								<div class="col-md-7">
									<form:input type="text" path="loginCredentials.login"
										id="login" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="loginCredentials.login" class="help-inline" style="color: red;"/>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable"
									style="font-weight: normal;" for="loginCredentials.password"><spring:message code="login.password" /></label>
								<div class="col-md-7">
									<form:input type="password" path="loginCredentials.password"
										id="password" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="loginCredentials.password"
											class="help-inline" style="color: red;"/>
									</div>
								</div>
							</div>
						</div>
						
						<!-- <div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable"
									style="font-weight: normal;" for="userProfiles"><spring:message code="registration.role" /></label>
								<div class="col-md-7">
									<form:select path="userProfiles" class="form-control input-sm">
										<form:options items="${userProfilesOptions}"/>
									</form:select>
									<div class="has-error">
										<form:errors path="userProfiles"
											class="help-inline" style="color: red;"/>
									</div>
								</div>
							</div>
						</div>-->

						<div class="row">
							<div class="form-actions floatRight">
								<c:choose>
									<c:when test="${edit}">
										<spring:message code="registration.update" var="updateMsg"/>
										<input type="submit" value="${updateMsg}" class="btn btn-success"
											style="margin-left: 10px;" />
										<a class="btn btn-default" style="margin-left: 10px;"
											href="usersTable.html"><spring:message code="registration.cancel" /></a>
									</c:when>
									<c:otherwise>
										<spring:message code="registration.register" var="registerMsg"/>
										<input type="submit" value="${registerMsg}" class="btn btn-success"
											style="margin-left: 10px;" />
										<a class="btn btn-default" style="margin-left: 10px;"
											href="usersTable.html"><spring:message code="registration.cancel" /></a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</form:form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>