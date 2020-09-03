<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div class="container">
	<div class="row">
		<div class="col-12">
  <h1>Usuarios</h1>
    <br>
     <c:if test="${param.done != null }">
			<div class="alert alert-success">Guardado correctamente</div>
		</c:if>
		<c:if test="${param.delete != null }">
			<div class="alert alert-success">Borrado correctamente</div>
		</c:if>
  <table class="table" id="tablaUsr">
      <thead class="thead-default">
      <tr>
          <th>Email</th>
          <th>Nombre</th>
          <th>Edad</th>
          <th>Rol</th>
          <th>Acciones</th>
      </tr>
      </thead>
      <tbody>
    </tbody>
  </table>
		</div>
	</div>
</div>
<c:url var="scriptIndex" value="/content/web/js/usuarios/index.js" />
<script src="${scriptIndex}"></script>