
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div class="card text-center">
        <div class="card-header">
          Estadistica
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-3">
              <button class="btn btn-outline-success btn-lg"  onClick="obtenerVentasView()"  style="width: 150px; height: 150px;"
              type="button"><i class="fas fa-money-bill-alt"></i><br>Ventas totales: <p id="pTotal">0</p></button>
            </div>
            <div class="col-md-3">
              <button class="btn btn-outline-primary btn-lg"  onClick="obtenerVentasView()" style="width: 150px; height: 150px;"
               type="button"><i class="fas fa-money-bill-alt"></i><br>Ventas de la semana: <p id="pTotalSemana">0</p></button>
             </div>
             <div class="col-md-3">
              <button class="btn btn-outline-primary btn-lg" onClick="obtenerVentasView()" style="width: 150px; height: 150px;"
               type="button"><i class="fas fa-money-bill-alt"></i><br>Ventas del mes: <p id="pTotalMes">0</p></button>
             </div>
             <div class="col-md-3">  
              <button class="btn btn-outline-primary btn-lg" onClick="obtenerVentasView()" style="width: 150px; height: 150px;"
              type="button"><i class="fas fa-money-bill-alt"></i><br>Ventas del año: <p id="pTotalAño">0</p></button>
            </div>
          </div>
              <br>
        </div>
          <br>
    	</div>
    	
    	<c:url var="script" value="/content/web/js/admin/dashboard.js" />
<script src="${script}"></script>
    	