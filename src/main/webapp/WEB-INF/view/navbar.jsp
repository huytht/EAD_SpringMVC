<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" 
    	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #e3f2fd;">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/book/list"><img alt="" width="30px" height="30px" src="${pageContext.request.contextPath}/resources/images/open-book.png" /></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
	    <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/user/list">List User</a>
	    </li>
	    <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/book/list">List Book</a>
	    </li>
	    <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/category/list">List Category</a>
	    </li>
    </ul>

    <form:form method="post" action="${pageContext.request.contextPath}/logout" class="form-inline my-2 my-lg-0">
      <input class="btn btn-outline-success" type="submit" value="Logout">
    </form:form>
  </div>
</nav>