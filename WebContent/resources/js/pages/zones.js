phoApp.controller('zonesController', function ($scope, $http) {
	$scope.url = "/phoenix/protected/zonec/";

  /*  $scope.errorOnSubmit = false;
    $scope.errorIllegalAccess = false;
    $scope.displayMessageToUser = false;
    $scope.displayValidationError = false;
    $scope.displaySearchMessage = false;
    $scope.displaySearchButton = false;
    $scope.displayCreateZoneButton = false;*/

   // $scope.zone = {}
    var url = $scope.url
    $http.get(url)
    .success(function (data) {
      //  $scope.finishAjaxCallOnSuccess(data, null, false);
    	$scope.zone = data;
    })
    .error(function () {
        $scope.state = 'error';
        $scope.displayCreateContactButton = false;
    });

   });
