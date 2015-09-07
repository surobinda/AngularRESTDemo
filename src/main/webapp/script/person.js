
	var mainApp = angular.module("movieApp", ['ngRoute']);
    
    mainApp.config(['$routeProvider',
       function($routeProvider) {
          $routeProvider.
             when('/addPerson', {
                templateUrl: 'template/addperson.html',
                controller: 'AddPersonController'
             }).
             when('/listPerson', {
                 templateUrl: 'template/listperson.html',
                 controller: 'ListPersonController'
             }).
	         otherwise({
            	templateUrl: 'template/default.html',
                controller: 'DefaultPersonController'
             });
    }]);

    mainApp.controller('AddPersonController', ['$rootScope', '$location', '$scope', '$http',function($rootScope, $location, $scope, $http) 
    {
    	$scope.firstName = "";
		$scope.lastName = "";
		
		$scope.message = " " ;
		
		$scope.reset = function() 
		{
			$scope.firstName = "";
			$scope.lastName = "";
		}
		
        $scope.submit = function() 
		{
			var dataObj = 
			{
					firstName: $scope.firstName,
					lastName:  $scope.lastName
			};
			
			var res = $http.post('/AngularRESTDemo/rest/person', dataObj);
			res.success(function(data, status, headers, config)
			{
				$rootScope.message = "Person details has been successfully saved, person id - " + data.personId;
				$scope.reset();
				$location.path( "/index" );
			});
			
			res.error(function(data, status, headers, config)
			{
				$rootScope.message = "Failed to save person details. Please try after some time." + status;
				$scope.reset();
				$location.path( "/index" );
			});	
		}
		
	}]);
   
    mainApp.controller('ListPersonController', ['$rootScope','$location', '$scope', '$http', function($rootScope,$location, $scope, $http) 
    {
        $scope.message = "List of Person";
        $http.get('/AngularRESTDemo/rest/person').
        success(function(data) {
            $scope.persons = data;
        });
        
    }]);
    
    mainApp.controller('DefaultPersonController', ['$rootScope','$location', '$scope', '$http',function($rootScope,$location, $scope, $http) 
	{
        if ($rootScope.message != null)
        {
        	$scope.message = $rootScope.message;
        }
        else
    	{
        	$scope.message = "Welcome to Person Application !";
    	}
		
    }]);
