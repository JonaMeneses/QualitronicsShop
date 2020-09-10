<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>  


  <div class="container" ng-app="venta">
    <h1>Ventas</h1>
    <br>
  <table class="table table-striped table-bordered" id="dataTableVentas">
      <thead class="thead-default">
      <tr>
          <th>Folio</th>
          <th>Articulos</th>
          <th>Total</th>
          <th>Fecha Venta</th>
          <th>Usuario</th>
          <th>Detalle</th>
      </tr>
         </thead>
      <tbody>
          
 	</tbody>
  </table>
</div>
<c:url var="script" value="/content/web/js/ventas/index.js" />
<script src="${script}"></script>
       