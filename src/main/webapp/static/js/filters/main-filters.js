angular.module('main').filter('searchDescFilter', function () {
	return function (input, query) {
		return input.replace(RegExp('('+ query + ')', 'gi'), '<span class="search-filter">$1</span>');
    }
});
