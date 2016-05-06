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
	var userId = ${user.id};
	var selectedCells = '${selectedCells}';
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
			<a href="" data-target="#scheduleAddTileModal" data-toggle="modal" style="display: hidden;" id="openModalLink"></a>
			<a href="../common/success-returnUrl-'${userId}-schedule'.html" data-target="#scheduleAddTileModal" data-toggle="modal" 
									style="display:hidden;" id="openSuccessModal"></a>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<div class="modal fade" id="scheduleAddTileModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

        </div>
    </div>
</div>

<script src="../resources/js/schedule.js" type="text/javascript"></script>