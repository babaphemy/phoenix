<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="welcomeController" >
    <div class="jumbotron">
        <h1><spring:message code='project.name'/></h1>

        <p class="lead"><spring:message code='welcomePage.description'/></p>
    </div>
    
            <aside class="col-lg-3 col-sm-4 col-lg-pull-9 col-sm-pull-8">
        	<h3>Modules </h3>
            <ul ng-repeat="modules in mods" class="nav nav-pills nav-stacked">
                <li class="active"><a href="#">{{modules.name}}</a></li>
                

            </ul> 
         </aside>
         
         <div>
                 <aside class="col-lg-3 col-sm-4 col-lg-pull-9 col-sm-pull-8">
        	<h3>Webpay </h3>
            <ul class="nav nav-pills nav-stacked" ng-repeat="webo in webi">
                <li><a href="#">{{webo.name}}</a></li>
               
            </ul> 
         </aside>
         </div>
    
</div>
<script src="<c:url value="/resources/js/pages/welcome.js" />"></script>

