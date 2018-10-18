<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Question</title>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>
		
		
		<div class="container">
		<br><br><br>
			<h3>Enonce: ${question.enonce}</h3><br><br>
			
			<c:forEach items="${listeProp}" var="prop">
				<input type="hidden" value="${prop.idProposition}" name="idProp">
				<div class="form-check">
				  <input class="form-check-input" type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
				  <label class="form-check-label" for="defaultCheck1">
				    ${prop.enonce}
				  </label>
				</div>
				<br>
			</c:forEach>
			<br>
			<br>
			
			
			  <div class="row">
			    <div class="col">	
			    	<c:forEach items="${lesTirages}" var="leTirage"  varStatus="status">
			    		<c:if test="${leTirage.idQuestion == question.idQuestion && tirageActu != null}">
				    		<a class="btn btn-warning" href="AffichageQuestion?idQuestion=${pageScope.tirageActu}&idEpreuve=${idEpreuve}">Précédent</a>	
						</c:if>
						<c:set var="tirageActu" value="${leTirage.idQuestion}" scope="page" />	
			    		<c:if test="${pageScope.index == true}">	
				    			<a class="btn btn-success" href="AffichageQuestion?idQuestion=${pageScope.tirageActu}&idEpreuve=${idEpreuve}">Suivant</a>	 
				    		<c:set var="index" value="${pageScope.index = false};" scope="page" />
				    	</c:if>
			    		<c:if test="${leTirage.idQuestion == question.idQuestion}">
				    		<c:set var="index" value="true" scope="page" />
				    	</c:if>	
		    		</c:forEach>
		    	</div>
			    <div class="col">
			      <button type="button" class="btn btn-danger">Finir test</button>
			    </div>
		      </div>		
			</div>
		
		<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
	</body>
</html>