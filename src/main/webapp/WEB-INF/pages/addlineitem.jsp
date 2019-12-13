<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h1><spring:message code="project.title" /></h1>
	<h4><spring:message code="form.addline.title" /></h4>
	
	<div style="padding-top: 50px">
	
		<div class="col-md-6 col-md-offset-3 msg-login-pack" id="addlineMessage">
			<div class="msg-login msg-login-error" ng-hide="hideAddlineError"> 
				<strong><spring:message code="form.addline.error" /></strong>
			</div>
		</div>
		<div class="col-md-6 col-md-offset-3 msg-login-pack"  id="addlineSuccessMessage">
			<div class="msg-login msg-addacc-success" ng-click="gotoLineitensFromAddLine()" ng-hide="hideAddlineSuccessMessage"> 
				<strong><spring:message code="form.addline.success" /></strong>
				<p class="addacc-back">
					<a href="#" ng-click="gotoLineitensFromAddLine()" title="<spring:message code="form.addline.backtolist" />"><i style="font-size: 1.5em;" class="fas fa-backward"></i></a>		
				</p>
			</div>
		</div>		
		<div class="col-md-6 col-md-offset-3">
		    <form name="form" ng-submit="addLineitem()" method="post">
		        <div class="form-group" style="text-align:left" ng-class="{ 'has-error': form.lineDesc.$dirty && form.lineDesc.$error.required }">
		            <label for="lineDesc"><spring:message code="form.addline.lineDesc" /></label>
		            <input type="text" name="lineDesc" id="lineDesc" class="form-control" ng-model="lineDesc" required />
		            <span ng-show="form.lineDesc.$dirty && form.lineDesc.$error.required" class="help-block"><spring:message code="form.addline.lineDesc.warn" /></span>
		        </div>
		        <div class="form-group" style="text-align:left" ng-class="{ 'has-error': form.lineValue.$dirty && form.lineValue.$error.required }">
		            <label for="lineValue"><spring:message code="form.addline.lineValue" /></label>
		            <input type="text" class="form-control" ng-model="lineValue" required name="lineValue" id="lineValue" placeholder="$10,000.00">
		            <span ng-show="form.lineValue.$dirty && form.lineValue.$error.required" class="help-block"><spring:message code="form.addline.lineValue.warn" /></span>
		        </div>
		        <div class="form-actions">
		            <button type="submit" ng-disabled="form.$invalid || dataLoading" class="btn btn-primary"><spring:message code="common.save" /></button>
		            <img ng-if="dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
		        </div>
		    </form>
		</div>
	</div>
</div>