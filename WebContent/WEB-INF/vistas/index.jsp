	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<html>
<head>
 <c:url var="bootstrap" value="/content/css/bootstrap.css" />
	<link href="${bootstrap}" rel="stylesheet">
	 <c:url var="fontAwesome" value="/content/fontAwesome/css/all.css" />
	<link href="${fontAwesome}" rel="stylesheet">
   
<link href="" rel="stylesheet">
<meta charset="UTF-8">
<title>QUALITRONICS</title>
</head>
<body>

	
<div class="row">
	<div class="col-12">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
	    <div class="container">
	      <a href="" title="Bootstrap" class="navbar-brand">
	          <c:url value="/content/img/qualitronicsNav.png" var="imgNav" />
			<img src="${imgNav}" style="width: 120px; height: 45px;" class="store-image" alt="Bootstrap" />
	      </a>
	      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarContainer" aria-controls="navbarContainer" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse justify-content-end" id="navbarContainer">
	        <form id="search_mini_form2" class="d-lg-none d-md-block">
	          <div class="input-group mb-3">
	            <input type="text" id="txtFiltroMobile" value="" name="q" class="form-control form-control-sm" onFocus="javascript:this.value=''" placeholder="Buscar productos" />
	            <button id="btnBuscarCatalogoMobile" class="btn btn-outline-secondary"><i class="fas fa-search"></i></button>
	          </div>
	        </form>
	        <ul id="navbarContainerMobile" class="navbar-nav d-lg-none">
	            <li class="nav-item">
	            <c:url var="index" value="/" />
	                <a href="/"  title="Inicio" class="level-1 trsn nav-link" >Inicio</a>
	                </li> 
	                <li class="nav-item  ">
	                <a   title="Techno" class="level-1 trsn nav-link" >Desktop</a>
	                </li>
	                 <li class="nav-item">
	                <a  title="About Us" class="level-1 trsn nav-link" >Celulares</a>
	                </li>
	                 <li class="nav-item  ">
	                <a   title="Blog" class="level-1 trsn nav-link" >Laptop</a>
	                </li>
	                <li class="nav-item  ">
	                <a  title="Contact" class="level-1 trsn nav-link" >Gamer</a>
	                </li>  
	                <li class="nav-item  ">
	                <a   title="Contact" class="level-1 trsn nav-link" >ADMIN</a>
	                </li>      
	        </ul>
	        <ul class="nav navbar-nav float-right nav-top"> 
	          <li >
	            <a id="cart-link" href="carrito.html" class="trsn nav-link" title="Ver/Editar Carro">
	              <i class="fas fa-shopping-cart"></i>
	              <span id="nav-bar-cart"><span class="cart-size">0</span> Producto(s) | $0</span>
	            </a>
	          </li>
	          <li >
	            <a href="login.html" id="login-link" class="trsn nav-link" title="Ingresar aBootstrap">
	              <i class="fas fa-user"></i>
	              <span class="customer-name">
	                Ingresar
	              </span>
	            </a>
	          </li>          
	        </ul>
	        <form id="search_mini_form" class="navbar-form float-right form-inline d-none d-lg-flex">
	          <input type="text" id="txtFiltro" value="" name="q" class="form-control form-control-sm" onFocus="javascript:this.value=''" placeholder="Buscar productos" />
	          <button id="btnBuscarCatalogo" class="btn btn-secondary btn-sm"><i class="fas fa-search"></i></button>
	        </form>
	        <ul class="social list-inline d-lg-none text-center">
	        </ul>
	      </div>
	    </div>
	  </nav>
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark d-none d-lg-block">
	    <div class="container">
	      <div class="collapse navbar-collapse" id="navbarsContainer-2">
	        <ul class="navbar-nav mr-auto">
	            <li class="nav-item  ">
	                <a href="/qualitronicshop"  title="Inicio" class="level-1 trsn nav-link" >Inicio</a>
	                </li> 
	                <li class="nav-item  ">
	                <a onClick="obtenerListadoArticulosView(1)"  title="Techno" class="level-1 trsn nav-link" >Desktop</a>
	                </li>
	                 <li class="nav-item  ">
	                <a onClick="obtenerListadoArticulosView(2)" title="About Us" class="level-1 trsn nav-link" >Celulares</a>
	                </li>
	                 <li class="nav-item  ">
	                <a onClick="obtenerListadoArticulosView(3)"  title="Blog" class="level-1 trsn nav-link" >Laptop</a>
	                </li>
	                <li class="nav-item  ">
	                <a href="#"  title="Contact" class="level-1 trsn nav-link" >Gamer</a>
	                </li>  
	                <li class="nav-item  ">
	                <a  title="Contact" onClick="obtenerAdminView()" class="level-1 trsn nav-link" >ADMIN</a>
	                </li>      
	        </ul>
	      </div>
	    </div>
	  </nav>
	</div>
</div>
<div id="contentPage">


</div>
	<div class="modal fade" tabindex="-1" id="ModalDetalle" role="dialog">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="ModalTitulo">Modal title</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body" id="ModalDetalleBody">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade" tabindex="-1" id="ModalCarrito" role="dialog">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h3 class="modal-title" id="ModalCarritoTitulo">Modal title</h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body" id="ModalCarritoBody">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div id="modalDialogContainer"></div>
</body>
 <c:url var="jquery" value="/content/js/jquery.js" />
<script src="${jquery}"></script>
<c:url var="fonwAwesomeJs" value="/content/fontAwesome/js/all.js" />
<script src="${fonwAwesomeJs}"></script>
 <c:url var="popper" value="/content/js/popper.js" />
<script src="${popper}"></script>
 <c:url var="bootstrapjs" value="/content/js/bootstrap.js" />
<script src="${bootstrapjs}"></script>
<c:url var="scriptIndex" value="/content/web/js/index.js" />
<script src="${scriptIndex}"></script>
<c:url var="jsDialog" value="/content/web/js/modalDialog.js" />
<script src="${jsDialog}"></script>

</html>