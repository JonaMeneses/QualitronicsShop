
function recargarCarritoView(){
	 $.ajax({
        url:"compras/carrito"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(view){
			$("#modalCarrito").find("div.modal-body").empty();
			$("#modalCarrito").find("div.modal-body").append(view);
		}
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerCarrito(){
	 $.ajax({
        url:"api/compras/obtenerCarrito/"
        ,type: 'GET'    
        ,dataType: 'json'
        ,success:function(data){
          
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });


}

function eliminarArticuloCarrito(nId){
	modalDialog.showDialog("Aviso","Desea Eliminar el articulo?",eBotones.YESNO,eIconos.INFO,function(e){	
	if(e){
		 $.ajax({
	        url:"api/compras/eliminarArticuloCarrito/"
	        ,type: 'GET'  
			,data: {nId:nId}  
	        ,dataType: 'json'
	        ,success:function(data){
				recargarCarritoView();
	        }
	        ,error:function(xhr,status){
	            console.log( "error en llamada");
	            console.log(JSON.stringify(xhr));
	        }
	    });
	}
});
}

function modificarCantidadArticuloCarrito(nId,nCantidad){
	if(nCantidad >= 0)
	{
	 $.ajax({
        url:"api/compras/modificarCantidadArticuloCarrito/"
        ,type: 'GET'  
		,data: {nId:nId,nCantidad:nCantidad}  
        ,dataType: 'json'
        ,success:function(data){
			recargarCarritoView();
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}else{
	modalDialog.showDialog("Aviso","No se puede ingresar cantidad negativa",eBotones.YES,eIconos.ERROR,function(e){});
}
}

function checkOutView(){
	 $.ajax({
        url:"compras/checkout"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(view){
			$("#modalCarrito").find("div.modal-body").empty();
			$("#modalCarrito").find("div.modal-body").append(view);
		}
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

	
$(document).ready(function () {
	obtenerCarrito();
	$("#txtCantidadArticulo").on("blur",function(){
		modificarCantidadArticuloCarrito($("#txtCantidadArticulo").attr("nid"),$(this).val())
	})
});