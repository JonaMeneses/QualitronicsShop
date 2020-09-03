<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-12">
	    <h1>Usuarios</h1>
	    <hr>
		<form action="login.html">
		    <div class="form-row">
		      <div class="form-group col-md-6">
		        <label for="inputEmail4">Email</label>
		        <input type="email" class="form-control" id="inputEmail4">
		      </div>
		      <div class="form-group co	l-md-6">
		        <label for="inputPassword4">Password</label>
		        <input type="password" class="form-control" id="inputPassword4">
		      </div>
		    </div>
		    <div class="form-group">
		      <label for="inputAddress">Direccion</label>
		      <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
		    </div>
		    
		    <div class="form-row">
		      <div class="form-group col-md-4">
		        <label for="inputCity">Ciudad</label>
		        <input type="text" class="form-control" id="inputCity">
		      </div>
		      <div class="form-group col-md-4">
		        <label for="inputCity">Estado</label>
		        <input type="text" class="form-control" id="inputCity2">
		      </div>
		      <div class="form-group col-md-4">
		        <label for="inputState">Pais</label>
		        <select id="inputState" class="form-control">
		          <option selected>Choose...</option>
		          <option>...</option>
		        </select>
		      </div>
		    </div>
		    <div class="form-group" hidden>
		      <div class="form-check">
		        <input class="form-check-input" type="checkbox" id="gridCheck">
		        <label class="form-check-label" for="gridCheck">
		          Activo
		        </label>
		      </div>
		    </div>
		    <button type="submit" class="btn btn-primary">Registrar</button>
		  </form>
		</div>
	</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>