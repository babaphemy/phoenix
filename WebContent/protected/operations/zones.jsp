<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="zonesController">
   
   
    <div>
       

      

       


       
        <div id="gridContainer" ng-class="{'': state == 'list', 'none': state != 'list'}">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th scope="col"><spring:message code="zones.name"/></th>
                    <th scope="col"><spring:message code="zones.code"/></th>
                  
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="zone in zone">
                    <td class="tdContactsCentered">{{zone.zonename}}</td>
                    <td class="tdContactsCentered">{{zone.zonecode}}</td>
                 
                    <td class="width15">
                        
                    </td>
                </tr>
                </tbody>
            </table>

           
        </div>
 

       

    </div>
</div>

<script src="<c:url value="/resources/js/pages/zones.js" />"></script>
