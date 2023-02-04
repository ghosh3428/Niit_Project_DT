<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="css" value="/rs/css" />
<spring:url var="js" value="/rs/js" />




<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Online shopping website">
<meta name="author" content="Debabrato Ghosh">
<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myStyle.css" rel="stylesheet">

<title>${title}</title>

</head>

<body>


	<div class="wrapper">
		<!-- Navigation -->
		<%@ include file="./shared/navbar.jsp"%>

		<!-- Content -->
		<c:if test="${userclickhome == true}">
			<%@include file="home.jsp"%>
		</c:if>

		<c:if test="${userclickaboutus == true}">
			<%@include file="aboutus.jsp"%>
		</c:if>

		<c:if test="${userclickcontactus == true}">
			<%@include file="contactus.jsp"%>
		</c:if>

		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>
	</div>

	<!-- JQuery core JavaScript -->
	<script src="${js}/jquery.min.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>
</body>

</html>

