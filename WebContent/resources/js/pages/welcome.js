phoApp.controller('welcomeController', function($scope, $http) {
    $scope.url = "/phoenix/protected/users/";
	//function findAllZones(){
    $scope.mods = [];
		var url = $scope.url;
		$http.get(url)
		.success(function(data){
			$scope.mods = data;
		})
		;
	
	

});




