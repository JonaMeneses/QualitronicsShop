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
				 modalDialog.showModal(data,"Detalle",eBotones.YES,function(){
					location.reload();
				});
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

function mostrarEstrellas(nId,callback){	
var estrellasHtml =  '<input type="radio" id="" name="" value="5" />'+
							    '<label for="" title="text">5 stars</label>'+
							    '<input type="radio" id="" name="" value="4"  />'+
							    '<label for="" title="text">4 stars</label>'+
							    '<input type="radio" id="" name="" value="3"  />'+
							    '<label for="" title="text">3 stars</label>'+
							    '<input type="radio" id="star2" name="" value="2" />'+
							    '<label for="star2" title="text">2 stars</label>'+
							    '<input type="radio" id="" name="" value="1" />'+
							    '<label for="" title="text">1 star</label>'
	$.ajax({
        url:"api/ventas/mostrarEstrellas/"+nId
        ,type: "GET"
        ,success:function(value){
		console.log(value.mensajeRespuesta);
				if(value.mensajeRespuesta >= 1 ){
			estrellasHtml = '<input type="radio" id="" name="" value="5"  />'+
							    '<label for="" title="text">5 stars</label>'+
							    '<input type="radio" id="" name="" value="4"  />'+
							    '<label for="" title="text">4 stars</label>'+
							    '<input type="radio" id="" name="" value="3"  />'+
							    '<label for="" title="text">3 stars</label>'+
							    '<input type="radio" id="star2" name="" value="2" />'+
							    '<label for="star2" title="text">2 stars</label>'+
							    '<input type="radio" id="" name="" value="1" checked/>'+
							    '<label for="" title="text">1 star</label>'
			}
			if(value.mensajeRespuesta> 15){
			estrellasHtml = '<input type="radio" id="" name="" value="5"  />'+
							    '<label for="" title="text">5 stars</label>'+
							    '<input type="radio" id="" name="" value="4"  />'+
							    '<label for="" title="text">4 stars</label>'+
							    '<input type="radio" id="" name="" value="3"  />'+
							    '<label for="" title="text">3 stars</label>'+
							    '<input type="radio" id="star2" name="" value="2" checked/>'+
							    '<label for="star2" title="text">2 stars</label>'+
							    '<input type="radio" id="" name="" value="1" checked/>'+
							    '<label for="" title="text">1 star</label>'
			}
			if(value.mensajeRespuesta > 20 ){
			estrellasHtml = '<input type="radio" id="" name="" value="5"  />'+
							    '<label for="" title="text">5 stars</label>'+
							    '<input type="radio" id="" name="" value="4"  />'+
							    '<label for="" title="text">4 stars</label>'+
							    '<input type="radio" id="" name="" value="3" checked />'+
							    '<label for="" title="text">3 stars</label>'+
							    '<input type="radio" id="star2" name="" value="2" checked/>'+
							    '<label for="star2" title="text">2 stars</label>'+
							    '<input type="radio" id="" name="" value="1"checked />'+
							    '<label for="" title="text">1 star</label>'
			}
			if(value.mensajeRespuesta > 25){
			estrellasHtml = '<input type="radio" id="" name="" value="5"  />'+
							    '<label for="" title="text">5 stars</label>'+
							    '<input type="radio" id="" name="" value="4" checked />'+
							    '<label for="" title="text">4 stars</label>'+
							    '<input type="radio" id="" name="" value="3"  checked/>'+
							    '<label for="" title="text">3 stars</label>'+
							    '<input type="radio" id="star2" name="" value="2" checked />'+
							    '<label for="star2" title="text">2 stars</label>'+
							    '<input type="radio" id="" name="" value="1" checked/>'+
							    '<label for="" title="text">1 star</label>'
			}
			if(value.mensajeRespuesta > 30){
			estrellasHtml = '<input type="radio" id="" name="" value="5" checked />'+
							    '<label for="" title="text">5 stars</label>'+
							    '<input type="radio" id="" name="" value="4" checked />'+
							    '<label for="" title="text">4 stars</label>'+
							    '<input type="radio" id="" name="" value="3" checked />'+
							    '<label for="" title="text">3 stars</label>'+
							    '<input type="radio" id="star2" name="" value="2" checked/>'+
							    '<label for="star2" title="text">2 stars</label>'+
							    '<input type="radio" id="" name="" value="1" checked/>'+
							    '<label for="" title="text">1 star</label>'

			}
			
			callback(estrellasHtml);
			    
        }
        ,error:function(xhr,status){
            console.log( "error en llamada");
            console.log(JSON.stringify(xhr));
        }	
    });
 
}

$(document).ready(function () {
	 $(".estrellas").each(function(){
		let div = $(this);
		let id = $(this).attr("nid");
		mostrarEstrellas(id,function(result){
			console.log("para id ="+id+" result= "+result);
			div.html(result);	
		});
	});
});