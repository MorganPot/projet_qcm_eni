<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/style.css"> 
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="ListeTestController">QCM</a>
			
	<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
		<ul class="navbar-nav">
			<!-- <li class="nav-item active">
				<a class="nav-link" href="ListeTestController">Accueil <span class="sr-only">(current)</span></a>
			</li> -->
			<c:if test="${sessionScope.sessionUtilisateur != null}">
                   <p style="color:white" class="nav">Connecté : ${sessionScope.sessionUtilisateur.email}</p>
            </c:if>
		</ul>
	</div>
</nav>