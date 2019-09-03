<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h1><spring:message code="project.title" /></h1>
	<h4><spring:message code="page1.title" /></h4>
	
	<div style="padding-top: 50px">
		<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="header.key" /></th>
					<th><spring:message code="header.value" /></th>
				</tr>
			</thead>
			<tbody ng-repeat="value in data">
				<tr>
					<td>{{value.key}}</td>
					<td>{{value.value}}</td>
				</tr>
			</tbody>		
		</table>
	</div>
</div>