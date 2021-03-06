angular.module('main', ['ngSanitize', 'ngMask']).controller('mainController', ['$scope', '$timeout', '$window', 'mainService', function($scope, $timeout, $window, mainService) {
	$scope.data = {};
	$scope.accounts = {};
	$scope.lineitems = {};
	$scope.menu = 'accountmain';
	$scope.steps = 'account';
	$scope.hideLoginError = true;
	$scope.hideAddaccError = true;
	$scope.hideAddlineError = true;
	$scope.hideAddaccSuccessMessage = true;
	$scope.hideAddlineSuccessMessage = true;
	$scope.addAccountSuccess = true;
	$scope.addLineSuccess = true;
	$scope.account;
	$scope.usercompname;
	$scope.loginStatus;
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
    
    $scope.loadAccounts = function(){
    	mainService.loadAccounts().then(
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
    				debugger;
    				$scope.usercompname = response.data['usercompname'];
    				$scope.loginStatus = response.data['loginStatus'];
    				
    				if ($scope.loginStatus == '200') {
    					$window.location.reload();
    				} else if ($scope.loginStatus == '401') {
    					$scope.hideLoginError = false;
    					$scope.loginErrorInput = 'Username';
    				} else if ($scope.loginStatus == '402') {
    					$scope.hideLoginError = false;
    					$scope.loginErrorInput = 'Password';
    				}
    				
    				$scope.$apply;
    			},
    			function(errResponse){
    				console.log('Error while do login');
    			}
    	);
    }    

    $scope.addAccount = function() {
    	$scope.hideAddaccError = true;
    	mainService.addAccount($scope.accName, $scope.accDesc).then(
    			function(response) {
    				$scope.addAccountSuccess = response.data;
    				
    				if ($scope.addAccountSuccess) {
    					$scope.hideAddaccSuccessMessage = false;
    					$scope.accName = '';
    					$scope.accDesc = '';
    				} else {
    					$scope.hideAddaccError = false; 					
    				}
    				
    				$scope.$apply;
    			},
    			
    			function(errResponse){
    				console.log('Error while add account');
    			}
    	);
    }    
    
    $scope.addLineitem = function() {
    	$scope.hideAddlineError = true;
    	mainService.addLineitem($scope.lineDesc, $scope.lineValue, $scope.account.id, $scope.lineEmail).then(
    			function(response) {
    				$scope.addLineSuccess = response.data;
    				
    				if ($scope.addLineSuccess) {
    					$scope.hideAddlineSuccessMessage = false;
    					$scope.lineDesc = '';
    					$scope.lineValue = '';
    				} else {
    					$scope.hideAddlineError = false; 					
    				}
    				
    				$scope.$apply;
    			},
    			
    			function(errResponse){
    				console.log('Error while add account');
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
    
    $scope.hideAccount = function(userId) {
    	if (userId == null || userId == '') {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    $scope.logout = function() {
    	mainService.logout().then(
			function(response) {
				if (response.data) {
					$window.location.reload();
				} else {
					console.log('Error while validate logout');
				}
			},
			function(errResponse){
				console.log('Error while logout');
			}	
    	);
    }
    
    $scope.goback = function() {
    	$window.history.back();
    }
    
	$scope.menuChange = function(value) {
		$scope.menu = value;
    };
    
	$scope.stepChange = function(value) {
		$scope.step = value;
    };
}]);