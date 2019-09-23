angular.module('main').directive('page1Page', function () {
	return {
        templateUrl: 'page1',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.fetchAllData();
		}
    };
});

angular.module('main').directive('page2Page', function () {
    return {
        templateUrl: 'page2'
    };
});

angular.module('main').directive('loginPage', function () {
	return {
        templateUrl: 'login',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.dologin = function(username, password) {
				$scope.dologin(username, password);
			};
		}
    };
});

angular.module('main').directive('accountmainPage', function () {
	return {
        templateUrl: 'accountmain',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.steps = 'account';
			
			$scope.gotoLineitens = function(account) {
				$scope.steps = 'lineitem';
				$scope.account = account;
				$scope.loadLineitems(account.id);	
			}
		}
    };
});

angular.module('main').directive('accountPage', function () {
	return {
        templateUrl: 'account',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){
			$scope.loadAccounts('5d647e011a00da3b68b42afe');
		}
    };
});

angular.module('main').directive('lineitemPage', function () {
	return {
        templateUrl: 'lineitem',
    };
});
