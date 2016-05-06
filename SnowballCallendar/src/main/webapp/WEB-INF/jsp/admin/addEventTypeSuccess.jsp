<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="page-header"><h2>${success}</h2></div>

			<span>
				<a href="eventTypes.html">Wróć</a>
			</span>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>