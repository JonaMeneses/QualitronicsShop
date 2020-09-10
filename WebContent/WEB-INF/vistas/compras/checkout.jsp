 	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>     

<html >
<head>
 <c:url var="bootstrap" value="/content/css/bootstrap.css" />
	<link href="${bootstrap}" rel="stylesheet">
	 <c:url var="fontAwesome" value="/content/fontAwesome/css/all.css" />
	<link href="${fontAwesome}" rel="stylesheet">
	<c:url var="style" value="/content/web/css/facturacion.css" />
	<link href="${style}" rel="stylesheet">
   
<link href="" rel="stylesheet">
<meta charset="UTF-8">
<title>QUALITRONICS</title>

<style>
body {oveflow-x: hidden }

</style>
</head>
<body >

	
<div class="row" >
	<div class="col-12">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
	    <div class="container-fluid">
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
	            <input type="text" id="txtFiltroMobile"   name="q" class="form-control form-control-sm" onFocus="javascript:this.value=''" placeholder="Buscar productos" />
	            <button id="btnBuscarCatalogoMobile" class="btn btn-outline-secondary"><i class="fas fa-search"></i></button>
	          </div>
	        </form>
	        <ul id="navbarContainerMobile" class="navbar-nav d-lg-none">
	            <li class="nav-item">
	            <c:url var="index" value="/" />
	                <a href="/"  title="Inicio" class="level-1 trsn nav-link" >Inicio</a>
	                </li> 
	               
	        </ul>
	        <ul class="nav navbar-nav float-right nav-top"> 
	        	          <li >
	            <a id="cart-link" onClick="obtenerCarritoView()" class="trsn nav-link" title="Ver/Editar Carro">
	              <i class="fas fa-shopping-cart"></i>
	              <span id="nav-bar-cart"><span class="cart-size">0</span> Producto(s) | $0</span>
	            </a>
	          </li>	          
	        <li >
	          <c:url value="/logout" var="logoutIndex" />
	             <s:authorize access="isAuthenticated()">
	             
					 <a href="${logoutIndex}" id="login-link" class="trsn nav-link" title="Cerrar sesion">
		              <i class="fas fa-user"></i>
		              <span class="customer-name">
		              <s:authentication property="principal.username"/>
		              </span>
		            </a>
	            	</s:authorize>
	            	 <c:url value="/login" var="loginIndex" />
	            <s:authorize access="isAnonymous()">
					 <a href="${loginIndex}" id="login-link" class="trsn nav-link" title="Cerrar sesion">
		              <i class="fas fa-user"></i>
		              <span class="customer-name">
		              	Ingresar
		              </span>
		            </a>
	            	</s:authorize>
	          </li>          
	        </ul>
	       
	        <ul class="social list-inline d-lg-none text-center">
	        </ul>
	      </div>
	    </div>
	  </nav>
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark d-none d-lg-block">
	    <div class="container-fluid">
	      <div class="collapse navbar-collapse" id="navbarsContainer-2">
	        <ul class="navbar-nav mr-auto">
	            <li class="nav-item  ">
	                <a href="/qualitronicshop"  title="Inicio" class="level-1 trsn nav-link" >Inicio</a>
	                </li> 
	        </ul>
	      </div>
	    </div>
	  </nav>
	</div>
</div>
<div id="contentPage">
<div class="container">
	<div class="row" >
		<div class="col-12">
<h1>Pago</h1>
    <hr>
        <form ng-app="miapp" ng-controller="compraController" name="miFormulario" novalidate>	
          <div class="row">
        <div class="col-md-12">
            <!--SHIPPING METHOD-->
            <div class="card">
                <div class="card-header">Address</div>
                <div class="card-body">
                
                    <div class="form-group">
                        <div class="col-md-12">
                            <h4>Domicilio</h4>
                        </div>
                    </div>
                    <div class="form-group" >
                        <div class="col-md-12"><strong>Pais:</strong></div>
                        <div class="col-md-12">
                            <input ng-minlength="3" ng-maxlength="100"  type="text" class="form-control" name="pais" ng-model="compraObj.pais"  required />
                             <div class="text-danger">
	                            <span ng-show="miFormulario.pais.$error.required && miFormulario.pais.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.pais.$error.minlength && miFormulario.pais.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.pais.$error.maxlength && miFormulario.pais.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12 col-xs-12">
                            <strong>Nombre:</strong>
                            <input  ng-minlength="3" ng-maxlength="100" type="text" name="nombre" class="form-control" ng-model="compraObj.nombre" required />
                            <div class="text-danger">
	                            <span ng-show="miFormulario.nombre.$error.required && miFormulario.nombre.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.nombre.$error.minlength && miFormulario.nombre.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.nombre.$error.maxlength && miFormulario.nombre.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                         </div>
                        <div class="col-md-12 col-xs-12">
                            <strong>Apellidos:</strong>
                            <input type="text" required ng-minlength="3" ng-maxlength="100" name="apellidos" class="form-control" ng-model="compraObj.apellidos"   />
                           <div class="text-danger">
	                            <span ng-show="miFormulario.apellidos.$error.required && miFormulario.apellidos.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.apellidos.$error.minlength && miFormulario.apellidos.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.apellidos.$error.maxlength && miFormulario.apellidos.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                        </div>
                    
                    <div class="form-group">
                        <div class="col-md-12"><strong>Domicilio:</strong></div>
                        <div class="col-md-12">
                            <input type="text" required ng-minlength="3" ng-maxlength="100" name="domicilio" class="form-control" ng-model="compraObj.domicilio"   />
                            <div class="text-danger">
	                            <span ng-show="miFormulario.domicilio.$error.required && miFormulario.domicilio.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.domicilio.$error.minlength && miFormulario.domicilio.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.domicilio.$error.maxlength && miFormulario.domicilio.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>ciudad:</strong></div>
                        <div class="col-md-12">
                            <input type="text" required ng-minlength="3" ng-maxlength="100" name="ciudad" class="form-control" ng-model="compraObj.ciudad"   />
                            <div class="text-danger">
	                            <span ng-show="miFormulario.ciudad.$error.required && miFormulario.ciudad.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.ciudad.$error.minlength && miFormulario.ciudad.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.ciudad.$error.maxlength && miFormulario.ciudad.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Estado:</strong></div>
                        <div class="col-md-12">
                            <input type="text" required ng-minlength="3" ng-maxlength="100" name="estado" class="form-control" ng-model="compraObj.estado"   />
                            <div class="text-danger">
	                            <span ng-show="miFormulario.estado.$error.required && miFormulario.estado.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.estado.$error.minlength && miFormulario.estado.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.estado.$error.maxlength && miFormulario.estado.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Codigo Postal:</strong></div>
                        <div class="col-md-12">
                            <input type="text" required ng-minlength="3" ng-maxlength="100" name="cp" class="form-control" ng-model="compraObj.cp"   />
                            <div class="text-danger">
	                            <span ng-show="miFormulario.cp.$error.required && miFormulario.cp.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.cp.$error.minlength && miFormulario.cp.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.cp.$error.maxlength && miFormulario.cp.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Numero telefonico:</strong></div>
                        <div class="col-md-12"><input required ng-minlength="3" ng-maxlength="100" type="text" name="telefono" class="form-control" ng-model="compraObj.telefono"   /></div>
                    	<div class="text-danger">
	                            <span ng-show="miFormulario.telefono.$error.required && miFormulario.telefono.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.telefono.$error.minlength && miFormulario.telefono.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.telefono.$error.maxlength && miFormulario.telefono.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Email :</strong></div>
                        <div class="col-md-12"><input required ng-minlength="3" ng-maxlength="100" type="text" name="email" class="form-control" ng-model="compraObj.email"   /></div>
                   		<div class="text-danger">
	                            <span ng-show="miFormulario.email.$error.required && miFormulario.email.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.email.$error.minlength && miFormulario.email.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.email.$error.maxlength && miFormulario.email.$dirty">El maximo es 100 caracteres</span>
                           	 </div>
                    </div>
                  
                </div>
            </div>
            <hr>
            <!--SHIPPING METHOD END-->
            <!--CREDIT CART PAYMENT-->
            <div class="card">
                <div class="card-header"><span><i class="fas fa-credit-card"></i></span> Pago</div>
                <div class="card-body">
              
                    <div class="form-group">
                        <div class="col-md-12"><strong>Tipo de tarjeta:</strong></div>
                        <div class="col-md-12">
                            <select id="CreditCardType"  name="tipoTarjeta" ng-model="compraObj.tipoTarjeta" class="form-control" required>
                                <option value="5">Visa</option>
                                <option value="6">MasterCard</option>
                                <option value="7">American Express</option>
                                <option value="8">Discover</option>
                            </select>
                        </div>
                        <div class="text-danger">
	                            <span ng-show="miFormulario.tipoTarjeta.$error.required && miFormulario.tipoTarjeta.$dirty">El tipo de tarjeta es requerido</span>
                           	 </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="col-md-12"><strong>Numero de tarjeta:</strong></div>
                        <div class="col-md-12"><input required ng-minlength="16" ng-maxlength="16" name="numeroTarjeta"  type="text" class="form-control" ng-model="compraObj.numeroTarjeta"  /></div>
						<div class="text-danger">
	                            <span ng-show="miFormulario.numeroTarjeta.$error.required && miFormulario.numeroTarjeta.$dirty">El pais es requerido</span>
	                           	<span ng-show="miFormulario.numeroTarjeta.$error.minlength && miFormulario.numeroTarjeta.$dirty">El minimo es 16 caracteres</span>
	                           	<span ng-show="miFormulario.numeroTarjeta.$error.maxlength && miFormulario.emnumeroTarjetaail.$dirty">El maximo es 16 caracteres</span>
                           	 </div>                    
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>CVV:</strong></div>
                        <div class="col-md-12"><input required ng-minlength="3" ng-maxlength="3" name="cvv" type="text" class="form-control" ng-model="compraObj.cvv"/></div>
                    <div class="text-danger">
	                            <span ng-show="miFormulario.cvv.$error.required && miFormulario.cvv.$dirty">El codigo es requerido</span>
	                           	<span ng-show="miFormulario.cvv.$error.minlength && miFormulario.cvv.$dirty">El minimo es 3 caracteres</span>
	                           	<span ng-show="miFormulario.cvv.$error.maxlength && miFormulario.cvv.$dirty">El maximo es 3 caracteres</span>
                           	 </div>
                    </div>
                    
                      <div class="form-group">
                        <div class="col-md-12"><strong>Mes Expiracion:</strong></div>
                        <div class="col-md-12">
                            <select id="mes"  name="mesExpiracion" ng-model="compraObj.mesExpiracion" class="form-control" required>
                            	<option selected value="">Mes</option>
                                <option value="01">01</option>
                                <option value="02">02</option>
                                <option value="03">03</option>
                                <option value="04">04</option>
                                <option value="05">05</option>
                                <option value="06">06</option>
                                <option value="07">07</option>
                                <option value="08">08</option>
                                <option value="09">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                        </div>
                        <div class="text-danger">
	                            <span ng-show="miFormulario.mesExpiracion.$error.required && miFormulario.mesExpiracion.$dirty">El tipo de tarjeta es requerido</span>
                           	 </div>
                    </div>
                    
                     <div class="form-group">
                        <div class="col-md-12"><strong>Año Expiracion:</strong></div>
                        <div class="col-md-12">
                            <select id="año"  name="anioExpiracion" ng-model="compraObj.anioExpiracion" class="form-control" required>
                           		<option selected value="">año</option>
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                                <option value="2022">2022</option>
                                <option value="2023">2023</option>
                                <option value="2024">2024</option>
                                <option value="2025">2025</option>
                            </select>
                        </div>
                        <div class="text-danger">
                         <span ng-show="miFormulario.anioExpiracion.$error.required && miFormulario.anioExpiracion.$dirty">El tipo de tarjeta es requerido</span>
                       	 </div>
                    </div>
                                        
                   <input ng-disabled="miFormulario.$pristine || miFormulario.$invalid" type="button" ng-click='comprar("<s:authentication property="principal.username"/>")' value="Realizar Compra" class="btn btn-outline-primary">
                      
                    </div>
                   
            
                </div>
            </div>
           
            <!--CREDIT CART PAYMENT END-->
            </div>
            </div>
        </div>
        </form>
      </div>

	   <c:url var="inicio" value="/" />
<a href="${inicio}" type="" id="btnRedireccion" hidden = true></a>
	
	
	<div id="modalContainer"></div>
	<div  id="modalCarrito"></div>
	<div id="modalDialogContainer"></div>
	<div id="toastDialog"></div>
</body>
	   <c:url var="angularjs" value="/content/js/angular.min.js"></c:url>
	   <script type="text/javascript" src="${angularjs}" ></script>
       <c:url var="comprajs" value="/content/app/compra.js"></c:url>
       <script type="text/javascript" src="${comprajs}"></script>
       <c:url var="Service" value="/content/app/service/compraService.js"></c:url>
       <script type="text/javascript" src="${Service}" ></script>
       <c:url var="Controller" value="/content/app/controller/compraController.js"></c:url>  
       <script type="text/javascript" src="${Controller}" ></script>
 <c:url var="jquery" value="/content/js/jquery.js" />
<script src="${jquery}"></script>
<c:url var="fonwAwesomeJs" value="/content/fontAwesome/js/all.js" />
<script src="${fonwAwesomeJs}"></script>
 <c:url var="popper" value="/content/js/popper.js" />
<script src="${popper}"></script>
 <c:url var="bootstrapjs" value="/content/js/bootstrap.js" />
<script src="${bootstrapjs}"></script>
<c:url var="scriptFacturacion" value="/content/web/js/compras/facturacion.js" />
<script src="${scriptFacturacion}"></script>
<c:url var="jsDialog" value="/content/web/js/modalDialog.js" />
<script src="${jsDialog}"></script>
<script type="text/javascript">
var $body = $(document);
$body.bind('scroll', function() {
    // "Desactivar" el scroll horizontal
    if ($body.scrollLeft() !== 0) {
        $body.scrollLeft(0);
    }
});
</script>

</html>
