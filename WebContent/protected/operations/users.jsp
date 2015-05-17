<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="row-fluid" ng-controller="usersController">

<div id="links">
<button type="button" class="btn btn-primary" ng-click="zoneConfig(accountForm);">Configure</button>
| <button type="button" class="btn btn-primary" ng-click="zoneContrib();">Contribute</button>|
<button type="button" class="btn btn-primary" ng-click="zoneWtd();">Withdrawal</button>
</div>

    <h2>
        <p class="text-center">
            <spring:message code='zones.header'/>
            <a href="#searchZonesModal"
               id="zonesHeaderButton"
               role="button"
               ng-class="{'': displaySearchButton == true, 'none': displaySearchButton == false}"
               title="<spring:message code="search"/>&nbsp;<spring:message code="zone"/>"
               class="btn btn-inverse" data-toggle="modal">
                <i class="icon-search"></i>
            </a>
        </p>
    </h2>
    <h4>
        <div ng-class="{'': state == 'list', 'none': state != 'list'}">
            <p class="text-center">
                <spring:message code="message.total.records.found"/>:&nbsp;{{page.totalZoneCustomers}} |  <spring:message code="month"/> : {{date | date:'MMMM'}}
            </p>
        </div>
    </h4>

    <div>
        <div id="loadingModal" class="modal hide fade in centering"
             role="dialog"
             aria-labelledby="deleteContactsModalLabel" aria-hidden="true">
            <div id="divLoadingIcon" class="text-center">
                <div class="icon-align-center loading"></div>
            </div>
        </div>

        <div ng-class="{'alert badge-inverse': displaySearchMessage == true, 'none': displaySearchMessage == false}">
            <h4>
                <p class="messageToUser"><i class="icon-info-sign"></i>&nbsp;{{page.searchMessage}}</p>
            </h4>
            <a href="#"
               role="button"
               ng-click="resetSearch();"
               ng-class="{'': displaySearchMessage == true, 'none': displaySearchMessage == false}"
               title="<spring:message code='search.reset'/>"
               class="btn btn-inverse" data-toggle="modal">
                <i class="icon-remove"></i> <spring:message code="search.reset"/>
            </a>
        </div>
        
        
        <form name="configForm" novalidate >
  		 <div id="gridContainer" ng-class="{'': state == 'list', 'none': state != 'list'}">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th scope="col"><spring:message code="user.name"/></th>
                    <th scope="col"><spring:message code="user.account"/></th>
                    <th scope="col"><spring:message code="user.serial"/></th>
                    <th scope="col"><spring:message code="user.start"/></th>
                    <th scope="col"><spring:message code="user.ads"/></th>
                    <th scope="col"><spring:message code="user.expected"/></th>
                    
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="item in itemList"  ng-class="{ 'modified': isModified(item)}">
                    <td class="tdContactsCentered">{{item.name}}<input type="hidden" name="cid" value="{{user.id}}" /></td>
                    <td class="tdContactsCentered" >{{item.accountNumber}}</td>
                    <td class="tdContactsCentered">{{item.serialNumber}}</td>
                    <td class="text-left"><input type="text" ng-change="addToModifyList(item)" ng-model="item.daysInMonth" placeholder="{{ item.daysInMonth | number }}" class="input-small"></input></td>
        <td class="text-left"><input type="text" ng-change="addToModifyList(item)" ng-model="item.ads" placeholder="{{ item.ads }}" class="input-small"></input></td>
        <td class="text-left"><input type="text" ng-change="addToModifyList(item)" ng-model="item.expected" placeholder="{{ item.expected }}" class="input-small"></input></td>
                    
                    
                    
                    
                    
                   
                    <td class="width15">
                        <div class="text-center">
                            <input type="hidden" value="{{user.id}}"/>
                            <a href="#updateUsersModal"
                               ng-click="selectedUser(user);"
                               role="button"
                               title="<spring:message code="update"/>&nbsp;<spring:message code="user"/>"
                               class="btn btn-inverse" data-toggle="modal">
                                <i class="icon-pencil"></i>
                            </a>
                            <a href="#deleteUsersModal"
                               ng-click="selectedUser(user);"
                               role="button"
                               title="<spring:message code="delete"/>&nbsp;<spring:message code="user"/>"
                               class="btn btn-inverse" data-toggle="modal">
                                <i class="icon-minus"></i>
                            </a>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>

            <div class="text-center">
                <button href="#" class="btn btn-inverse"
                        ng-class="{'btn-inverse': page.currentPage != 0, 'disabled': page.currentPage == 0}"
                        ng-disabled="page.currentPage == 0" ng-click="changePage(0)"
                        title='<spring:message code="pagination.first"/>'
                        >
                    <spring:message code="pagination.first"/>
                </button>
                <button href="#"
                        class="btn btn-inverse"
                        ng-class="{'btn-inverse': page.currentPage != 0, 'disabled': page.currentPage == 0}"
                        ng-disabled="page.currentPage == 0" class="btn btn-inverse"
                        ng-click="changePage(page.currentPage - 1)"
                        title='<spring:message code="pagination.back"/>'
                        >&lt;</button>
                <span>{{page.currentPage + 1}} <spring:message code="pagination.of"/> {{page.pagesCount}}</span>
                <button href="#"
                        class="btn btn-inverse"
                        ng-class="{'btn-inverse': page.pagesCount - 1 != page.currentPage, 'disabled': page.pagesCount - 1 == page.currentPage}"
                        ng-click="changePage(page.currentPage + 1)"
                        ng-disabled="page.pagesCount - 1 == page.currentPage"
                        title='<spring:message code="pagination.next"/>'
                        >&gt;</button>
                <button href="#"
                        class="btn btn-inverse"
                        ng-class="{'btn-inverse': page.pagesCount - 1 != page.currentPage, 'disabled': page.pagesCount - 1 == page.currentPage}"
                        ng-disabled="page.pagesCount - 1 == page.currentPage"
                        ng-click="changePage(page.pagesCount - 1)"
                        title='<spring:message code="pagination.last"/>'
                        >
                    <spring:message code="pagination.last"/>
                </button>
            </div>
        </div>
        
           
           
               
    <div style="margin: 15px">
        <div class="form-group">
            <div class="col-sm-5 col-sm-offset-3">
                                      <input type="submit"
                       class="btn btn-inverse"
                       ng-click="sendData();"
                       value='<spring:message code="config"/>'/>
                                      
            </div>
        </div>
    </div>
</form>
        
        

        <div ng-class="{'alert badge-inverse': displayMessageToUser == true, 'none': displayMessageToUser == false}">
            <h4 class="displayInLine">
                <p class="messageToUser displayInLine"><i class="icon-info-sign"></i>&nbsp;{{page.actionMessage}}</p>
            </h4>
        </div>

        <div ng-class="{'alert alert-block alert-error': state == 'error', 'none': state != 'error'}">
            <h4><i class="icon-info-sign"></i> <spring:message code="error.generic.header"/></h4><br/>

            <p><spring:message code="error.generic.text"/></p>
        </div>

        <div ng-class="{'alert alert-info': state == 'noresult', 'none': state != 'noresult'}">
            <h4><i class="icon-info-sign"></i> <spring:message code="contacts.emptyData"/></h4><br/>

            <p><spring:message code="contacts.emptyData.text"/></p>
        </div>

                <div ng-class="{'text-center': displayCreateUserButton == true, 'none': displayCreateUserButton == false}">
            <br/>
            <a href="#addUsersModal"
               role="button"
               ng-click="resetUser();"
               title="<spring:message code='create'/>&nbsp;<spring:message code='zonecustomers'/>"
               class="btn btn-inverse"
               data-toggle="modal">
                <i class="icon-plus"></i>
                &nbsp;&nbsp;<spring:message code="create"/>&nbsp;<spring:message code="zonecustomers"/>
            </a>
        </div>

        <jsp:include page="dialogs/usersdlg.jsp"/>

    </div>
</div>


<script src="<c:url value="/resources/js/pages/users.js" />"></script>
