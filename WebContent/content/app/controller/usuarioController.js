class Usuario{
		constructor(id,nombre,fotoURL,sitioURL){
			this.id = id;
			this.nombre = nombre;
			this.fotoURL = fotoURL;
			this.sitioURL = sitioURL;
		}
	}

miApp.controller("usuarioController",["$scope","usuarioService",function($scope,usuarioService){
	$scope.usuarios = [];
	$scope.usuario = new Usuario(null,"","","");
	$scope.getArtistas = getArtistas;
	$scope.findById = findById;
	$scope.guardar = guardar;
	$scope.eliminar = eliminar;
	$scope.reset = reset;
	
	function getUsuarios(){
		var promise = usuarioService.getUsuarios();
		promise.then(data=>{
			$scope.artistas = data;
		},resp=>{
			alert("Error de lectura" + resp.status);
		});
	}
	
	function findById(id){
		artistaService.getArtista(id)
			.then(data=>{
				$scope.artista = data;
			},resp=>{
				alert("Error en la lectura de id"+ id +", "+ resp.status);
			});
	}
	
	function crateArtista(artista){
		artistaService.crate(artista)
			.then(
				getArtistas
				,resp=>{
					alert("Error en la creacion" + resp.status);
			});
	}
	
	function updateArtista(id,artista){
		artistaService.update(id,artista)
			.then(getArtistas
			,resp=>{
				alert("Error en la creacion" + resp.status);
			});
	}
	
	function deleteArtista(artista){
		artistaService.delete(id)
			.then(getArtistas
			,resp=>{
				alert("Error en la creacion" + resp.status);
			});
	}
	
	
	function guardar(){
		console.log($scope.artista);
		
		if($scope.artista.id === null){
			createArtista($scope.artista);
		}else{
			updateArtista($scope.artista.id,$scope.artista);
		}
		reset();
	}
	
	function eliminar(id){
		if($scope.artista.id === id){
			reset();
		}
		deleteArtista(id);
	}
	
	function reset(){
		$scope.artista = new Artista();
		$scope.formulario.$setPristine();
	}
	
	getArtistas();
}]);