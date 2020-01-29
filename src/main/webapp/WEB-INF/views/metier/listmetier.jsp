<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript"
	src="${ctx}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div>
			<a href="?lang=fr" class="btn btn-link"><spring:message code="francais"></spring:message></a>
			<a href="?lang=en"class="btn btn-link"><spring:message code="english"></spring:message></a>
		</div>
		<h1>
			<spring:message code="salle.list.titre"></spring:message>
		</h1>
		<a href="${ctx}/salle/addsalle" class="btn btn-link"><spring:message
				code="salle.list.ajout"></spring:message></a>
		<table class="table">
			<tr>
				<th><spring:message code="salle.nom"></spring:message></th>
				<th></th>
			</tr>
			<c:forEach items="${salles}" var="s">
				<tr>
					<td>${s.nom}</td>
					<td><a href="${ctx}/salle/delete?nom=${s.nom}"
						class="btn btn-warning"><spring:message
								code="salle.list.supprimer"></spring:message></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>