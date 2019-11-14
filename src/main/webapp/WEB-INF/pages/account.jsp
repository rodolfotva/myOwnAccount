<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h2><spring:message code="account.title2" /></h2>
	
	<div style="padding-top: 50px">
		<div class="row pre-account">
			<div class="col-md-4"></div>
			<div class="col-md-4 addacc-add" ng-click="gotoAddAcc()">
				<a href="#" ng-click="gotoAddAcc()" title="<spring:message code="form.addacc.title" />"><i style="font-size: 1.5em;" class="fas fa-plus"></i></a>		
			</div>
			<div class="col-md-4"></div>
		</div>
		<div ng-repeat="account in accounts" class="row pre-account">
			<div class="col-md-4"></div>
				<div class="col-md-4 account" ng-click="gotoLineitens(account)">
					<p class="account-title" ng-click="gotoLineitens(account)">{{account.name}}</p>
					<p>{{account.description}}</p>
				</div>
			<div class="col-md-4"></div>
		</div>		
	</div>
</div>