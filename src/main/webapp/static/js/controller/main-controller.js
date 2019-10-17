angular.module('main', ['ngSanitize']).controller('mainController', ['$scope', '$timeout', 'mainService', function($scope, $timeout, mainService) {
	$scope.data = {};
	$scope.menu = 'login';
	$scope.accounts = {};
	$scope.lineitems = {};
	$scope.account;
	$scope.steps = 'account';
	$scope.usercompname;
	$scope.loginStatus;
	$scope.hideLoginError = true;
	$scope.loginErrorInput;
	
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
    	$scope.loginErrorInput = '';
    	mainService.doLogin($scope.username, $scope.password).then(
    			function(response) {
    				$scope.usercompname = response.data['usercompname'];
    				$scope.loginStatus = response.data['loginStatus'];
    				if ($scope.loginStatus == '200') {
    					angular.element('#menuAccountmain').triggerHandler('click');
    				} else if ($scope.loginStatus == '401') {
    					$scope.hideLoginError = false;
    					$scope.loginErrorInput = 'Username';
    				} else if ($scope.loginStatus == '402') {
    					$scope.hideLoginError = false;
    					$scope.loginErrorInput = 'Password';
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