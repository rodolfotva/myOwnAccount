<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
  <head>  
    <title>:: ARCHETYPE ::</title>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1" />
    
    <link rel="icon" href="https://raw.githubusercontent.com/rodolfotva/cdn/master/images/favicon.ico" type="image/x-icon" >
    
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
  	<body ng-app="main" class="ng-cloak">
		<div ng-controller="mainController">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"><spring:message code="project.title" /></a>
					</div>
					<div id="navbar" class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li ng-class="{active : menu == 'page1'}"><a href="#" ng-click="menuChange('page1')"><spring:message code="page1.title" /></a></li>
							<li ng-class="{active : menu == 'page2'}"><a href="#" ng-click="menuChange('page2')"><spring:message code="page2.title" /></a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
			              <li><a href="/en/" title="English"><img src="https://raw.githubusercontent.com/rodolfotva/cdn/master/images/usa.png" height="16" width="16" /></a></li>
			              <li><a href="/fr/" title="Francais"><img src="https://raw.githubusercontent.com/rodolfotva/cdn/master/images/france.png" height="16" width="16" /></a></li>
			              <li><a href="/pt/" title="Portugues"><img src="https://raw.githubusercontent.com/rodolfotva/cdn/master/images/brazil.png" height="16" width="16" /></a></li>
            			</ul>
					</div>
				</div>
			</nav>
			
			<div class="container_main container" >
				<div ng-switch="menu">
					<div ng-switch-when="page1" page1-page></div>
					<div ng-switch-when="page2" page2-page></div>
				</div>
			</div>

			<div class="footer">
				<div class="footer-copyright text-center py-3">2018 Copyright:
				  <a href="https://www.yoursitehere.com/"> yoursitehere.com</a>
				</div>
			</div>
		</div>	
	</body>

</html>