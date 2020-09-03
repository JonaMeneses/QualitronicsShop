/**
 * 
 */

var miApp = angular.module("miapp",[]);

miApp.controller("PruebaController",["$scope",function($scope){
	$scope.mensaje = "Hola mundo";
	$scope.cambiarMensaje = function(){
		$scope.mensaje = "Adios mundo cruel :D";
	}
}]);
