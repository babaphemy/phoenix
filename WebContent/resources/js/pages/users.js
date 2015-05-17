phoApp.controller('usersController', function ($scope, $http){
		
    $scope.pageToGet = 0;

    $scope.state = 'busy';

    $scope.lastAction = '';
  
    
	$scope.url = "/phoenix/protected/users/";
	$scope.url1 = "/phoenix/protected/users/conf/"
	
	$scope.itemList = [];
	
	$http.get('/phoenix/protected/users/').
	   success(function(data) {
	       $scope.itemList = data;
	   });
	  $scope.modified = [];
	  
	  $scope.updateRecords = function(){
		    for(var item in $scope.itemList){
		      item = $scope.itemList[item];
		      item.expected = item.daysInMonth * item.ads;
		    }
		  }


		  $scope.addToModifyList = function(item){
		    if ($scope.modified.indexOf(item) == -1) {
		         $scope.modified.push(item);
		     }
		  }

		  $scope.isModified = function(item){
		    if ($scope.modified.indexOf(item) == -1) {
		         return false;
		     }
		     return true;
		  }

		  $scope.sendData = function(){
			    if($scope.modified.length > 0){
			      $http.post('/phoenix/protected/users/conf/', $scope.modified).
			         success(function(data, status, headers, config) {
			            alert("Successfully updated");
			          }).
			          error(function(data, status, headers, config) {
			            alert("Updation error");
			          });
			    }

			  }
		  $scope.$watch('itemList', $scope.updateRecords, true);
	
	
	
	
	
	
    $scope.errorOnSubmit = false;
    $scope.errorIllegalAccess = false;
    $scope.displayMessageToUser = false;
    $scope.displayValidationError = false;
    $scope.displaySearchMessage = false;
    $scope.displaySearchButton = false;
    $scope.displayCreateUserButton = false;
    
	$scope.user = {}
	
	$scope.searchFor = ""
	
	$scope.getUserList = function () {
        var url = $scope.url;
        $scope.lastAction = 'list';

        $scope.startDialogAjaxRequest();

      //  var config = {params: {page: $scope.pageToGet}};

        $http.get(url)
            .success(function (data) {
                $scope.finishAjaxCallOnSuccess(data, null, false);
            })
            .error(function () {
                $scope.state = 'error';
                $scope.displayCreateUserButton = false;
            });
    }
	
    $scope.populateTable = function (data) {
       /* if (isEmpty(data))  {
            $scope.state = 'noresult';
            $scope.displayCreateUserButton = true;

            if(!$scope.searchFor){
                $scope.displaySearchButton = false;
            }
        } else {*/
            $scope.state = 'list';

           // $scope.page = {source: data.customers, currentPage: $scope.pageToGet, pagesCount: data.pagesCount, totalContacts : data.totalContacts};
            $scope.page = data;
            
            

          /*  if($scope.page.pagesCount <= $scope.page.currentPage){
                $scope.pageToGet = $scope.page.pagesCount - 1;
                $scope.page.currentPage = $scope.page.pagesCount - 1;
            }*/

            $scope.displayCreateUserButton = true;
            $scope.displaySearchButton = true;
     //   }

        if (data.actionMessage || data.searchMessage) {
            $scope.displayMessageToUser = $scope.lastAction != 'search';

            $scope.page.actionMessage = data.actionMessage;
            $scope.page.searchMessage = data.searchMessage;
        } else {
            $scope.displayMessageToUser = false;
        }
    }

    $scope.changePage = function (page) {
        $scope.pageToGet = page;

        if($scope.searchFor){
            $scope.searchUser($scope.searchFor, true);
        } else{
            $scope.getUserList();
        }
    };
    
	$scope.exit = function (modalId) {
    $(modalId).modal('hide');

    $scope.user = {};
    $scope.errorOnSubmit = false;
    $scope.errorIllegalAccess = false;
    $scope.displayValidationError = false;
    }
	
    $scope.finishAjaxCallOnSuccess = function (data, modalId, isPagination) {
        $scope.populateTable(data);
        $("#loadingModal").modal('hide');

        if(!isPagination){
            if(modalId){
                $scope.exit(modalId);
            }
        }

        $scope.lastAction = '';
    }
    
    $scope.startDialogAjaxRequest = function () {
        $scope.displayValidationError = false;
        $("#loadingModal").modal('show');
        $scope.previousState = $scope.state;
        $scope.state = 'busy';
    }
    
    $scope.handleErrorInDialogs = function (status) {
        $("#loadingModal").modal('hide');
        $scope.state = $scope.previousState;

        // illegal access
        if(status == 403){
            $scope.errorIllegalAccess = true;
            return;
        }

        $scope.errorOnSubmit = true;
        $scope.lastAction = '';
    }
    $scope.addSearchParametersIfNeeded = function(config, isPagination) {
        if(!config.params){
            config.params = {};
        }

        config.params.page = $scope.pageToGet;

        if($scope.searchFor){
            config.params.searchFor = $scope.searchFor;
        }
    }
    $scope.resetUser = function(){
        $scope.user = {};
    };
    

    $scope.createUser = function (newUserForm) {
       /* if (!newUserForm.$valid) {
            $scope.displayValidationError = true;
            return;
        }*/

        $scope.lastAction = 'create';

        var url = $scope.url;

        //var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};

        //$scope.addSearchParametersIfNeeded(config, false);

        //$scope.startDialogAjaxRequest();
        
        var xsrf = $.param({'name' : $scope.name, 'accountNumber':$scope.account, 'serialNumber':$scope.serial });
        
        $http({
            method: 'POST',
            url: url,
            data: xsrf,
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        });
        

    };
    
    
    
    $scope.ads = {
    		value:0,
    		multipliedByIt:0
    };
    
       
    $scope.$watch('page', function (newValue, oldValue) {
        angular.forEach(newValue, function (user) {
          if (!user.ads)   user.ads = angular.extend({}, $scope.ads);
          if (!user.sdate) user.sdate = $scope.sdate;
          user.ads.multipliedByIt = user.ads.value * user.sdate;
        });
      }, true);
     
    	
    $scope.zoneConfig = function (configForm) {
        $scope.lastAction = 'create';
        $scope.uri = "/phoenix/protected/users/conf/";
        var uri = $scope.uri,
            $ = { param: angular.noop }; //-- Added this since I did not include jQuery in this CodePen
        angular.forEach($scope.page, function (user, key) {
          var xsrfi = $.param({
            'monthlyContributable' : user.ads.value,
            'expectedAmount': user.ads.multipliedByIt
          });
          $http({
              method: 'POST',
              url: uri,
              data: xsrfi,
              headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
          });
        });
      };
    
    

    $scope.selectedUser = function (user) {
        var selectedUser = angular.copy(user);
        $scope.user = selectedUser;
    }
    
    $scope.updateUser = function (updateUserForm) {
        if (!updateUserForm.$valid) {
            $scope.displayValidationError = true;
            return;
        }

        $scope.lastAction = 'update';

        var url = $scope.url + $scope.user.id;

        $scope.startDialogAjaxRequest();

        var config = {}

        $scope.addSearchParametersIfNeeded(config, false);

        $http.put(url, $scope.user, config)
            .success(function (data) {
                $scope.finishAjaxCallOnSuccess(data, "#updateUsersModal", false);
            })
            .error(function(data, status, headers, config) {
                $scope.handleErrorInDialogs(status);
            });
    };
    
    $scope.searchUser = function (searchUserForm, isPagination) {
        if (!($scope.searchFor) && (!searchUserForm.$valid)) {
            $scope.displayValidationError = true;
            return;
        }

        $scope.lastAction = 'search';

        var url = $scope.url +  $scope.searchFor;

        $scope.startDialogAjaxRequest();

        var config = {};

        if($scope.searchFor){
            $scope.addSearchParametersIfNeeded(config, isPagination);
        }

        $http.get(url, config)
            .success(function (data) {
                $scope.finishAjaxCallOnSuccess(data, "#searchUsersModal", isPagination);
                $scope.displaySearchMessage = true;
            })
            .error(function(data, status, headers, config) {
                $scope.handleErrorInDialogs(status);
            });
    };
    
    $scope.deleteUser = function () {
        $scope.lastAction = 'delete';

        var url = $scope.url + $scope.user.id;

        $scope.startDialogAjaxRequest();

        var params = {searchFor: $scope.searchFor, page: $scope.pageToGet};

        $http({
            method: 'DELETE',
            url: url,
            params: params
        }).success(function (data) {
                $scope.resetUser();
                $scope.finishAjaxCallOnSuccess(data, "#deleteUsersModal", false);
            }).error(function(data, status, headers, config) {
                $scope.handleErrorInDialogs(status);
            });
    };
    
    $scope.resetSearch = function(){
        $scope.searchFor = "";
        $scope.pageToGet = 0;
        $scope.getUserList();
        $scope.displaySearchMessage = false;
    }
    
    $scope.getUserList();
    
    
    
    $scope.zoneContrib = function(){
    	window.location.href="/phoenix/protected/contributions";
    }
    $scope.zoneWtd = function(){
    	
    }
    $scope.sdate = daysInMonth();
    $scope.date = new Date();
      
    
});


function daysInMonth() {
	var mdate = new Date();
	
    return new Date(mdate.getFullYear(), mdate.getMonth(), 0).getDate();
}