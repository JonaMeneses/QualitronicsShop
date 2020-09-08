
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
});