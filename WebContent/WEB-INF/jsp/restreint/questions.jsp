<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des questions</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>
		
		<div class="container">	
		<br><br>
			<div class="jumbotron jumbotron-fluid">
			  <div class="container">
			    <h1 class="display-4">Listes des questions</h1>
			    <p class="lead">Theme: ${theme}</p>
			    <p>Temps restant: 00 h 59 min</p>
			  </div>
			</div>
			<br><br>
			<div class="container">
			  <div class="row">
				<c:forEach items="${liste}" var="question" varStatus="status">
		    		<div class="col-sm-4">
						<c:if test="${status.index >= 0 && status.index <= 6}">
							<input type="hidden" value="${question.idQuestion}" name="idTest">
							<p class="list-group-item list-group-item-action"><a href="AffichageQuestion?idQuestion=${question.idQuestion}&idEpreuve=${epreuve.idEpreuve}">${question.enonce}</a></p>
			  			</c:if>	
	  				</div>	
		    		<div class="col-sm-4">
						<c:if test="${status.index > 7 && status.index <= 13}">
							<input type="hidden" value="${question.idQuestion}" name="idTest">
							<p	 class="list-group-item list-group-item-action"><a href="AffichageQuestion?idQuestion=${question.idQuestion}&idEpreuve=${epreuve.idEpreuve}">${question.enonce}</a></p>
		  				</c:if>
	  				</div>	
		    		<div class="col-sm-4">
						<c:if test="${status.index > 13}">
							<input type="hidden" value="${question.idQuestion}" name="idTest">
							<p class="list-group-item list-group-item-action"><a href="AffichageQuestion?idQuestion=${question.idQuestion}&idEpreuve=${epreuve.idEpreuve}">${question.enonce}</a></p>
		  				</c:if>
	  				</div>	
				</c:forEach>	
			  </div>
			</div>
			
			<!-- <div class="row">
			  <div class="col-4">
			    <div class="list-group" id="list-tab" role="tablist">
			      <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home">Home</a>
			      <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile">Profile</a>
			      <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages">Messages</a>
			      <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#list-settings" role="tab" aria-controls="settings">Settings</a>
			    </div>
			  </div> -->
			
			<br><br>
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