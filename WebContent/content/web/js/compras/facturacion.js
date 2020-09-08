
function obtenerCarritoView(){
	 $.ajax({
        url:"carrito"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(view){
			
            modalDialog.showModal(view,"Carrito de compras",eBotones.YES,function(){},"modalCarrito");
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}