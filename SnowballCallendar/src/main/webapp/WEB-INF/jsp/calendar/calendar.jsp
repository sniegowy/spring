<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<link href="../resources/css/calendar.css" rel="stylesheet" type="text/css">
<script>
	var startHour = ${startHour};
	var endHour = ${endHour};
	var userId = ${user.id};
	var selectedCells = '${selectedCells}';
	var eventCells = '${eventCells}';
</script>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="page-header" style="margin-top: 0px;">
				<h1><spring:message code="users.schedule" /></h1>
			</div>
			<form:form method="POST" modelAttribute="user" class="form-horizontal">
				<div class="row" class="padding: 20px;">
					<div class="form-group col-md-3">
						<form:select path="id" id="users" class="form-control input-sm" style="margin-left: 20px; margin-top: 2px;">
							<form:options items="${users}" itemValue="id" itemLabel="displayName"/>
						</form:select>
					</div>
					<div class="form-group col-md-2">
						<input type="submit" value="Wybierz" class="btn btn-success" style="margin-left: 30px;" />
					</div>
				</div>
			</form:form>
			<c:choose>
				<c:when test="${userSelected}">
					<div id="scheduleTableDiv">
						<table id='scheduleTable'>
			  				<tr>
			  					<td></td>
			  	  				<td><spring:message code='schedule.monday' /></td>
			  					<td><spring:message code='schedule.tuesday' /></td>
			  					<td><spring:message code='schedule.wednesday' /></td>
			  					<td><spring:message code='schedule.thursday' /></td>
			  					<td><spring:message code='schedule.friday' /></td>
			  				</tr>
			  			</table>
					</div>
				</c:when>
			</c:choose>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script src="../resources/js/calendar.js" type="text/javascript"></script>