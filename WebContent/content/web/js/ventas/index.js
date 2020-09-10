function obtenerListado(){
	
    $.ajax({
        url:"api/ventas"
        ,type: 'GET'    
        ,dataType: 'json'
        ,success:function(data){
           console.log(data);
			$("#dataTableVentas").dataTable({
				"aaData": data,
        "columns": [
            { "data": "nid" },
			{ "data": "ventasArticulos.length"  },
            { "data": "ntotal" },
            { "data": "dfechaAlta" },
			{ "data": "usuario.semail" },
			{ "data":  "nid",
			 "render": function (data) {
                     
                     return '<div class="form-group" role="group" aria-label="Button group">'+
                    '<a type="button" onClick="obtenerDetalleVenta('+data+')" class="btn btn-primary btn-sm">'+ 
                        '<i class="fas fa-eye"></i>'+
                    '</a>'+
                '</div>' 
                 
				}
			}
        ]
			});	
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerDetalleVenta(nId){
    $.ajax({
        url:"/qualitronicshop/ventas/detalle/?nId="+nId
        ,type: 'GET'
        ,dataType: 'html'
        ,success:function(view){
             modalDialog.showModal(view,"Detalle de Venta",eBotones.YES,function(){});
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