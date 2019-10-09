angular.module('main', ['ngSanitize']).controller('mainController', ['$scope', 'mainService', function($scope, mainService) {
	$scope.data = {};
	$scope.menu = 'login';
	$scope.accounts = {};
	$scope.lineitems = {};
	$scope.account;
	$scope.steps = 'account';
	$scope.usercompname;
	$scope.loginStatus;
	$scope.hideLoginError = true;
	
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

    $scope.doLogin = function() {
    	$scope.hideLoginError = true;
    	mainService.doLogin($scope.username, $scope.password).then(
    			function(response) {
    				$scope.usercompname = response.data['usercompname'];
    				$scope.loginStatus = response.data['loginStatus'];
    				debugger;
    				if ($scope.loginStatus == '200') {
    					$scope.menuChange('accountmain');
    					$scope.$apply();
    				} else if ($scope.loginStatus == '401') {
    					$scope.hideLoginError = false;
    				} else if ($scope.loginStatus == '402') {
    					$scope.hideLoginError = false;
    				}
    				
    			},
    			function(errResponse){
    				console.log('Error while do login');
    			}
    	);
    }    
    
    $scope.valueStyle = function(value) {
		var num = parseInt(value);
		var css = { 'color':'blue' };  
		
		if(num < 0){
			css = { 'color':'red' };
		}
		
		return css;
    }
    
	$scope.menuChange = function(value) {
		$scope.menu = value;
    };
}]);