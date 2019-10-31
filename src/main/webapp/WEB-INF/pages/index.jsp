<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
  <head>  
    <title>:: My Own Account ::</title>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1" />
        <link rel="icon" href="<c:url value="/static/images/favicon.ico" />" type="image/x-icon" >
    
    <link href="<c:url value="/static/css/myOwnAccount.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">    
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular-sanitize.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular-animate.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.3/angular-resource.js"></script>

    <script src="<c:url value="/static/js/myOwnAccount.js" />"></script>
    <script src="<c:url value="/static/js/controller/main-controller.js" />"></script>
    <script src="<c:url value="/static/js/service/main-service.js" />"></script>
    <script src="<c:url value="/static/js/directives/main-directives.js" />"></script>
    <script src="<c:url value="/static/js/filters/main-filters.js" />"></script>


  </head>
  	<body ng-app="main" class="ng-cloak back-color-default">
		<div ng-controller="mainController" class="back-color-default">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><spring:message code="project.title" /></a>
					</div>
					<div id="navbar" class="collapse navbar-collapse">
						<ul class="nav navbar-nav">	</ul>
						<ul class="nav navbar-nav navbar-right">
						  <li ng-hide='hideAccount("${sessionScope.userName}")'><a href="#"><spring:message code="common.hi" /> <c:out value="${sessionScope.userName}" /></a></li>
            			  <li ng-hide='hideAccount("${sessionScope.userName}")'><a href="#" ng-click="logout()" title="logout"><i style="font-size: 1.5em;" class="fas fa-sign-out-alt"></i></a></li>	
            			</ul>
					</div>
				</div>
			</nav>
			
			<div class="container_main container" >
				<div ng-switch="menu">
					<div ng-switch-when="login" login-page></div>
					<div ng-switch-when="accountmain" accountmain-page></div>
				</div>
			</div>

			<div class="footer">
				<div class="footer-copyright text-center py-3">2020 Copyright:
				  <a href="https://www.myownaccount.com/"> MyOwnAccount.com</a>
				</div>
			</div>
		</div>	
	</body>

</html>