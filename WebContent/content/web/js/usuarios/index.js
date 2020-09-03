function llenarTabla(usuarios){

	$("#tablaUsr tbody").empty();
		$(usuarios).each(function(idx,usr){
			
			$tr = $("<tr/>");
			$tdEmail = $("<td/>",{'html' : usr.sEmail});
			$tdNombre = $("<td/>",{'html' : usr.sNombre});
			$tdEdad = $("<td/>",{'html' : usr.nEdad});
			$tdRol = $("<td/>",{'html' : usr.sNombreRol});
			$tdAcciones = $("<td/>");
					
			//CRUD
			$btnEditar = $("<a/>",{
				"html":'<i class="fas fa-pencil-alt"></i>',
				"href": "#",
				"class": "btn btn-primary"
			}).click(e=>{
				e.preventDefault();
				obtenerFormularioPorIdView(usr.nId);
					
			});
			$btnBorrar = $("<a/>",{
				"html":'<i class="far fa-trash-alt"></i>',
				"href": "#",
				"class": "btn btn-danger"
			}).click(e=>{
				e.preventDefault();
				eliminar(usr.nId);
			});
			$tdAcciones.append($btnEditar).append($btnBorrar);

			$tr.append($tdEmail).append($tdNombre).append($tdEdad).append($tdRol).append($tdAcciones);
			
			$("#tablaUsr tbody").append($tr);
		});
}

function obtenerListado(){
    $.ajax({
        url:"api/usuarios/"
        ,type: 'GET'    
        ,dataType: 'json'
        ,success:function(data){
			llenarTabla(data);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerFormularioUsuarioView(){	 
	$.ajax({
        url:"usuarios/altaUsuario"
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

function obtenerFormularioPorIdView(id){	
	
	$.ajax({
        url:"usuarios/actualizarUsuario"
        ,type: 'GET'
		,data: {nId: id}
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

function obtenerFormularioDetalleView(id){	
	
	$.ajax({
        url:"usuarios/detalleUsuario"
        ,type: 'GET'
		,data: {nId: id}
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

function eliminar(nId){	
	modalDialog.showDialog("Aviso","Desea eliminar el registro?",eBotones.YESNO,eIconos.INFO,function(e){
		if(e)
		{
	$.ajax({
        url:"api/usuarios/"+nId
        ,type: "DELETE"
        ,success:function(result){
			obtenerListado();
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }		
    });
	}
 });
}

$(document).ready(function () {
	obtenerListado();

});