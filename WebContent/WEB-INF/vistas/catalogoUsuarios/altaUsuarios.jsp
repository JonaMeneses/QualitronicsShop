<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
	<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>  

<div class="container-fluid">
	    <h1>Usuarios</h1>
	    <hr>
	    <c:if test="${detalle != null }">
			<input id="detalle" value="1" hidden>
		</c:if>
		<form:form  method="post" id="formulario" modelAttribute="usuario">
		<form>
		<form:input id="nId" type="hidden" path="nId" />
		    <div class="form-row">
		      <div class="form-group col-md-6">
		        <label for="txtEmail">Email</label>
		        <form:input path="sEmail" type="text"  class="form-control" />
				<form:errors path="sEmail" cssClass="text-danger"></form:errors>
		      </div>
		      <div class="form-group col-md-6">
		        <label for="txtContraseña">Password</label>
		         <form:input path="sContraseña" type="password"  class="form-control" />
				<form:errors path="sContraseña" cssClass="text-danger"></form:errors>
		      </div>
		    </div>		    
		    <div class="form-row">
		      <div class="form-group col-md-6">
		        <label for="txtNombre">Nombre</label>
		         <form:input path="sNombre" type="text"  class="form-control" />
				<form:errors path="sNombre" cssClass="text-danger"></form:errors>
		      </div>
		      <div class="form-group col-md-6">
		        <label for="sPaterno">Apellido Paterno</label>
		         <form:input path="sPaterno" type="text"  class="form-control" />
				<form:errors path="sPaterno" cssClass="text-danger"></form:errors>
		      </div>
		     </div>
		      <div class="form-row">
		      <div class="form-group col-md-4">
		        <label for="sMaterno">Apellido Materno</label>
		         <form:input path="sMaterno" type="text"  class="form-control" />
				<form:errors path="sMaterno" cssClass="text-danger"></form:errors>
		      </div>
		      <div class="form-group col-md-3">
		        <label for="nEdad">Edad</label>
		         <form:input path="nEdad" type="text"  class="form-control" />
				<form:errors path="nEdad" cssClass="text-danger"></form:errors>
		      </div>
		      <div class="form-group col-md-4">
		        <label for="inputState">Rol</label>
		         <form:select path="nIdRol"  class="form-control">
			       		<form:option value="1" label="Usuario" />
       					<form:option value="2" label="Admin" />
			       </form:select>
					<form:errors path="nIdRol" cssClass="text-danger"></form:errors>
		      </div>
		      <div class="form-group col-md-1">
		      
		      	<label class="form-check-label" for="gridCheck">
		          Activo
		        </label>
		        <form:checkbox path="bActivo" class="form-control" />
		    </div>
		    </div>		    
		  </form>
		   </form:form>
		    <button onClick="guardar()" id="btnGuardar" class="btn btn-primary">Guardar</button> 
		</div>

<c:url var="scriptForm" value="/content/web/js/usuarios/formulario.js" />
<script src="${scriptForm}"></script>