<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="ctx" value="${pageContext.servletContext.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx }/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <h1>edition demande</h1>
        <c:choose>
        	<c:when test="${demande.getClass().simpleName=='Demande'}">
	        	<c:url var="action" value="/demande/saveDemande"></c:url>
	        </c:when>
         </c:choose>
        
        <form:form action="${action}" method="post" modelAttribute="demande">
        	
        	<form:hidden path="version"></form:hidden>
            <div class="form-group">
                <form:label path="idDemande">idDemande</form:label>
                <form:input path="idDemande" cssClass="form-control" readOnly="true"/>
            </div>
            <div class="form-group">
                <form:label path="message">Message</form:label>
                <form:textarea type="text" rows="5" cssClass="form-control" path="message" itemLabel="message"/>
            </div>
            <div class="form-group">
                <form:label path="artisan">Artisan</form:label>
                <form:input cssClass="form-control" path="artisan" itemValue="artisan" itemLabel="artisan"/>
            </div>
            <div class="form-group">
                <form:label path="metier">Metier</form:label>
                <form:select cssClass="form-control" items="${metier}" path="metier" itemValue="metier" itemLabel="metier">
                </form:select>
            </div>
            <div class="form-group">
                <form:label path="service">Service</form:label>
                <form:select cssClass="form-control" items="${service}" path="service" itemValue="service" itemLabel="service">
                </form:select>
            </div>
<!--             <div class="form-group"> -->
<%--                 <form:label path="statut">Statut</form:label> --%>
<%--                 <form:select cssClass="form-control" path="statut" items="${statuts}" itemLabel="statut"> --%>
<%--                 </form:select> --%>
<!--             </div> -->
<!--             <div class="form-group"> -->
<%--                 <form:label path="date">Date</form:label> --%>
<%--                 <form:input type="date" path="date" cssClass="form-control"/> --%>
<!--             </div> -->
            
            <div class="form-group">
               <button type="submit" class="btn btn-success">Editer</button>
               <a href="${ctx}/demande/list" class="btn btn-warning">Annuler</a>
            </div>
        </form:form>
    </div>
</body>
</html>