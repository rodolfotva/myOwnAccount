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
