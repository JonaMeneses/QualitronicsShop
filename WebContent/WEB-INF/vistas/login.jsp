<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
 <c:url var="bootstrap" value="/content/css/bootstrap.css" />
	<link href="${bootstrap}" rel="stylesheet">
    <c:url  var="estilo"  value="/content/web/css/login.css" />
   <link href="${estilo}"  rel="stylesheet">
<meta charset="UTF-8">
<title>Login</title>
<c:url var="fondoLogin" value="/content/img/fondologin.jpg" />
<style>
body {
background-image: url(${fondoLogin});
background-attachment: fixed;
background-repeat: no-repeat;

}
</style>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-12">
<div class="wrapper fadeInDown">
  <div id="formContent" style="opacity: 0.92;">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
     <c:url value="/content/img/qualitronics.png" var="icono" />
      <img src="${icono}" id="icon" style="width: 150px; height: 150px;" id="icon" alt="User Icon" />
    </div>
<c:url value="/login" var="loginUrl"/>
    <!-- Login Form -->
    <form action="${loginUrl}" method="post">
    <c:if test="${param.error != null}">
    <div class="alert alert-danger">Username y password incorrectos, intentalo nuevamente.</div>
</c:if>
    <div class="">
	      <input type="text" id="login" class="fadeIn second" name="username" placeholder="Usuario">
	      <input type="password" id="password" class="fadeIn third" name="password" placeholder="contraseña">
	      <input type="submit" class="fadeIn fourth" value="Entrar">
      </div>
    </form>
    

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" onClick="obtenerFormularioUsuarioView()">Registrarme</a><br>
      <c:url value="/" var="home"/>
      <a href="${home}" class="underlineHover">Ir al sitio</a>
    </div>

  </div>
</div>
		</div>
	</div>
</div>

<div id="modalContainer"></div>
	<div  id="modalCarrito"></div>
	<div id="modalDialogContainer"></div>
	<div id="toastDialog"></div>
	
</body>
<c:url var="jquery" value="/content/js/jquery.js" />
<script src="${jquery}"></script>
<c:url var="fonwAwesomeJs" value="/content/fontAwesome/js/all.js" />
<script src="${fonwAwesomeJs}"></script>
 <c:url var="popper" value="/content/js/popper.js" />
<script src="${popper}"></script>
 <c:url var="bootstrapjs" value="/content/js/bootstrap.js" />
<script src="${bootstrapjs}"></script>
<c:url var="scriptIndex" value="/content/web/js/index.js" />
<script src="${scriptIndex}"></script>
<c:url var="jsDialog" value="/content/web/js/modalDialog.js" />
<script src="${jsDialog}"></script>
<c:url var="jsDataTable" value="/content/datatable/datatables.min.js"/>
<script src="${jsDataTable}"></script>
<c:url var="scriptLogin" value="/content/web/js/login.js" />
<script src="${scriptLogin}"></script>
</html>