<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<link href="../resources/css/schedule.css" rel="stylesheet" type="text/css">
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="content">
		<div class="content">
			<div class="page-header">
				<h1><spring:message code="users.schedule" /></h1>
				<table class="scheduleTable">
				  <tr><td></td>
				  	  	<td><spring:message code="schedule.monday" /></td>
				  		<td><spring:message code="schedule.tuesday" /></td>
				  		<td><spring:message code="schedule.wednesday" /></td>
				  		<td><spring:message code="schedule.thursday" /></td>
				  		<td><spring:message code="schedule.friday" /></td><tr>
				  <tr><td>5</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>6</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>7</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>8</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>9</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>10</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>11</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>12</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>13</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>14</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>15</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>16</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>17</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>18</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>19</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>20</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>21</td><td></td><td></td><td></td><td></td><td></td><tr>
				  <tr><td>22</td><td></td><td></td><td></td><td></td><td></td><tr>
				</table>
			</div>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript" charset="utf-8">
    $(function () {
      var isMouseDown = false;
      $(".scheduleTable td")
        .mousedown(function () {
          isMouseDown = true;
          $(this).toggleClass("highlighted");
          return false;
        })
        .mouseover(function () {
          if (isMouseDown) {
            $(this).toggleClass("highlighted");
          } else {
        	  $(this).toggleClass("hover");
          }
        })
        .bind("selectstart", function () {
          return false;
        });

      $(document)
        .mouseup(function () {
          isMouseDown = false;
        });
    });
</script>