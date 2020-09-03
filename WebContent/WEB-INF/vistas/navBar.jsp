
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

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
	        <form id="search_mini_form" class="d-lg-none d-md-block" method="get" action="/mx/search">
	          <div class="input-group mb-3">
	            <input type="text" value="" name="q" class="form-control form-control-sm" onFocus="javascript:this.value=''" placeholder="Buscar productos" />
	            <button type="submit" class="btn btn-outline-secondary"><i class="fas fa-search"></i></button>
	          </div>
	        </form>
	        <ul id="navbarContainerMobile" class="navbar-nav d-lg-none">
	            <li class="nav-item  ">
	                <a href="index.html"  title="Inicio" class="level-1 trsn nav-link" >Inicio</a>
	                </li> 
	                <li class="nav-item  ">
	                <a href=""  title="Techno" class="level-1 trsn nav-link" >Desktop</a>
	                </li>
	                 <li class="nav-item  ">
	                <a href=""  title="About Us" class="level-1 trsn nav-link" >Celulares</a>
	                </li>
	                 <li class="nav-item  ">
	                <a href="/mx/blog"  title="Blog" class="level-1 trsn nav-link" >Laptop</a>
	                </li>
	                <li class="nav-item  ">
	                <a href="/mx/contact"  title="Contact" class="level-1 trsn nav-link" >Gamer</a>
	                </li>  
	                <li class="nav-item  ">
	                <a href="dashboard.html"  title="Contact" class="level-1 trsn nav-link" >ADMIN</a>
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
	        <form id="search_mini_form" class="navbar-form float-right form-inline d-none d-lg-flex" method="get" action="/mx/search">
	          <input type="text" value="" name="q" class="form-control form-control-sm" onFocus="javascript:this.value=''" placeholder="Buscar productos" />
	          <button type="submit" class="btn btn-secondary btn-sm"><i class="fas fa-search"></i></button>
	        </form>
	        <ul class="social list-inline d-lg-none text-center">
	        </ul>
	      </div>
	    </div>
	  </nav>
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark d-none d-lg-block">