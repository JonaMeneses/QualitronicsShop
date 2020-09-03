function obtenerArticulosView(){
    $.ajax({
        url:"articulos/listado"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(View){
			$("#adminContainer").html(View);
			$("#adminContainer").prop("formulario","Articulos");
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerDashboardView(){
	 $.ajax({
        url:"admin/dashboard"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(View){
           $("#adminContainer").html(View);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function eliminar(){
	 $.ajax({
        url:"admin/dashboard"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(View){
           $("#adminContainer").html(View);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerFormularioArticulosView(){
	 $.ajax({
        url:"articulos/nuevo"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(View){
           $("#adminContainer").html(View);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

$(document).ready(function () {
	obtenerDashboardView();
	
	$("#btnNuevoRegistro").on("click",()=>{
		let tipoFormulario =  $("#adminContainer").prop("formulario");
		switch(tipoFormulario){
			case "Articulos":
				obtenerFormularioArticulosView();
			break;
			case "Usuarios":
				//obtenerFormularioArticulosView();
			break;
		}
		
	});
	
});