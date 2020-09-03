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
<title>Insert title here</title>
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

    <!-- Login Form -->
    <form action="index.html" >
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="Usuario">
      <input type="text" id="password" class="fadeIn third" name="login" placeholder="contraseña">
      <input type="submit" class="fadeIn fourth" value="Entrar">
    </form>
    

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="/vistas/Registrarme.jsp">Registrarme</a><br>
      <a class="underlineHover" href="/vistas/index.jsp">Ir al sitio</a>
    </div>

  </div>
</div>
		</div>
	</div>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</html>