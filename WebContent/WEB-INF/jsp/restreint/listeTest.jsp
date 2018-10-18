<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des tests</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>
		<br><br>
		<div class="container">	
			<h1>Listes des tests</h1><br><br>
			<table class="table" method="POST" action="ListeTestController">
			  <thead class="thead-dark">
			    <tr> 
			      <th scope="col">Libelle test</th>
			      <th scope="col">Libelle description</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			      <c:forEach items="${liste}" var="test">
			      	<tr>
						<th scope="row">${test.libelle}</th>
						<td>${test.description}</td>
						<td><a href="SelectionController?idTest=${test.idTest}" class="btn btn-success">Commencer test</a></td>
						<!-- <input type="hidden" value="${test.idTest}" name="idTest"> -->
						<!-- <a href="SelectionController?idTest=${test.idTest}">${test.libelle} | ${test.description}</a> -->
					</tr>				  
				  </c:forEach>    
			  </tbody>
			</table>	
			<br>
			<hr width="50%">
			<br>
			
	<!-- 		<form action="ListeArticleController" method="GET">
				<input type="submit" value="Retour">
			</form> -->
			
		</div>
		
		<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
	</body>
</html>