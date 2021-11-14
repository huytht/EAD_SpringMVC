<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registration Form</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
	    	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/styles.css" />
</head>
<body>
	 <div class="container">
        <div class="d-flex justify-content-center h-100">
            <div class="card">
                <div class="card-header">
					<h3>Registration Form</h3>
				</div>
	 			<div class="card-body">
					<form:form modelAttribute="registeredUser" method="post"
						action="${pageContext.request.contextPath }/register/processRegistrationForm">
						<div class="form-group row">
							<spring:bind path="username">
								<div class="input-group form-group">
		                            <div class="input-group-prepend">
		                                <span class="input-group-text"><i class="fas fa-user"></i></span>
		                            </div>
		                            <form:input placeholder="Username" cssClass="form-control ${status.error ? 'is-invalid' : '' }" path="username" id="username" type="text" 
											aria-describedBy="validationUsername" />
									<div id="validationUsername" class="invalid-feedback" >
										<form:errors path="username" />
									</div>
		                        </div>
							</spring:bind>
						</div>
						
						<div class="form-group row">
							<spring:bind path="password">
								 <div class="input-group form-group">
		                            <div class="input-group-prepend">
		                                <span class="input-group-text"><i class="fas fa-key"></i></span>
		                            </div>
		                            <form:input placeholder="Password" cssClass="form-control ${status.error ? 'is-invalid' : '' }" path="password" id="password" type="password" 
											aria-describedBy="validationPassword" />
									<div id="validationPassword" class="invalid-feedback" >
										<form:errors path="password" />
									</div>
		                        </div>
							</spring:bind>
						</div>
						
						<div class="form-group row">
							<spring:bind path="matchingPassword">
								 <div class="input-group form-group">
		                            <div class="input-group-prepend">
		                                <span class="input-group-text"><i class="fas fa-key"></i></span>
		                            </div>
		                            <form:input placeholder="Repeat password" cssClass="form-control ${status.error ? 'is-invalid' : '' }" path="matchingPassword" id="matchingPassword" type="password" 
										aria-describedBy="validationMatchingPassword" />
									<div id="validationMatchingPassword" class="invalid-feedback" >
										<form:errors path="matchingPassword" />
									</div>
		                        </div>
							</spring:bind>
						</div>
						
						<div class="form-group row">
							<spring:bind path="email">
								 <div class="input-group form-group">
		                            <div class="input-group-prepend">
		                                <span class="input-group-text"><i class="fas fa-envelope"></i></span>
		                            </div>
		                            <form:input placeholder="Email" cssClass="form-control ${status.error ? 'is-invalid' : '' }" path="email" id="email" type="text" 
										aria-describedBy="validationEmail" />
									<div id="validationEmail" class="invalid-feedback" >
										<form:errors path="email" />
									</div>
		                        </div>
							</spring:bind>
						</div>
						
						<div class="form-group">
							<input class="btn float-right login_btn" type="submit" value="Register" />
						</div>
					</form:form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
                        <a href="${pageContext.request.contextPath }/showMyLoginPage">Back to sign in</a>
                    </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>