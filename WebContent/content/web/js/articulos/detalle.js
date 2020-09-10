function obtenerDetalleArticulo(nId){
    $.ajax({
        'url':"api/articulo/"+nId
        ,type: 'GET'
        ,dataType: 'json'
        ,success:function(data){
            if(data)
            {
                
            }
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function agregarArticuloCarrito(nId){
	let nCantidad = $("#cantidadArticulos").val();
	if(nCantidad > 0){
    $.ajax({
        'url':"api/compras/agregarArticuloCarrito/"
        ,type: 'GET'
		,data: {nId : nId,nCantidad : nCantidad}
        ,dataType: 'json'
        ,success:function(data){
            modalDialog.showDialog("aviso","Se agrego articulo al carrito",eBotones.YES,eIconos.SUCCESS,function(){});
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });	
}else{
	modalDialog.showDialog("Aviso","Debe ingresar una cantidad mayor a 0",eBotones.YESNO,eIconos.ERROR,function(e){})
}
}



$(document).ready(function () {

});

