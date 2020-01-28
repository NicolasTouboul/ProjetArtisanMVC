<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx}/bootstrap/css/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1>edition compte ${ctx}</h1>
		
		<c:choose>
			<c:when test="${compte.getClass().simpleName == 'Artisan'}">
				<c:url var="action" value="/compte/saveArtisan"></c:url>
			</c:when>
			<c:otherwise>
				<c:url var="action" value="/compte/saveClient"></c:url>
			</c:otherwise>
		</c:choose>
		
		<form:form action="${action}" method="get" modelAttribute="compte">
		<form:hidden path="version"/>
			<div class="form-group">
				<form:label path="id_compte">id_compte:</form:label>
				<form:input path="id_compte" cssClass="form-control" readonly="true" placeholder = "l'id est généré automatiquement"/>
			</div>
			
			<div class="form-group">
				<form:label path="login">login:</form:label>
				<form:input path="login" cssClass="form-control"/>
				<form:errors path="login"></form:errors>
			</div>
			
			<div class="form-group">
				<form:label path="mdp">mdp:</form:label>
				<form:input path="mdp" cssClass="form-control"/>
				<form:errors path="mdp"></form:errors>
			</div>
			
			<div class="form-group">
				<form:label path="adresse.numero">numero:</form:label>
				<form:input type="number" path="adresse.numero" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="adresse.rue">rue:</form:label>
				<form:input path="adresse.rue" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="adresse.codePostal">Code postal:</form:label>
				<form:input path="adresse.codePostal" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<form:label path="adresse.ville">ville:</form:label>
				<form:input path="adresse.ville" cssClass="form-control"/>
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-success">envoyer</button>
				<a href="${ctx}/compte/compteList">annuler</a>
			</div>
			
		</form:form>
	</div>
</body>
</html>