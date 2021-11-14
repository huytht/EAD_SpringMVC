<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Save User</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
	    	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
	<c:import url="navbar.jsp"/>

	<div class="d-flex justify-content-center py-5">
		<h2>User Relationship Manager</h2>
	</div>
	<div class="container">
		<form:form action="saveUser" modelAttribute="user" method="post">
			
			<form:hidden path="id" />
			
			<div class="form-group row">
				<label for="username" class="col-2 col-form-label">Username</label>
				<div class="col-4">
					<form:input id="username" readonly="true" path="username" class="form-control" placeholder="Username" />
				</div>
			</div>
			<form:input id="password" type="hidden" path="password" class="form-control" placeholder="Password" />
			<div class="form-group row">
				<label for="email" class="col-2 col-form-label">Email</label>
				<div class="col-4">
					<form:input id="email" readonly="true" path="email" class="form-control" placeholder="Email" />
				</div>
			</div>
			<div class="form-group row">
				<label for="email" class="col-2 col-form-label">Enabled</label>
				<div class="col-4">
					<form:select id="enabled" path="enabled" class="form-control">
						<form:option value="1">True</form:option>
						<form:option value="0">False</form:option>
					</form:select>
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