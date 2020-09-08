class compraObj{
		constructor(country,first_name){
			this.country = country;
			this.first_name = first_name;
		
		}
	}


app.controller("compraController",["$scope","compraService",function($scope ,compraService){
	$scope.compraObj = [];
	$scope.compraObj = new compraObj("","");
	$scope.comprar = comprar;
			
	function comprar(email){			
		compraService.comprar(email)
			.then(
				alert("sucedio")
				,resp=>{
					alert("Error en la compra" + resp.status);
			});
	}

}]);