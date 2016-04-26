<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="menu">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Snowball</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/Callendar/user/usersTable.html"><spring:message
								code="menu.users" /></a></li>
					<li><a href="/Callendar/login.html">Login</a></li>
				</ul>
				<div style="text-align:right; vertical-align: middle; padding-right: 0px;">
				<div class="btn-group">
					<a href="?language=en" class="btn btn-default" type="button">English</a>
					<a href="?language=pl" class="btn btn-default" type="button">Polski</a>
				</div>
			</div>
			</div>
		</div>
	</nav>
</div>