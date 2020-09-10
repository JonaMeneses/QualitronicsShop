app.factory("compraService",["$http","$q",function($http,$q){
		const URL = "/qualitronicshop/api/compras/realizarCompra/";
		
	var factory={
		comprar: comprar,
		detalleCompra : detalleCompra
	}
	return factory;
	
	function comprar(sEmail){
		deferred = $q.defer();
		$http.get(URL+"?email="+sEmail+"")
		.then(response=>{
			deferred.resolve(response.data);
		},resp=>{
			
		});
		return deferred.promise;
	}
	
	function detalleCompra(id){
		deferred = $q.defer();
		$http.get("/qualitronicshop/ventas/detalle/?nId="+id)
		.then(response=>{
			deferred.resolve(response.data);
		},resp=>{
			
		});
		return deferred.promise;
	}
	
}]);