app.factory("compraService",["$http","$q",function($http,$q){
		const URL = "/qualitronicshop/api/compras/realizarCompra/";
		
	var factory={
		comprar: comprar,
	}
	return factory;
	
	function comprar(sEmail){
		deferred = $q.defer();
		$http.get(URL+"?email=jona_meneses@hotmail.com")
		.then(response=>{
			deferred.resolve(response.data);
		},resp=>{
			
		});
		return deferred.promise;
	}
	
}]);