angular.module('main').factory('mainService', ['$http', '$q', function($http, $q){

	var UAU = 'http://localhost:8082/myOwnAccount';
    var REST_SERVICE_DATA_URL = UAU + '/header/';
    var REST_SERVICE_DOLOGIN_URL = UAU + '/user/login/';
    var REST_SERVICE_ACCOUNTS_BYUSER_URL = UAU + '/account/byuser/';
    var REST_SERVICE_LINEITENS_BYACC_URL = UAU + '/lineitem/byaccount/';
    var REST_SERVICE_LOGOUT_URL = UAU + '/user/logout/';
    var REST_SERVICE_ADD_ACCOUNT = UAU + '/account/add/';
    var REST_SERVICE_ADD_LINEITEM = UAU + '/lineitem/add/';
    
    var factory = {
   		fetchAllData:fetchAllData,
   		loadAccounts:loadAccounts,
   		loadLineitems:loadLineitems,
   		doLogin:doLogin,
   		logout:logout,
   		addAccount:addAccount,
   		addLineitem:addLineitem
    };
 
    return factory;
 
    function fetchAllData() {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_DATA_URL).then(
            function (response) {
                deferred.resolve(response);
            },
            function(errResponse){
                console.log('Error while fetching Data');
                console.log(errResponse);
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function loadAccounts() {
    	var deferred = $q.defer();
    	$http.get(REST_SERVICE_ACCOUNTS_BYUSER_URL).then(
    			function (response) {
    				deferred.resolve(response);
    			},
    			function(errResponse){
    				console.log('Error while fetch accounts');
    				console.log(errResponse);
    				deferred.reject(errResponse);
    			}
    	);
    	return deferred.promise;
    }

    function loadLineitems(accountId) {
    	var deferred = $q.defer();
    	$http.get(REST_SERVICE_LINEITENS_BYACC_URL+accountId).then(
    			function (response) {
    				deferred.resolve(response);
    			},
    			function(errResponse){
    				console.log('Error while fecth lineitems');
    				console.log(errResponse);
    				deferred.reject(errResponse);
    			}
    	);
    	return deferred.promise;
    }
    
    function doLogin(username, password) {
    	var deferred = $q.defer();
    	$http.get(REST_SERVICE_DOLOGIN_URL+username+"/"+password).then(
    			function (response) {
    				deferred.resolve(response);
    			},
    			function(errResponse){
    				console.log('Error while do login');
    				console.log(errResponse);
    				deferred.reject(errResponse);
    			}
    	);
    	return deferred.promise;
    }
    
    function logout() {
    	var deferred = $q.defer();
    	$http.get(REST_SERVICE_LOGOUT_URL).then(
    			function (response) {
    				deferred.resolve(response);
    			},
    			function(errResponse){
    				console.log('Error while logout');
    				console.log(errResponse);
    				deferred.reject(errResponse);
    			}
    	);
    	return deferred.promise;
    }

    function addAccount(name, description) {
    	var deferred = $q.defer();
    	$http.post(REST_SERVICE_ADD_ACCOUNT+name+"/"+description).then(
    			function (response) {
    				deferred.resolve(response);
    			},
    			function(errResponse){
    				console.log('Error while add account');
    				console.log(errResponse);
    				deferred.reject(errResponse);
    			}
    	);
    	return deferred.promise;
    }
    
    function addLineitem(description, value, accountId) {
    	var deferred = $q.defer();
    	$http.get(REST_SERVICE_ADD_LINEITEM+description+"/"+value+"/"+accountId).then(
    			function (response) {
    				deferred.resolve(response);
    			},
    			function(errResponse){
    				console.log('Error while add lineitem');
    				console.log(errResponse);
    				deferred.reject(errResponse);
    			}
    	);
    	return deferred.promise;
    }

    
}]);