function obtenerDetalleView(nId){
    $.ajax({
        url:"articulos/detalleView"
        ,data : {nId}
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(data){
	console.log("entro");
            if(data)
            {
                
				$("#ModalDetalle").modal("show");
				$("#ModalDetalleBody").html(data);
				$("#ModalTitulo").html("Detalle Articulo");

            }
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function llenarTabla(usuarios){
	$("#tablaUsuarios tbody").empty();
		$(usuarios).each(function(idx,usr){
			$tr = $("<tr/>");
			$tdEmail = $("<td/>",{'html' : usr.sEmail});
			$tdNombre = $("<td/>",{'html' : usr.sNombre});
			$tdEdad = $("<td/>",{'html' : usr.nEdad});
			$tdRol = $("<td/>",{'html' : usr.sRol});
			$tdAcciones = $("<td/>");
					
			//CRUD
			$btnEditar = $("<a/>",{
				"html":'<i class="fas fa-pencil-alt"></i>',
				"href": "#",
				"class": "btn btn-primary"
			}).click(e=>{
				e.preventDefault();
				buscarPorId(usr.nId);
					
			});
			$btnBorrar = $("<a/>",{
				"html":'<i class="fas fa-pencil-alt"></i>',
				"href": "#",
				"class": "btn btn-danger"
			}).click(e=>{
				e.preventDefault();
				borrar(usr.nId);
			});
			$tdAcciones.append($btnEditar).append($btnBorrar);

			$tr.append($tdEmail).append($tdNombre).append($tdEdad).append($tdRol).append($tdAcciones);
			
			$("#tabla tbody").append($tr);
		});
}

function obtenerListado(){
    $.ajax({
        url:"usuarios/"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(data){
			llenarTabla(data);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

$(document).ready(function () {
	obtenerListado();

});