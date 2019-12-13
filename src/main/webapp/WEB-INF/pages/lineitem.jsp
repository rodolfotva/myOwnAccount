<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h4><b><spring:message code="common.account" />: {{account.name}}</b></h4>
	<spring:message code="common.balance" />: <b ng-style="valueStyle(total)">{{total | currency}}</b>

		            
	<div style="padding-top: 50px">
		<div class="row">
			<div class="lineiten-back" ng-click="gotoAcc()">
				<a href="#" ng-click="gotoAcc()" title="<spring:message code="common.back" />"><i style="font-size: 1.5em;" class="fas fa-backward"></i></a>		
			</div>
			<div ng-show='${sessionScope.isAdmin}' class="lineiten-add" ng-click="gotoAddLine()">
				<a href="#" ng-click="gotoAddLine()" title="<spring:message code="common.back" />"><i style="font-size: 1.5em;" class="fas fas fa-plus"></i></a>		
			</div>
		</div>
		<div class="lineiten-table">
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
</div>