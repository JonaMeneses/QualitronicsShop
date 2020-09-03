 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <c:url  var="estilo"  value="/content/web/css/articulos/index.css" />
   <link href="${estilo}"  rel="stylesheet">

<div class="container-fluid">
	  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
	    <ol class="carousel-indicators">
	      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
	      <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
	      <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
	    </ol>
	    <div class="carousel-inner">
	      <div class="carousel-item active">
	      		 <c:url value="/content/img/celular2.jpg" var="carrousel1" />
	            <img src="${carrousel1}" class="d-block w-100"  alt="..." style="height:100%">
	            <div class="carousel-caption d-none d-md-block">
	            <h5>La mejor calidad al mejor precio</h5>
	            <p>Ven y checa nuestros precios, tenemos las mejores promociones</p>
	            </div>
	      </div>
	      <div class="carousel-item">
	            <c:url value="/content/img/carrousel2.jpg" var="carrousel2" />
	            <img src="${carrousel2}" class="d-block w-100"  alt="..." >
	            <div class="carousel-caption d-none d-md-block">
	            <h5>La mejor calidad al mejor precio</h5>
	            <p>Ven y checa nuestros precios, tenemos las mejores promociones</p>
	            </div>
	        </div>
	         <div class="carousel-item">
	            <c:url value="/content/img/carrousel3.jpg" var="carrousel3" />
	            <img src="${carrousel3}" class="d-block w-100"  alt="..." style="height:100%">
	             <div class="carousel-caption d-none d-md-block">
	            <h5>La mejor calidad al mejor precio</h5>
	            <p>Ven y checa nuestros precios, tenemos las mejores promociones</p>
	            </div>
	        </div>
	      </div>
	     
	      </div>	
	   
	    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
	      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
	      <span class="carousel-control-next-icon" aria-hidden="true"></span>
	      <span class="sr-only">Next</span>
	    </a>
	 
	<div class="container-fluid">
	   <c:set var="contador" value="${0}" />
	     <c:forEach var="articulo" items="${articulos}">
	     <c:if test="${contador == 4 }">
	      <c:set var="contador" value="0" />
	     	</div>
	     </c:if>
	     <c:if test="${contador == 0 }">
	     <div class="row">   <!-- se agrega nuevo row en caso de que ya existan 4 items -->  
	     </c:if>	 
	        <div class="col-md-3 col-sm-6">
	            <div class="product-grid9">
	                <div class="product-image9">
	                    <a class="detallebtn" onclick="obtenerDetalleView(${articulo.nId})">
	                        <img class="pic-1" src="${articulo.sImgURL1}">
	                        <img class="pic-2" src="${articulo.sImgURL2}">
	                    </a>
	                    <a class="detallebtn" onclick="obtenerDetalleView(${articulo.nId})"><i class="fas fa-search"></i></a>
	                </div>
	                <div class="product-content">
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
							<br>
	                    <h3 class="title"><a href="#">${articulo.sNombre}</a></h3>
	                    <div class="price">${articulo.nPrecio}</div>
	                    <a class="add-to-cart" href="carrito.html">Ver Carrito</a>
	                </div>
	            </div>
	        </div> 
	     <c:if test="${contador == null }">
	     	</div>  <!-- se cierra nuevo row en caso de que ya existan 4 items -->  
	     </c:if>
	        
	        <c:set var="contador" value="${contador+1}" />
	        </c:forEach>
	 
	</div> <!-- cierre de container fluid  -->  	
	
	</div>
	<hr>

<c:url var="scriptIndex" value="/content/web/js/articulos/index.js" />
<script src="${scriptIndex}"></script>