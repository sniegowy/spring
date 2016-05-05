<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="menu">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Snowball</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/Callendar/calendar/calendar.html"><spring:message
								code="menu.calendar" /></a></li>
					<li><a href="/Callendar/customers/customersTable.html"><spring:message
								code="menu.customers" /></a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
							aria-haspopup="true" aria-expanded="false">
							<spring:message code="menu.administration"/>
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="/Callendar/user/usersTable.html"><spring:message
										code="menu.users" /></a></li>
							<li><a href="/Callendar/admin/eventTypes.html"><spring:message
										code="menu.eventTypes" /></a></li>
						</ul>
					</li>
				</ul>
				<div style="text-align:right; vertical-align: middle; padding-right: 0px;">
					<spring:message code="menu.loggedAs" />
					<sec:authentication property="name"/>&nbsp;
					<a href="/Callendar/logout.html" class="btn btn-default">
						<spring:message code="menu.logout" />
					</a>
					<div class="btn-group">
						<a href="?language=en" class="btn btn-default" type="button">English</a>
						<a href="?language=pl" class="btn btn-default" type="button">Polski</a>
					</div>
				</div>
			</div>
		</div>
	</nav>
</div>
<script src="../resources/js/menu.js" type="text/javascript"></script>