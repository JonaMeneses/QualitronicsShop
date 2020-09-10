class Articulo{
		constructor(nId,sNombre,sMarca,nPrecio,sImgURL1){
			this.id = nId;
			this.sNombre = sNombre;
			this.sMarca = sMarca;
			this.nPrecio = nPrecio;
			this.sImgURL1 = sImgURL1;
		}
	}

function obtenerListadoArticulosView(){
    $.ajax({
        url:"articulos/"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(view){
            $("#contentPage").html(view);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr))	;
        }
    });
}

function obtenerListadoArticulosPorFiltroView(sFiltro){
    $.ajax({
        url:"articulos/listadoPorFiltro"
        ,type: 'GET'
		,data: {sFiltro:sFiltro}   
        ,dataType: 'html'
        ,success:function(view){
            $("#contentPage").html(view);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr))	;
        }
    });
}

function obtenerListadoArticulosPorCategoriaView(sFiltro){
    $.ajax({
        url:"articulos/listadoPorCategoria"
        ,type: 'GET'
		,data: {sFiltro:sFiltro}   
        ,dataType: 'html'
        ,success:function(view){
            $("#contentPage").html(view);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr))	;
        }
    });
}



function obtenerAdminView(){
	 $.ajax({
        url:"admin/"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(view){
            $("#contentPage").html(view);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerCarritoView(){
	 $.ajax({
        url:"compras/carrito"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(view){
			
            modalDialog.showModal(view,"Carrito de compras",eBotones.YES,function(){
				location.reload();
			},"modalCarrito");
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerCheckoutView(){
	 $.ajax({
        url:"admin/"
        ,type: 'GET'    
        ,dataType: 'html'
        ,success:function(view){
            showModal(view, "")
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}
	
$(document).ready(function () {
	
	obtenerListadoArticulosView();
	
	$("#search_mini_form").on("submit",(e)=>{
		e.preventDefault();
	});
	
	$("#btnBuscarCatalogo").on("click",()=>{
		let filtro = $("#txtFiltro").val();
		obtenerListadoArticulosPorFiltroView(filtro);
	});
	
	$('#ModalDetalle').on('show.bs.modal', function () {
	    $('.modal .modal-body').css('overflow-y', 'auto'); 
	    var _height = $(window).height()*0.8;
	    $('.modal .modal-body').css('max-height', _height);
	});
	
});