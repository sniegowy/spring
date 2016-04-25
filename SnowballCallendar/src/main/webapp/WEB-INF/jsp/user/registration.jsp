<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="well lead">User Registration Form</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form:form method="POST" modelAttribute="user"
						class="form-horizontal">
						<form:input type="hidden" path="id" id="id" />

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="firstName"
									style="font-weight: normal;">First Name</label>
								<div class="col-md-7">
									<form:input type="text" path="firstName" id="firstName"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="firstName" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="lastName"
									style="font-weight: normal;">Last Name</label>
								<div class="col-md-7">
									<form:input type="text" path="lastName" id="lastName"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="lastName" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable"
									style="font-weight: normal;" for="loginCredentials.login">Login</label>
								<div class="col-md-7">
									<form:input type="text" path="loginCredentials.login"
										id="loginCredentials.login" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="loginCredentials.login" class="help-inline" />
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable"
									style="font-weight: normal;" for="loginCredentials.password">Password</label>
								<div class="col-md-7">
									<form:input type="password" path="loginCredentials.password"
										id="loginCredentials.password" class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="loginCredentials.password"
											class="help-inline" />
									</div>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="form-actions floatRight">
								<c:choose>
									<c:when test="${edit}">
										<input type="submit" value="Update" class="btn btn-success"
											style="margin-left: 10px;" />
										<a class="btn btn-default" style="margin-left: 10px;"
											href="usersTable.html">Cancel</a>
									</c:when>
									<c:otherwise>
										<input type="submit" value="Register" class="btn btn-success"
											style="margin-left: 10px;" />
										<a class="btn btn-default" style="margin-left: 10px;"
											href="usersTable.html">Cancel</a>
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