function obtenerVentasTotales(){
    $.ajax({
        url:"api/ventas/total"
        ,type: 'GET'    
        ,dataType: 'json'
        ,success:function(data){
			$("#pTotal").html(data.mensajeRespuesta);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}

function obtenerVentasTotalesSemana(){
    $.ajax({
        url:"api/ventas/totalSemana"
        ,type: 'GET' 
        ,dataType: 'json'
        ,success:function(data){
			$("#pTotalSemana").html(data.mensajeRespuesta);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}
function obtenerVentasTotalesMes(){
    $.ajax({
        url:"api/ventas/totalMes"
        ,type: 'GET' 
        ,dataType: 'json'
        ,success:function(data){
			$("#pTotalMes").html(data.mensajeRespuesta);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}
function obtenerVentasTotalesAño(){
    $.ajax({
        url:"api/ventas/totalAño"
        ,type: 'GET' 
        ,dataType: 'json'
        ,success:function(data){
			$("#pTotalAño").html(data.mensajeRespuesta);
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }
    });
}


$(document).ready(function () {
	
	obtenerVentasTotales();
	obtenerVentasTotalesSemana();
	obtenerVentasTotalesMes();
	obtenerVentasTotalesAño();
	
});