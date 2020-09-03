<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>  

<div class="container-fluid">
	<div class="row">
		<div class="col-12">
		<c:if test="${detalle != null }">
			<input id="detalle" value="1" hidden>
		</c:if>
		<form:form  method="post" id="formulario" modelAttribute="articulo">
		  <form>
		      <h1>Articulos</h1>
		      <hr>
		    
				<form:input id="nId" type="hidden" path="nId" />
		    <div class="form-row">
		      <div class="form-group col-md-6">
		        <label for="sNombre">Articulo</label>
		        <form:input path="sNombre" type="text"  class="form-control" />
				<form:errors path="sNombre" cssClass="text-danger"></form:errors>
		      </div>
		      <div class="form-group col-md-6">
		        <label for="inputPassword4">Precio</label>
		         <form:input path="nPrecio" type="number"  class="form-control" />
				<form:errors path="nPrecio" cssClass="text-danger"></form:errors>
		      </div>
		    </div>
		    <div class="form-row">
		      <div class="form-group col-md-6">
		        <label for="sNombre">Descripcion</label>
		        <form:input path="sDescripcion" type="text" class="form-control" />
				<form:errors path="sDescripcion" cssClass="text-danger"></form:errors>
		      </div>
		      <div class="form-group col-md-6">
		        <label for="inputPassword4">Caracteristicas</label>
		         <form:input path="sCaracteristica" type="text" class="form-control" />
				<form:errors path="sCaracteristica" cssClass="text-danger"></form:errors>
		      </div>
		    </div>
		     <div class="form-row">
		      <div class="form-group col-md-6">
		        <label for="sNombre">Marca</label>
		        <form:input path="sMarca" type="text" class="form-control" />
				<form:errors path="sMarca" cssClass="text-danger"></form:errors>
		      </div>
		      <div class="form-group col-md-6">
		        <label for="inputPassword4">Año</label>
		         <form:input path="nAño" type="number" class="form-control" />
				<form:errors path="nAño" cssClass="text-danger"></form:errors>
		      </div>
		    </div>
		    <div class="form-row">
		        <div class="form-group col-md-6">
			        <label for="inputPassword4">Fotografia 1</label>
			         <form:input path="sImgURL1" type="text" class="form-control" />
					<form:errors path="sImgURL1" cssClass="text-danger"></form:errors>
		     	 </div>
		          <div class="form-group col-md-6">
			        <label for="inputPassword4">Fotografia 2</label>
			         <form:input path="sImgURL2" type="text" class="form-control" />
					<form:errors path="sImgURL2" cssClass="text-danger"></form:errors>
		     	 </div>
		      <div class="form-group col-md-4">
		      </div>
		    </div>
		      <div class="form-row">
		        <div class="form-group col-md-6">
			        <label for="inputPassword4">Tags de busqueda</label>
			         <form:input path="sTag" type="text" class="form-control" />
					<form:errors path="sTag" cssClass="text-danger"></form:errors>
		     	 </div>
		          <div class="form-group col-md-6">
			       <label for="inputState">Categoria</label>
			       <form:select path="nIdCategoria"  class="form-control">
			       		<form:option value="1" label="Desktop" />
       					<form:option value="2" label="Laptop" />
       					<form:option value="3" label="Celulares" />
			       </form:select>
					<form:errors path="nIdCategoria" cssClass="text-danger"></form:errors>
		     	 </div>
		      <div class="form-group col-md-4">
		      </div>
		    </div>
		    
		  </form>
		  </form:form>
		  <button onClick="guardar()" id="btnGuardar" class="btn btn-primary">Guardar</button> 
		</div>
	</div>
</div>

<c:url var="scriptFormArticulos" value="/content/web/js/articulos/formulario.js" />
<script src="${scriptFormArticulos}"></script>
