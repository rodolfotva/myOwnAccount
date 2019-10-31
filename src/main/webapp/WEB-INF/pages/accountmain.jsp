<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div ng-switch="steps">
	<div ng-switch-when="account" account-page></div>
	<div ng-switch-when="lineitem" lineitem-page></div>
</div>