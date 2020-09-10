<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

  <div class="container">
    <div class="card">
        <div class="card-header">
          Informacion general
        </div>
        <div class="card-body">
          <div class="row">
       
            <div class="form-group col-md-4">
               <label for="">Folio Venta</label>
               <input type="text" class="form-control" value="${venta.getNId()}"  disabled>  
            </div>
            <div class="form-group col-md-4">
                <label for="">Fecha Venta</label>
                <input class="form-control" value="${venta.getDFechaAlta()} " disabled>  
             </div>
             <div class="form-group col-md-4">
                <label for="">Nombre Usuario</label>
                <input type="text" class="form-control" value="${venta.getUsuario().getSNombre()}" disabled>  
             </div>
        </div>
        </div>
      </div>
    <br>
    <div class="card">
        <div class="card-header">
          Articulos
        </div>
        <div class="card-body">
            <div class="row">
                <table class="table ">
                    <thead class="thead-default">
                    <tr>
                        <th>Articulo</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                    </tr>
                </thead>
                    <tbody>
                     <c:forEach var="articulo" items="${venta.getVentasArticulos()}">
                     <tr>
                          <td>${articulo.getArticulo().getSNnombre()}</td>
                          <td>$${articulo.getNPrecioArticulo()}</td>
                          <td>${articulo.getNCantidad()}</td>
                      </tr>    
                     </c:forEach>               
                </tbody>
  
                </table>
               
            </div>
            
        </div>
        <div class="card-footer text-muted">
            <div class="float-right">
                <h3>Total de la venta: $${venta.getNTotal()}</h3> 
            </div>
          </div>
      </div>
   
</div>




    