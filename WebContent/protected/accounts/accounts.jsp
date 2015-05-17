<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid" ng-controller="accountsController">

<div id="links">
<ul class="nav nav-pills">
<li class="active"><a ng-href="#">Trustfund</a></li>
<li><a ng-href="Specials(SpecialsForm);">Specials Old</a></li>
<li><a ng-href="#">Transactions</a></li>
<li><a ng-href="#">Daily Sales</a></li>
<li><a ng-href="#">Balance Sheet</a></li>
<li><a ng-ref="#">Specials</a></li>
<li><a ng-ref="#">Outgoing</a></li>
<li><a ng-ref="#">Expenses</a></li>
<li><a ng-ref="#">Add Transaction</a></li>
</ul>

</div>
    <h2>
        <p class="text-center">
            <spring:message code='account.header'/>
            <a href="#searchAccountsModal"
               id="accountsHeaderButton"
               role="button"
               ng-class="{'': displaySearchButton == true, 'none': displaySearchButton == false}"
               title="<spring:message code="search"/>&nbsp;<spring:message code="account"/>"
               class="btn btn-inverse" data-toggle="modal">
                <i class="icon-search"></i>
            </a>
        </p>
    </h2>
    <h4>
        <div ng-class="{'': state == 'list', 'none': state != 'list'}">
            <p class="text-center">
                <spring:message code="message.total.records.found"/>:&nbsp;{{page.totalAccounts}}
            </p>
        </div>
    </h4>

    <div>
        <div id="loadingModal" class="modal hide fade in centering"
             role="dialog"
             aria-labelledby="deleteAccountsModalLabel" aria-hidden="true">
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
            <h4><i class="icon-info-sign"></i> <spring:message code="accounts.emptyData"/></h4><br/>

            <p><spring:message code="accounts.emptyData.text"/></p>
        </div>

        <div id="gridContainer" ng-class="{'': state == 'list', 'none': state != 'list'}">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th scope="col"><spring:message code="account.name"/></th>
                    <th scope="col"><spring:message code="account.balance"/></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="acctx in page.source">
                    <td class="tdContactsCentered">{{acctx.name}}</td>
                    <td class="tdContactsCentered">{{acctx.accountBalance | currency : 'NGN'}}</td>
                 
                    <td class="width15">
                        <div class="text-center">
                            <input type="hidden" value="{{acctx.id}}"/>
                            <a href="#updateAccountsModal"
                               ng-click="selectedAccount(acctx);"
                               role="button"
                               title="<spring:message code="update"/>&nbsp;<spring:message code="account"/>"
                               class="btn btn-inverse" data-toggle="modal">
                                <i class="icon-pencil"></i>
                            </a>
                            <a href="#deleteAccountsModal"
                               ng-click="selectedAccount(acctx);"
                               role="button"
                               title="<spring:message code="delete"/>&nbsp;<spring:message code="account"/>"
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
        <div ng-class="{'text-center': displayCreateContactButton == true, 'none': displayCreateContactButton == false}">
            <br/>
            <a href="#addAccountsModal"
               role="button"
               ng-click="resetAccount();"
               title="<spring:message code='create'/>&nbsp;<spring:message code='account'/>"
               class="btn btn-inverse"
               data-toggle="modal">
                <i class="icon-plus"></i>
                &nbsp;&nbsp;<spring:message code="create"/>&nbsp;<spring:message code="account"/>
            </a>
        </div>

        <jsp:include page="dialogs/acctsDialogs.jsp"/>

    </div>
</div>


<script src="<c:url value="/resources/js/pages/accounts.js" />"></script>