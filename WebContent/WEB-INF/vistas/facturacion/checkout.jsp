<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="../CSS/facturacion.css"><meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-12">
<h1>Pago</h1>
    <hr>
        <form class="form-group" method="post" action="">
          <div class="row">
        <div class="col-md-12">
            <!--SHIPPING METHOD-->
            <div class="card">
                <div class="card-header">Address</div>
                <div class="card-body">
                    <div class="form-group">
                        <div class="col-md-12">
                            <h4>Domicilio</h4>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Pais:</strong></div>
                        <div class="col-md-12">
                            <input type="text" class="form-control" name="country" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-xs-12">
                            <strong>Nombre:</strong>
                            <input type="text" name="first_name" class="form-control" value="" />
                        </div>
                        <div class="span1"></div>
                        <div class="col-md-6 col-xs-12">
                            <strong>Apellidos:</strong>
                            <input type="text" name="last_name" class="form-control" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Domicilio:</strong></div>
                        <div class="col-md-12">
                            <input type="text" name="address" class="form-control" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>ciudad:</strong></div>
                        <div class="col-md-12">
                            <input type="text" name="city" class="form-control" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Estado:</strong></div>
                        <div class="col-md-12">
                            <input type="text" name="state" class="form-control" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Codigo Postal:</strong></div>
                        <div class="col-md-12">
                            <input type="text" name="zip_code" class="form-control" value="" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Numero telefonico:</strong></div>
                        <div class="col-md-12"><input type="text" name="phone_number" class="form-control" value="" /></div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Email :</strong></div>
                        <div class="col-md-12"><input type="text" name="email_address" class="form-control" value="" /></div>
                    </div>
                </div>
            </div>
            <!--SHIPPING METHOD END-->
            <!--CREDIT CART PAYMENT-->
            <div class="card">
                <div class="card-heading"><span><i class="glyphicon glyphicon-lock"></i></span> Secure Payment</div>
                <div class="card-body">
                    <div class="form-group">
                        <div class="col-md-12"><strong>Tipo de tarjeta:</strong></div>
                        <div class="col-md-12">
                            <select id="CreditCardType" name="CreditCardType" class="form-control">
                                <option value="5">Visa</option>
                                <option value="6">MasterCard</option>
                                <option value="7">American Express</option>
                                <option value="8">Discover</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>Numero de tarjeta:</strong></div>
                        <div class="col-md-12"><input type="text" class="form-control" name="car_number" value="" /></div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12"><strong>CVV:</strong></div>
                        <div class="col-md-12"><input type="text" class="form-control" name="car_code" value="" /></div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <strong>Fecha de expiracion</strong>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" name="">
                                <option value="">Month</option>
                                <option value="01">01</option>
                                <option value="02">02</option>
                                <option value="03">03</option>
                                <option value="04">04</option>
                                <option value="05">05</option>
                                <option value="06">06</option>
                                <option value="07">07</option>
                                <option value="08">08</option>
                                <option value="09">09</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                        </select>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                            <select class="form-control" name="">
                                <option value="">Year</option>
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                                <option value="2022">2022</option>
                                <option value="2023">2023</option>
                                <option value="2024">2024</option>
                                <option value="2025">2025</option>
                        </select>
                        </div>
                    </div>
                    <div class="form-group">
                        
                        <div class="col-md-12">
                            <ul class="cards">
                                <li class="visa hand">Visa</li>
                                <li class="mastercard hand">MasterCard</li>
                                <li class="amex hand">Amex</li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <button type="submit" class="btn btn-primary btn-submit-fix">Realizar compra</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--CREDIT CART PAYMENT END-->
        </div>
      </div>
    </form>
    <div class="row cart-footer">
    </div>
		</div>
	</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</html>