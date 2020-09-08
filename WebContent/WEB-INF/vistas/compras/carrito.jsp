
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div class="container-fluid" >
    <div class="row" >
        <div class="col-sm-12 col-md-12">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">Total</th>
                    </tr>
                </thead>	
                <tbody>
               
    
                 <c:forEach var="articulo" items="${sessionScope.compra.articulos}">
                     <tr >
                        <td class="col-sm-12 col-md-12">
	                        <div class="media">
	                            <a class="thumbnail pull-left" href="#"><img class="media-object" src="${articulo.sImgURL1}" style="width: 72px; height: 72px;"> </a>
	                            <div class="media-body">
	                                <h4 class="media-heading"><a href="#">${articulo.sNombre}</a></h4>
	                                <h5 class="media-heading"><a href="#">${articulo.sMarca}</a></h5>
	                            </div>
	                        </div>
                        </td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <label class="form-control" id="exampleInputEmail1">${articulo.nCantidad} </label>
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>$ ${articulo.nPrecio}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>$ ${articulo.nPrecio * articulo.nCantidad}</strong></td>
                        <td class="col-sm-1 col-md-1">
                           <button type="button" onClick="eliminarArticuloCarrito(${articulo.nId})" class="btn btn-danger" >Borrar</button>
                        </td>
                    </tr>
                  </c:forEach>                   
                </tbody>
            </table>           
        </div>
    </div>
		 <div class="row" >
	        <div class="col-12" >
	        	<a href="facturacion.html" type="button"  class="btn-lg btn-outline-success" style="float: right;">TOTAL: <strong>$${sessionScope.compra.nTotal}</strong></a>
	        </div>
      	 </div>
      	 <br>
        <div class="row" >
	        <div class="col-12">
	        	<c:url var="vistaCheckout" value="compras/checkout" />
	        	<a type="button" href="${vistaCheckout}" class="btn btn-success" style="float: right;"><i class="fas fa-credit-card"></i>Comprar</a>
	        </div>
       </div>
</div>

<c:url var="scriptCarrito" value="/content/web/js/compras/carrito.js" />
<script src="${scriptCarrito}"></script>
	