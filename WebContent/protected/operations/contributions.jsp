<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="contribController">
   
   
    <div>
       

      

       


       
        <div id="gridContainer" ng-class="{'': state == 'list', 'none': state != 'list'}">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th scope="col"><spring:message code="user.name"/></th>
                    <th scope="col"><spring:message code="user.account"/></th>
                    <th scope="col"><spring:message code="user.serial"/></th>
                    <th scope="col"><spring:message code="user.noc"/></th>
                    <th scope="col"><spring:message code="user.cummulative"/></th>
                    <th scope="col"><spring:message code="user.expected"/></th>
                  
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="con in contrib">
                    <td class="tdContactsCentered">{{con.name}}</td>
                    <td class="tdContactsCentered">{{con.accountNumber}}</td>
                    <td class="tdContactsCentered">{{con.serial}}</td>
                    <td class="tdContactsCentered"><div class="input-append">
                        <input type="text"
                               required
                               ng-model="con.noc"
                               name="ads"
                               />
                    </div></td>
                    <td class="tdContactsCentered">{{con.cummulative}}</td>
                    <td class="tdContactsCentered">{{con.expected}}</td>
                 
                    <td class="width15">
                        
                    </td>
                </tr>
                </tbody>
            </table>

           
        </div>
 

       

    </div>
</div>

<script src="<c:url value="/resources/js/pages/contributions.js" />"></script>
