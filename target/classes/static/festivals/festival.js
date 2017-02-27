'use strict';

angular.module('myApp.festival', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/festivals', {
    templateUrl: 'festivals/festivals.html',
    controller: 'festivalCtrl'
  });
}])

.directive('createFestival', function () {
  return {
    //restrict: 'E',
    templateUrl: 'festivals/createFestivalModal.html'
   };
})

.directive('updateFestival', function () {
  return {
    //restrict: 'E',
    templateUrl: 'festivals/updateFestivalModal.html'
   };
})

.controller('festivalCtrl', ['$rootScope','$scope','$http',function($rootScope,$scope,$http) {
	 var dataPath = "http://localhost:8080/rest/festivals";
	 var bandPath = "localhost:8080/rest/bands";
	 var config = {
             headers : {
                 'Content-Type': 'application/json'
             }
         }
	 	 
	  //Create a band
		$scope.postBand = function(bandType){
		 var dataBand = {
				 type:bandType
		 }
		console.log(dataBand);
		 $http.post(bandPath, dataBand, config)
		         .success(function (data, status, headers, config) {
		        	 console.log(data);

		         })
		         .error(function (data, status, header, config) {
         });
		 $scope.getBands();
	}
	 
	 //Get created bands
	 $scope.getBands = function(){
		 $http.get(bandPath).then(function (response) {
				$scope.bandsObj = response.data;
				console.log($scope.bandsObj);
	         //return response;
	     });
	 }
	 /*
	  * 
	  * Exclusions
	  */
	 $scope.getUsers = function(){
		 $http.get(dataPath).then(function (response) {
				$scope.festivalsObj = response.data;
				console.log($scope.festivalsObj);
	         //return response;
	     });
	 }
	 
	 //retrive all exclusions

	$scope.postUser = function(name,location){
		 var JSON = {
             name:name,
             location:location
		 }
		console.log(JSON);
		 $http.post(dataPath, JSON, config)
		         .success(function (data, status, headers, config) {
		        	 console.log(data);

		         })
		         .error(function (data, status, header, config) {
         });
		 $scope.getUsers();
	}
	
	//delete festivals
	$scope.deleteUser = function(festivalId){
		$http.delete(dataPath+ '/' +festivalId)
		   .then(
		       function(response){
		         alert('Festival has been deleted');
		       }, 
		       function(response){
		        console.log('We got some errors during the deletion process');
		       }
		    );
		$scope.getUsers();
	}
	
	$scope.passId = function(festivalId){
		console.log(festivalId);
	}
	
	//update festivals
	$scope.userUpdate = function(id){
	
		console.log(id);
		//console.log(exclusionId);
		 var newJSON = {
             name:newName,
				 location:newLocation
		 }
	/*	$http.put(dataPath+ '/' +exclusionId,newJSON)
		   .then(
		       function(response){
		         alert('Festival has been updated');
		       }, 
		       function(response){
		        console.log('We got some errors during the updating process');
		       }
		    );*/
		$scope.getUsers();
	}

	 


}]);