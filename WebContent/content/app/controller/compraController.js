class compraObj{
		constructor(country,first_name){
			this.country = country;
			this.first_name = first_name;
		
		}
	}


app.controller("compraController",["$scope","compraService",'$location',function($scope ,compraService,$location){
	$scope.compraObj = new compraObj("","");
	$scope.comprar = comprar;
			
	function comprar(email){			
		compraService.comprar(email)
			.then(data=>{
				console.log(data);
				//aqui abrir modal con detalle de venta				
				compraService.detalleCompra(data.estadoRespuesta) // aqui debe ir el id de la compra para que se ocupe en el modulo de ventas y al finalizar una compra
				.then(data=>{
					
					 modalDialog.showModal(data,"Detalle de Compra",eBotones.YES,function(){
						document.getElementById('btnRedireccion').click();
					});
							}
					,resp=>{
						alert("Error al mostra detalle de compra" + resp.status);
					});
						}
				,resp=>{
					alert("Error en la compra" + resp.status);
			});
	}

}]);