angular.module('main').factory('mainService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_DATA_URI = '/header/';
 
    var factory = {
   		fetchAllData:fetchAllData
    };
 
    return factory;
 
    function fetchAllData() {
    	var deferred = $q.defer();
        $http.get(REST_SERVICE_DATA_URI).then(
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
    
}]);