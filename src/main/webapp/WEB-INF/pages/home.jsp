<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="starter-template">
	<h1><spring:message code="project.title" /></h1>
	
	<div style="padding-top: 50px">
		<div class="col-md-6 col-md-offset-3">
			<img src="<c:url value="/static/images/house.png" />" />
		</div>
	</div>
</div>