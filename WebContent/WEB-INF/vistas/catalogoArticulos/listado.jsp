<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div class="row">
		<div class="col-12">
<h1>Articulos</h1>
    <br>
    <c:if test="${param.done != null }">
			<div class="alert alert-success">Guardado correctamente</div>
		</c:if>
		<c:if test="${param.delete != null }">
			<div class="alert alert-success">Borrado correctamente</div>
		</c:if>
			
  <table class="table ">
      <thead class="thead-default">
      <tr>
          <th></th>
          <th>Articulo</th>
          <th>Precio</th>
          <th>Categoria</th>
      </tr>
       </thead>
      <tbody>
        <c:forEach var="articulo" items="${articulos}">
						<tr>
							<td><c:out value="${articulo.nId}" /></td>
							<td><c:out value="${articulo.sNombre}" /></td>
							<td><c:out value="${articulo.nPrecio}" /></td>
							<td><c:out value="${articulo.nIdCategoria}" /></td>
							<td>
								<c:url var="detalle" value="/articulos/obtenerporid">
									<c:param name="nId" value="${articulo.nId}"></c:param>
								</c:url>
								<a onClick="obtenerFormularioDetalleView(${articulo.nId})" title="Detalle" class="btn btn-primary"><i class="fas fa-search"></i></a> 
								<c:url var="editar" value="/articulos/actualiza">
									<c:param name="nId" value="${articulo.nId}"></c:param>
									
								</c:url>
								<a onClick="obtenerFormularioPorIdView(${articulo.nId})" title="Editar" class="btn btn-success"><i class="fas fa-pencil-alt"></i></a>
								<c:url var="borrar" value="/articulos/elimina">
									<c:param name="nId" value="${articulo.nId}"></c:param>
								</c:url>
								<a onClick="eliminar(${articulo.nId})" class="btn btn-danger" title="Eliminar" ><i class="fas fa-trash-alt"></i></a>								
							</td>
						</tr>
					</c:forEach>
				 </tbody>	
 			 </table>
		</div>
	</div>
</div>

<c:url var="scriptFormArticulos" value="/content/web/js/articulos/listado.js" />
<script src="${scriptFormArticulos}"></script>