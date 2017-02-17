'use strict';



angular.module('app')
  .service('formationSvc', ['$http', function ($http) {
	  
   this.fetchPopular = function(callback) {
   		var url = "http://localhost:8090/formation";
   		$http.get(url).then(function(response){
   			callback(response.data);
   		   
   		});
   };

   this.supprimerFormation = function(codeFormation){
	 $http.delete("http://localhost:8090/formation/" + codeFormation).then(function(reponse){
		 alert("formation supprimée");
	 },function(erreur){
		 alert("il ya une erreur");
	 });  
   };
   
   
   this.afficherDetails = function(callback, codeFormation) {
  		var url = "http://localhost:8090/formation/" + codeFormation;
  		$http.get(url).then(function(response){
  			callback(response.data);
 
  		});
  };
   
   
   this.ajouterFormation = function(formation){
	   formation["Content-Type"] = "application/json";
		 $http.post("http://localhost:8090/formation",formation).then(function(reponse){
			 alert("formation ajoutée");
		 },function(erreur){
			 alert("il ya une erreur");
		 });  
	   };
  }]);


angular.module('app')
	  	.controller('FormationCtrl', ['$scope','formationSvc', '$routeParams',function ($scope,formationSvc,$routeParams) {
	    
	  	
		$scope.formations=[];
		$scope.formation =null;
		$scope.supprimerFormation = function(codeFormation){
			formationSvc.supprimerFormation(codeFormation);
		};
		
		
		$scope.data = {
				
				codeFormation : "",
				debutAccreditation : "",
				diplome : "",
				doubleDiplome : "",
				finAccreditation : "",
				n0Annee :"",
				nomFormation : ""
		
		};
		
		this.afficherDetails = function(codeF){
			formationSvc.afficherDetails(function(data){
				$scope.formation= data;
			
			}
			,codeF)
			
		};
		
		$scope.ajouterFormation = function(formation){
		
			formationSvc.ajouterFormation(formation);
		};
		
		if($routeParams.codeFormation){
			var codeformation = $routeParams.codeFormation;
			this.afficherDetails(codeformation);
		}


		
		
		
	  	
		
    	formationSvc.fetchPopular(function(data){
    			$scope.formations=data;
                console.log("t"+data);
    	})
 	  }]);



