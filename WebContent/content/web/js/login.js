

function obtenerFormularioUsuarioView(){	 
	$.ajax({
        url:"usuarios/altaUsuario"
        ,type: 'GET'  
        ,dataType: 'html'
        ,success:function(View){
            modalDialog.showModal(View,"",eBotones.YES,function(){
				
			});
			$("#divRol").prop("hidden",true);
			$("#divActivo").prop("hidden",true);

        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}


$(document).ready(function () {
		

});