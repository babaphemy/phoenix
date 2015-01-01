/*phoApp.service('dataService', function($http,$q) {

	  delete $http.defaults.headers.common['X-Requested-With'];
	  this.getData = function() {
	     deferred = $q.defer();
	     $http({
	         method: 'GET',
	         url: '/Phoenix/protected/zones',
	         params: 'limit=10, sort_by=created:desc',
	         headers: {'Authorization': 'Token token=xxxxYYYYZzzz'}
	     }).success(function(data){
	         // With the data succesfully returned, we can resolve promise and we can access it in controller
	         deferred.resolve();
	     }).error(function(){
	          alert("error");
	          //let the function caller know the error
	          deferred.reject(error);
	     });
	     return deferred.promise;
	  }
	});*/

phoApp.controller('welcomeController', function($scope, $http) {
	$scope.url = "/phoenix/protected/users";
	//function findAllZones(){
		var url = $scope.url;
		$http.get(url)
		.success(function(data){
			$scope.mods = data;
		})
		;
	//}
	
/*	$scope.webi = [
	               {name :'dele'},
	               {   name: 'soji'},
	               {   name:'yemi' }
	               ];
	$scope.data = null;
    dataService.getData().then(function(response) {
        $scope.data = response;
    });*/
});




