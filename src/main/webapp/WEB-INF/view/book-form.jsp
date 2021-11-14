<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Save Book</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
	    	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
	<c:import url="navbar.jsp"/>

	<div class="d-flex justify-content-center py-5">
		<h2>Book Relationship Manager</h2>
	</div>
	<div class="container">
		<form:form action="saveBook?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" modelAttribute="book" method="post">

			<form:hidden path="id" />
			
			<div class="form-group row">
				<label for="title" class="col-2 col-form-label">Title</label>
				<div class="col-4">
					 <spring:bind path="title">
						<form:input cssClass="form-control ${status.error ? 'is-invalid' : ''}" id="title" 
					 				path="title" placeholder="Title" aria-describedby="validationTitle" />
                        <div id="validationTitle" class="invalid-feedback">
                            <form:errors path="title"/>
                        </div>
                    </spring:bind>
				</div>
			</div>
			<div class="form-group row">
				<label for="summaryContent" class="col-2 col-form-label">Summary Content</label>
				<div class="col-4">
					<spring:bind path="summaryContent">
						<form:textarea id="summaryContent" path="summaryContent" cssClass="form-control ${status.error ? 'is-invalid' : ''}"
					 				placeholder="Summary Content" aria-describedby="validationSumContent"/>
                        <div id="validationSumContent" class="invalid-feedback">
                            <form:errors path="summaryContent"/>
                        </div>
                    </spring:bind>
				</div>
			</div>
			<div class="form-group row">
				<label for="price" class="col-2 col-form-label">Price</label>
				<div class="col-4">
					<spring:bind path="price">
						<form:input cssClass="form-control ${status.error ? 'is-invalid' : ''}" id="price" 
					 				path="price" placeholder="Price" aria-describedby="validationPrice" />
                        <div id="validationPrice" class="invalid-feedback">
                            <form:errors path="price"/>
                        </div>
                    </spring:bind>
				</div>
			</div>
			<div class="form-group row">
				<label for="author" class="col-2 col-form-label">Author</label>
				<div class="col-4">
					<spring:bind path="author">
						<form:input cssClass="form-control ${status.error ? 'is-invalid' : ''}" id="author" 
					 				path="author" placeholder="Author" aria-describedby="validationAuthor" />
                        <div id="validationAuthor" class="invalid-feedback">
                            <form:errors path="author"/>
                        </div>
                    </spring:bind>
				</div>
			</div>
			<div class="form-group row">
				<label for="publicationDate" class="col-2 col-form-label">Publication Date</label>
				<div class="col-4">
					<spring:bind path="publicationDate">
						<form:input cssClass="form-control ${status.error ? 'is-invalid' : ''}" id="publicationDate" 
					 				path="publicationDate" type="date" aria-describedby="validationPublicationDate" />
                        <div id="validationPublicationDate" class="invalid-feedback">
                            <form:errors path="publicationDate"/>
                        </div>
                    </spring:bind>
				</div>
			</div>
			<c:choose >
				<c:when test="${oldImage != null }">
					<div class="form-group row">
						<label for="image" class="col-2 col-form-label">Image (current)</label>
						<div class="col-4">
							<img src="<c:url value="/FileDisplayServlet/${oldImage}" />" width="100px" height="100px" />
						</div>
					</div>
				</c:when>
			</c:choose>
			<div class="form-group row">
				<label for="image" class="col-2 col-form-label">Image</label>
				<div class="col-4">
					<spring:bind path="fileData">
						<form:input cssClass="form-control ${status.error ? 'is-invalid' : ''}" id="image" 
					 				path="fileData" type="file" aria-describedby="validationImage" />
                        <div id="validationImage" class="invalid-feedback">
                            <form:errors path="fileData"/>
                        </div>
                    </spring:bind>
				</div>
			</div>
			<div class="form-group row">
				<label for="category" class="col-2 col-form-label">Category</label>
				<div class="col-4">
				 	<form:select id="category" path="category.id" class="form-control" placeholder="Category">
						<form:options items="${categories }" itemValue="id" itemLabel="name" />
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