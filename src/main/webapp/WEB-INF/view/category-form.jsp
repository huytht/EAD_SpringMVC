<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Save Category</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
	    	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
	<c:import url="navbar.jsp"/>

	<div class="d-flex justify-content-center py-5">
		<h2>Category Relationship Manager</h2>
	</div>
	<div class="container">
		<form:form action="saveCategory" modelAttribute="category" method="post">
			
			<form:hidden path="id" />
			
			<div class="form-group row">
				<label for="name" class="col-2 col-form-label">Name</label>
				<div class="col-4">
					<spring:bind path="name">
						<form:input cssClass="form-control ${status.error ? 'is-invalid' : ''}" id="name" 
					 				path="name" placeholder="Name" aria-describedby="validationName" />
                        <div id="validationName" class="invalid-feedback">
                            <form:errors path="name"/>
                        </div>
                    </spring:bind>
				</div>
			</div>
			<div class="form-group row">
				<div class="offset-2 col-4">
					<input class="btn btn-primary" type="submit" value="Submit" />
				</div>			
			</div>
		</form:form>
	</div>
</body>
</html>