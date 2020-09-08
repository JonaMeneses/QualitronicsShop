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
				 modalDialog.showModal(data,"Detalle",eBotones.YES,function(){});
            }
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerFormularioView(){	 
	$.ajax({
        url:"articulos/detalleView"
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
        url:"articulos/actualiza"
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
        url:"articulos/obtenerporid"
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
        url:"articulos/eliminar"
        ,type: "GET"
		,data: {nId:nId}
        ,success:function(View){
			$("#adminContainer").html(View);           
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
	

});