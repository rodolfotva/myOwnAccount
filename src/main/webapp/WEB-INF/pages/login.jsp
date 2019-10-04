<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h1><spring:message code="project.title" /></h1>
	<h4><spring:message code="login.title" /></h4>
	
	<div style="padding-top: 50px">
		<div class="col-md-6 col-md-offset-3">
		    <form name="form" action="doLogin" method="post">
		        <div class="form-group" style="text-align:left" ng-class="{ 'has-error': form.username.$dirty && form.username.$error.required }">
		            <label for="username"><spring:message code="form.login.username" /></label>
		            <input type="text" name="username" id="username" class="form-control" ng-model="username" required />
		            <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block"><spring:message code="form.login.warn1" /></span>
		        </div>
		        <div class="form-group" style="text-align:left" ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required }">
		            <label for="password"><spring:message code="form.login.password" /></label>
		            <input type="password" name="password" id="password" class="form-control" ng-model="password" required />
		            <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block"><spring:message code="form.login.warn2" /></span>
		        </div>
		        <div class="form-actions">
		            <button type="submit" ng-disabled="form.$invalid || dataLoading" class="btn btn-primary"><spring:message code="common.login" /></button>
		            <img ng-if="dataLoading" src="data:image/gif;base64,R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh+QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIjK8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUkGCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
		        </div>
		    </form>
		</div>
	</div>
</div>