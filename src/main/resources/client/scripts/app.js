(function() {
	'use strict';
	var app = angular.module(
			'app',
			[ 'ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart',
					'mgo-angular-wizard', 'textAngular', 'ui.tree',
					'ngTagsInput']).config(
			[ '$routeProvider', function($routeProvider, $urlRouterProvider) {
    $routeProvider
      .when('/formation', {
        templateUrl: 'views/formation.html',
        controller: 'FormationCtrl',

      })
       .when('/formulaire', {
        templateUrl: 'views/formulaire.html',
        controller: 'FormationCtrl',
 
      })
      
      .when('/accueil', {
        templateUrl: 'views/accueil.html',
        controller: 'FormationCtrl',
 
      })
	
	    .when('/formation/:codeFormation', {
		templateUrl: 'views/detailsFormulaire.html',
		controller: 'FormationCtrl',
		controllerAs : 'FrmCtrl'
		 
     })
		      
      
      .otherwise({
        redirectTo: '/'
      });
    
    
  } ]);
  
}).call(this);







