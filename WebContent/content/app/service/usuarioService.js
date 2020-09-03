miApp.factory("artistaService",["$http","$q",function($http,$q){
		const URL = "/musicstore/api/artista/";
		
	var factory={
		getArtistas: getArtistas,
		getArtista: getArtista,
		create: createArtista,
		update: updateArtista,
		delete: deleteArtista
	}
	return factory;
	
	function getArtistas(){
		deferred = $q.defer();
		$http.get(URL)
		.then(response=>{
			deferred.resolve(response.data);
		},resp=>{
			console.log("Error en lectura" + resp.status); 
			deferred.reject(resp);
		});
		return deferred.promise;
	}
	
	function getArtista(id){
		deferred = $q.defer();
		$http.get(URL + id)
		.then(response=>{
			deferred.resolve(response.data);
		},resp=>{
			console.log("Error en lectura" + resp.status); 
			deferred.reject(resp);
		});
		return deferred.promise;
	}
	
	function createArtista(artista){
		deferred = $q.defer();
		$http.post(URL,artista)
		.then(response=>{
			deferred.resolve(response);
		},resp=>{
			console.log("Error en creacion" + resp.status); 
			deferred.reject(resp);
		});
		return deferred.promise;
	}
	
	function updateArtista(id,artista){
		deferred = $q.defer();
		$http.put(URL+id,artista)
		.then(response=>{
			deferred.resolve(response);
		},resp=>{
			console.log("Error en modificacion" + resp.status); 
			deferred.reject(resp);
		});
		return deferred.promise;
	}
	
	function deleteArtista(id){
		deferred = $q.defer();
		$http.delete(URL,id)
		.then(response=>{
			deferred.resolve(response);
		},resp=>{
			console.log("Error en borrado" + resp.status); 
			deferred.reject(resp);
		});
		return deferred.promise;
	}
	
		

}]);