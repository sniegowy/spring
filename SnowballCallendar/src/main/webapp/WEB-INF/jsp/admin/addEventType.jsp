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
					<form:form method="POST" modelAttribute="eventType"
						class="form-horizontal">
						<form:input type="hidden" path="id" id="id" />

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="name"
									style="font-weight: normal;"><spring:message code="eventType.name" /></label>
								<div class="col-md-7">
									<form:input type="text" path="name" id="name"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="name" class="help-inline" style="color: red;"/>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="color"
									style="font-weight: normal;"><spring:message code="eventType.color" /></label>
								<div class="col-md-7">
									<form:input type="text" path="color" id="color"
										class="form-control input-sm" />
									<div class="has-error">
										<form:errors path="color" class="help-inline" style="color: red;"/>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-actions floatRight">
								<spring:message code="registration.register" var="registerMsg"/>
								<input type="submit" value="${registerMsg}" class="btn btn-success"
									style="margin-left: 10px;" />
								<a class="btn btn-default" style="margin-left: 10px;"
									href="eventTypes.html"><spring:message code="registration.cancel" /></a>
							</div>
						</div>
					</form:form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>