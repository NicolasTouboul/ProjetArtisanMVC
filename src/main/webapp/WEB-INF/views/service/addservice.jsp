<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>edition service</h1>
		<form:form  action="saveservice" method="get" modelAttribute="service">
			
			<div class="form-group">
				<form:label path="nomService">nomService:</form:label>
				<form:input path="nomService" cssClass="form-control" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success">envoyer</button>
				<a href="${ctx}/service/listservice" class="btn btn-warning">annuler</a>
			</div>
		</form:form>
		</div>
		
</body>
</html>