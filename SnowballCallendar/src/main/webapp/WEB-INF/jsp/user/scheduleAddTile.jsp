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
				<h1><spring:message code="schedule.addTime" /></h1>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form:form method="POST" modelAttribute="scheduleTime" class="form-horizontal">		
						<form:input type="hidden" path="id" id="id" />
						<form:input type="hidden" path="userId" id="userId" />	
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="firstName"
									style="font-weight: normal;"><spring:message code="schedule.weekDay" /></label>
								<div class="col-md-7">
									<form:select path="dayOfWeek" class="form-control input-sm">
										<c:forEach var="dayOfWeek" items="${daysOfWeek}">
											<c:set value="schedule.${dayOfWeek}" var="dayOfWeekMsg"  />
											<form:option value="${dayOfWeek}"><spring:message code="${dayOfWeekMsg}"/></form:option>
										</c:forEach>
									</form:select>
									<div class="has-error">
										<form:errors path="dayOfWeek" class="help-inline" style="color: red;"/>
									</div>
								</div>
							</div>
						</div>			
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="firstName"
									style="font-weight: normal;"><spring:message code="schedule.startTime" /></label>
								<div class="col-md-7">
									<div class="col-md-2" style="padding: 0px;">
										<form:input type="text" path="startHour" id="startHour"
											class="form-control input-sm" />
									</div>
									<div class="col-md-1">
									:
									</div>
									<div class="col-md-2" style="padding: 0px;">
										<form:input type="text" path="startMinute" id="startMinute"
											class="form-control input-sm" />
									</div>
									<div class="col-md-2">
										<div class="has-error">
											<form:errors path="startHour" class="help-inline" style="color: red;"/>
											<form:errors path="startMinute" class="help-inline" style="color: red;"/>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-3 control-lable" for="firstName"
									style="font-weight: normal;"><spring:message code="schedule.endTime" /></label>
								<div class="col-md-7">
									<div class="col-md-2" style="padding: 0px;">
										<form:input type="text" path="endHour" id="endHour"
											class="form-control input-sm" />
									</div>
									<div class="col-md-1">
									:
									</div>
									<div class="col-md-2" style="padding: 0px;">
										<form:input type="text" path="endMinute" id="endMinute"
											class="form-control input-sm" />
									</div>
									<div class="col-md-2">
										<div class="has-error">
											<form:errors path="endHour" class="help-inline" style="color: red;"/>
											<form:errors path="endMinute" class="help-inline" style="color: red;"/>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-actions floatRight">
								<spring:message code="schedule.save" var="saveMsg"/>
								<input type="submit" value="${saveMsg}" class="btn btn-success"
									style="margin-left: 10px;" />
								<a class="btn btn-default" style="margin-left: 10px;"
									href="${userId}-schedule.html"><spring:message code="registration.cancel" /></a>
							</div>
						</div>
					</form:form>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>