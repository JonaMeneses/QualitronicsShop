
function guardar(){	
	let URL = "usuarios/insertar";
	if($("#nId").val() > 0){
		 URL = "usuarios/actualizar";
	} 
	
	console.log(URL);
	
	$.ajax({
        url:URL
        ,type: $('#formulario').attr("method")
		,data: $('#formulario').serialize()
        ,success:function(View){

			if(View == "OK"){
				alert("OK");
			}else{
				$("#adminContainer").html(View);
			}
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

$(document).ready(function () {
	
	if($("#detalle").val() == "1")
	{
		$("#formulario").find(".form-control").prop("disabled",true);
		$("#btnGuardar").prop("disabled",true);
		
	}else{
		console.log("no existe");
	}
});