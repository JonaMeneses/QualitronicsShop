 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <c:url  var="estilo"  value="/content/web/css/articulos/index.css" />
 
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
   <link href="${estilo}"  rel="stylesheet">


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
								<div class ="rate estrellas" nid="${articulo.nId}">
								   
								  </div>
							</div>
							<br>
	                    <h3 class="title"><a href="#">${articulo.sNombre}</a></h3>
	                    <c:if test="${articulo.nPromocion > 0}">
	                    <div class="price"><fmt:formatNumber pattern="MXN $#,###.##;MXN $-#,###.##" value = "${articulo.nPrecio}" type = "currency"/></div>
	                     <div class="price text-warning"><i class="fas fa-tag text-warning">
	                     </i><fmt:formatNumber value = "${articulo.nPromocion * 100}" type = "number"/>% Descuento</div>
	                    <div class="price text-danger">Ahorra <fmt:formatNumber pattern="MXN $#,###.##;MXN $-#,###.##" value = "${articulo.nPrecio * articulo.nPromocion}" type = "currency"/></div>
	                    </c:if>
	                     <c:if test="${articulo.nPromocion <= 0}">
	                    <div class="price"><fmt:formatNumber pattern="MXN $#,###.##;MXN $-#,###.##" value = "${articulo.nPrecio}" type = "currency"/></div>
	                    </c:if>
	                    
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
	
	
	<hr>

<c:url var="scriptIndex" value="/content/web/js/articulos/index.js" />
<script src="${scriptIndex}"></script>
 <c:url  var="estilo"  value="/content/web/css/articulos/index.css" />
 <link href="${estilo}"  rel="stylesheet">