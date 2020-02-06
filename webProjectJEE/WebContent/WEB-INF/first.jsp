<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>First page</title>
</head>
<body>
	<h2>First page</h2>
	<c:out value="Bonjour ${ sessionScope.nom }" />
	<div>
		<c:url value="/modifPerson" var="second" />
		<a href="${ second }"> Modif Person </a>
	</div>
	<div>
		<c:url value="/operation" var="third" />
		<a href="${ third }"> Operation </a>
	</div>
	<div>
		<c:url value="deconnect" var="deconnect" />
		<a href="${ deconnect }"> déconnexion </a>
	</div>
</body>
</html>
