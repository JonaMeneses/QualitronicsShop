<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


<div class="container-fluid">
 <h1>Panel Administrativo</h1>
	    <hr>
	<div class="row">
		<div class="col-12">
  
  <div class="container-fluid">
    <br>
    <div class="row">
    <div class = "col-sm-12 col-md-2">
      <div class="card text-center ">
        <div class="card-header">
          Catalogos
        </div>
        <div class="card-body">
         <div class="row">
          <div class="col-md-12">
           <a onClick="obtenerDashboardView()" class="btn btn-outline-primary btn-lg" style="width: 130px; height: 90px;" type="button"><i class="fas fa-users-cog"></i><br>Dashboard</a>
          </div>
        </div>
          <br>
         <div class="row">
          <div class="col-md-12">
           <a  onClick="obtenerUsuariosView()" class="btn btn-outline-primary btn-lg" style="width: 130px; height: 90px;" type="button"><i class="fas fa-users-cog"></i><br>Usuarios</a>
          </div>
        </div>
          <br>
          <div class="row">
          <div class="col-md-12">
            <a onClick="obtenerArticulosView()" class="btn btn-outline-primary btn-lg" style="width: 130px; height: 90px;" type="button"><i class="fas fa-laptop"></i><br>Articulos</a>
          </div>
        </div>
          <br>
          <div class="row">
           <div class="col-md-12">
            <button class="btn btn-outline-primary btn-lg" style="width: 130px; height: 90px;" type="button"><i class="fas fa-sitemap"></i><br>Categorias</button>
           </div>
         </div>
        </div>
      </div>
      </div>
      <div class="col-md-1"><a class="btn btn-outline-primary" id="btnNuevoRegistro">Nuevo registro</a></div>
      <div id="adminContainer" class=" col-sm-12 col-md-9">
    	</div>
    </div>
  </div>
		</div>
	</div>
</div>

<c:url var="script" value="/content/web/js/admin/index.js" />
<script src="${script}"></script>
