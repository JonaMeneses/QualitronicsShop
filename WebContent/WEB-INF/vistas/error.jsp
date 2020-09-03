<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<c:url value="/content/css/bootstrap.css" var="bootstrap"></c:url>
	<link href="${bootstrap}" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body class="bg-danger">
	<div class='container'>
		<div class="row">
			<div class="col-6 offset-3 card">
			<c:url value="/login" var="loginpage" />
				
					<div class="card-title bg-info text-white">
						<h3>Identificarse</h3>						
					</div>
						<div class="card-body text-danger bt-light">
							<div class="alert alert-danger">
								<h3>${mensaje}</h3>
								
							</div>
						</div>
			</div>
		</div>
	</div>
	<c:url value="/content/js/jquery.js" var="jqueryjs"></c:url>		
	<script type="text/javascript" src="${jqueryjs}"></script>
	<c:url value="/content/js/bootstrap.js" var="bootstrapjs"></c:url>
	<script type="text/javascript" src="${bootstrapjs}"></script>
</body>
</html>