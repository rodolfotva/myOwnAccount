angular.module('main', ['ngSanitize']).controller('mainController', ['$scope', 'mainService', function($scope, mainService) {
	$scope.data = {};
	$scope.menu = 'page1';

    $scope.fetchAllData = function(){
    	mainService.fetchAllData().then(
            function(response) {
            	$scope.data = response.data;
            },
            function(errResponse){
                console.log('Error while fetching Headers');
            }
        );
    }
    
	$scope.menuChange = function(value) {
		$scope.menu = value;
    };
}]);