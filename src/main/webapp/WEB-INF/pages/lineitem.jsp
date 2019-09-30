<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h4><b><spring:message code="common.account" />: {{account.name}}</b></h4>
	<spring:message code="common.balance" />: {{total | currency}}

	<div style="padding-top: 50px">
		<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="common.description" /></th>
					<th><spring:message code="common.date" /></th>
					<th><spring:message code="common.value" /></th>
				</tr>
			</thead>
			<tbody ng-repeat="lineitem in lineitems | orderBy:'-date'">
				<tr>
					<td>{{lineitem.description}}</td>
					<td>{{lineitem.date | date}}</td>
					<td ng-style="valueStyle(lineitem.value)" style="text-align:right">{{lineitem.value | currency}}</td>
				</tr>
			</tbody>		
		</table>
	</div>
</div>