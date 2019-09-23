angular.module('main', ['ngSanitize']).controller('mainController', ['$scope', 'mainService', function($scope, mainService) {
	$scope.data = {};
	$scope.menu = 'login';
	$scope.accounts = {};
	$scope.lineitems = {};
	$scope.account;
	$scope.steps = 'account';
	
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
    
    $scope.dologin = function(username, password){
    	mainService.dologin(username, password).then(
    			function(response) {
    				
    			},
    			function(errResponse){
    				console.log('Error while login');
    			}
    	);
    }

    $scope.loadAccounts = function(userid){
    	mainService.loadAccounts(userid).then(
    			function(response) {
    				$scope.accounts = response.data;
    			},
    			function(errResponse){
    				console.log('Error while fetch accounts');
    			}
    	);
    }

    $scope.loadLineitems = function(accountId){
    	mainService.loadLineitems(accountId).then(
    			function(response) {
    				$scope.lineitems = response.data['lineitenLst'];
    				$scope.total = response.data['total'];
    			},
    			function(errResponse){
    				console.log('Error while fetch lineitem');
    			}
    	);
    }

	$scope.menuChange = function(value) {
		$scope.menu = value;
    };
}]);