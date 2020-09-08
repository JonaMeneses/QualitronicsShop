<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html>
<html>
<head>
    <c:url  var="estilo"  value="/content/web/css/detalle.css" />
   <link href="${estilo}"  rel="stylesheet">     
<title>Insert title here</title>
</head>
<body>
<div class="container" id="${articulo.nId}">
	<div class="row">
		<div class="col-12">
	        <div class="row pb-0">
	        	<div class="col-md-6">
					<div id="carouselExampleFade" class="carousel slide carousel-fade" style="height:400px" data-ride="carousel">
					  <div class="carousel-inner" style="height:100%">
					    <div class="carousel-item active">
					      <img class="img-fluid" src="${articulo.sImgURL1}" alt="...">
					    </div>
					    <div class="carousel-item">
					      <img class="img-fluid" src="${articulo.sImgURL2}" alt="...">
					    </div>
					  </div>
					  <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>
				</div>
	        	<div class="col-md-6">
	        		<div class="product-dtl">
        				<div class="product-info">
		        			<div class="product-name">${articulo.sNombre}</div>
		        			<div class="reviews-counter">
								<div class="rate">
								    <input type="radio" id="star5" name="rate" value="5" checked />
								    <label for="star5" title="text">5 stars</label>
								    <input type="radio" id="star4" name="rate" value="4" checked />
								    <label for="star4" title="text">4 stars</label>
								    <input type="radio" id="star3" name="rate" value="3" checked />
								    <label for="star3" title="text">3 stars</label>
								    <input type="radio" id="star2" name="rate" value="2" />
								    <label for="star2" title="text">2 stars</label>
								    <input type="radio" id="star1" name="rate" value="1" />
								    <label for="star1" title="text">1 star</label>
								  </div>
							</div>
		        			<div class="product-price-discount"><span>$ ${articulo.nPrecio}</span></div>
		        		</div>
	        			<div class="product-count">
	        				<label for="size">Cantidad</label>
	        				<form class="display-flex ">
							  <input type="number" class="form-control" id="cantidadArticulos" value="1" name="nCantidad">
							</form>
							<button onClick="agregarArticuloCarrito(${articulo.nId})" class="round-black-btn">Agregar al carrito</button>
	        			</div>
	        		</div>
	        	</div>
	        </div>
	        <div class="row">
	        <div class="product-info-tabs">
		        <ul class="nav nav-tabs" id="myTab" role="tablist">
				  	<li class="nav-item">
				    	<a class="nav-link active" id="description-tab" data-toggle="tab" href="#descripcion" role="tab" aria-controls="descripcion" aria-selected="true">Descripcion</a>
				  	</li>
				  	<li class="nav-item" >
				    	<a class="nav-link" id="review-tab" data-toggle="tab" href="#caracteristica" role="tab" aria-controls="caracteristica" aria-selected="false">Caracteristicas</a>
				  	</li>
				</ul>
				<div class="tab-content" id="myTabContent">
				  	<div class="tab-pane fade show active" id="descripcion" role="tabpanel" aria-labelledby="description-tab">
				  		${articulo.sDescripcion}
				  	</div>
				  	<div class="tab-pane fade" id="caracteristica" role="tabpanel" aria-labelledby="review-tab">
				  		${articulo.sCaracteristica}
				  	</div>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

<c:url var="scriptDetalle" value="/content/web/js/articulos/detalle.js" />
<script src="${scriptDetalle}"></script>