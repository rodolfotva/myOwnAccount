angular.module('main').factory('mainService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_DATA_URL = 'http://localhost:8082/myOwnAccount/header/';
    var REST_SERVICE_DOLOGIN_URL = 'http://localhost:8082/myOwnAccount/user/login/';
    var REST_SERVICE_ACCOUNTS_BYUSER_URL = 'http://localhost:8082/myOwnAccount/account/byuser/';
    var REST_SERVICE_LINEITENS_BYACC_URL = 'http://localhost:8082/myOwnAccount/lineitem/byaccount/';
    
    var factory = {
   		fetchAllData:fetchAllData,
   		loadAccounts:loadAccounts,
   		loadLineitems:loadLineitems,
   		doLogin:doLogin
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
    
    function loadAccounts(userid) {
    	var deferred = $q.defer();
    	$http.get(REST_SERVICE_ACCOUNTS_BYUSER_URL+userid).then(
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


    
}]);