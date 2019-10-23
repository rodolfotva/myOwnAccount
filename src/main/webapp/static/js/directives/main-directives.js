angular.module('main').directive('loginPage', function () {
	return {
        templateUrl: 'login',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){

		}
    };
});

angular.module('main').directive('homePage', function () {
	return {
        templateUrl: 'home',
		restrict: 'AE',
		controller: 'mainController',
		link: function($scope, $element, $attrs, ctrl){

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
			$scope.loadAccounts();
		}
    };
});

angular.module('main').directive('lineitemPage', function () {
	return {
        templateUrl: 'lineitem',
    };
});
