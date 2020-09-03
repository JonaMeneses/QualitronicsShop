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

$(document).ready(function () {
    
});

