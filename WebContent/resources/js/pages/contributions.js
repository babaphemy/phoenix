phoApp.controller('contribController', function($scope, $http){
	$scope.url = "/phoenix/protected/contributions/";
	var url = $scope.url
    $http.get(url)
    .success(function (data) {
      //  $scope.finishAjaxCallOnSuccess(data, null, false);
    	$scope.contrib = data;
    })
    .error(function () {
        $scope.state = 'error';
        $scope.displayCreateContribButton = false;
    });

	
});