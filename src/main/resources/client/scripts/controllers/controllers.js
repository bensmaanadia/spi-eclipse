'use strict';



angular.module('app')
  .service('formationSvc', ['$http', function ($http) {
   this.fetchPopular = function(callback) {
   		var url = "http://localhost:8090/formation";
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});
   };

  }]);


angular.module('app')
	  	.controller('FormationCtrl', ['$scope','formationSvc',function ($scope,formationSvc) {
	    
		$scope.formations=[];
    	formationSvc.fetchPopular(function(data){
    			$scope.formations=data;
                console.log(data);
    	})
 	  }]);