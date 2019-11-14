<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h1><spring:message code="project.title" /></h1>
	<h4><spring:message code="form.addacc.title" /></h4>
	
	<div style="padding-top: 50px">
	
		<div class="col-md-6 col-md-offset-3 msg-login-pack" id="addaccMessage">
			<div class="msg-login msg-login-error" ng-hide="hideAddaccError"> 
				<strong><spring:message code="form.addacc.error" /></strong>
			</div>
		</div>
		<div class="col-md-6 col-md-offset-3 msg-login-pack"  id="addaccSuccessMessage">
			<div class="msg-login msg-addacc-success" ng-click="gotoAcc()" ng-hide="hideAddaccSuccessMessage"> 
				<strong><spring:message code="form.addacc.success" /></strong>
				<p class="addacc-back">
					<a href="#" ng-click="gotoAcc()" title="<spring:message code="form.addacc.backtoacc" />"><i style="font-size: 1.5em;" class="fas fa-backward"></i></a>		
				</p>
			</div>
		</div>		
		<div class="col-md-6 col-md-offset-3">
		    <form name="form" ng-submit="addAccount()" method="post">
		        <div class="form-group" style="text-align:left" ng-class="{ 'has-error': form.accName.$dirty && form.accName.$error.required }">
		            <label for="accName"><spring:message code="form.addacc.accName" /></label>
		            <input type="text" name="accName" id="accName" class="form-control" ng-model="accName" required />
		            <span ng-show="form.accName.$dirty && form.accName.$error.required" class="help-block"><spring:message code="form.addacc.accName.warn" /></span>
		        </div>
		        <div class="form-group" style="text-align:left" ng-class="{ 'has-error': form.accDesc.$dirty && form.accDesc.$error.required }">
		            <label for="accDesc"><spring:message code="form.addacc.accDesc" /></label>
		            <input type="text" name="accDesc" id="accDesc" class="form-control" ng-model="accDesc" required />
		            <span ng-show="form.accDesc.$dirty && form.accDesc.$error.required" class="help-block"><spring:message code="form.addacc.accDesc.warn" /></span>
		        </div>
		        <div class="form-actions">
		            <button type="submit" ng-disabled="form.$invalid || dataLoading" class="btn btn-primary"><spring:message code="common.save" /></button>
		            <img ng-if="dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
		        </div>
		    </form>
		</div>
	</div>
</div>