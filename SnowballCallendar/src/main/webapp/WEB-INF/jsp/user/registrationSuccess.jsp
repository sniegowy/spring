<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="alert alert-success lead">${success}</div>

			<span class="well floatRight"> Go to <a href="usersTable.html">Users
					List</a>
			</span>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>