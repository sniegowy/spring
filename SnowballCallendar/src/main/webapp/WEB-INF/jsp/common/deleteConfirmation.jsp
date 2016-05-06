<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><p><span class="glyphicon glyphicon-trash"></span></p></h4>

            </div>
            <div class="modal-body">
				<div class="page-header"><h2><spring:message code="deleteConfirmation.msg" /></h2></div>

				<span>
					<a class="btn btn-default" style="margin-left: 10px;" href="${userId}-scheduleDelete.html">
						<spring:message code="users.delete" />
					</a>
					<a class="btn btn-success" style="margin-left: 10px;" href="${userId}-schedule.html">
						<spring:message code="registration.cancel" />
					</a>
				</span>
			</div>
		</div>
	</body>
</html>