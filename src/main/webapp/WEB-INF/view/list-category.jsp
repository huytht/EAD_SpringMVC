<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Category</title>
</head>
<body>
	<c:import url="navbar.jsp"/>
	<security:authorize access="hasRole('USER')">
		<div class="d-flex justify-content-center py-5">
			<h2>Category Relationship Manager - <security:authentication property="principal.username" /></h2>
		</div>
	</security:authorize>
	
    <div class="container">
	    <div class="d-flex justify-content-between align-items-center">
        	<security:authorize access="hasRole('ADMIN')">
		   		<input class="btn btn-primary form-group row" type="button" value="Add Category"
		   			onclick="window.location.href='showFormForAdd'; return false;" />
			</security:authorize>	   		
	   		<form:form action="search" method="get">
	   			<div class="form-group row">
	   				<div class="col-6">
	   					<input name="theSearchName" class="form-control mr-2" id="search" type="search"
	   						placeholder="Search" aria-label="Search" />
	   				</div>
	   				<div class="col-6">
	   					<input class="btn btn-success" type="submit" value="Search" />
	   				</div>
	   			</div>
	   		</form:form>
	   	</div>
	   	<div class="row pb-3">
	   	 	<table class="table">
			    <thead class="thead-dark">
	                <th scope="col">Name</th>
                    <security:authorize access="hasRole('ADMIN')">
	                	<th scope="col">Action</th>
	                </security:authorize>
			    </thead>
				<c:forEach var="tempCategory" items="${categories }">
					<c:url var="updateLink" value="/category/showFormForUpdate">
						<c:param name="categoryId" value="${tempCategory.id }" />
					</c:url>
					<c:url var="deleteLink" value="/category/delete">
						<c:param name="categoryId" value="${tempCategory.id }" />
					</c:url>
					<tbody>
						<td>${tempCategory.name}</td>
						<security:authorize access="hasRole('ADMIN')">
							<td>
								<a href="${updateLink }">
									<i class="fas fa-edit"></i>
								</a>
								<a onclick="return confirm('Are you sure you want to delete this?')" href="${deleteLink }">
									<i class="far fa-trash-alt"></i>
								</a>
							</td>
						</security:authorize>
					</tbody>
				</c:forEach>    
		  </table>
   		</div>
    </div>
</body>
</html>