<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<link href="../resources/css/schedule.css" rel="stylesheet" type="text/css">
<script>
	var startHour = ${startHour};
	var endHour = ${endHour};
    var csrfToken = '${_csrf.token}';
</script>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="page-header" style="margin-top: 0px;">
				<h1><spring:message code="users.schedule" /> - ${user.firstName}&nbsp;${user.lastName}</h1>
			</div>
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
			<br/><br/>
			<a class="btn btn-success" onclick="sendResult()">
				<spring:message code="schedule.save" />
			</a>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<!-- Modal -->
<div class="modal fade" tabindex="-1" role="dialog" id="addTimeModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Dodawanie czasu pracy</h4>
      </div>
      <div class="modal-body">
        <p>Czas</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<script src="../resources/js/schedule.js" type="text/javascript"></script>