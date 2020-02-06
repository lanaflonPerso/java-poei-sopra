<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Page</title>
</head>
<body>
	<h3>Welcome to First Page</h3>
	<c:choose>
		<c:when test="${ nom.equals('wick') and prenom.equals('john') }">
			<c:out value="Bienvenue ${ prenom } ${ nom } ! " />
			<br>
			<c:out value="Vous êtes bien connecté." />
			<br>
			<c:url value="/second" var="second" />
			<a href="${ second }">Go to Second Page</a>
			<br>

			<c:url value="/third" var="third" />
			<a href="${ third }">Go to third Page</a>
			<br>

			<c:url value="/first" var="deconnect" />
			<a href="${ deconnect }">Disconnect</a>
		</c:when>
		<c:otherwise>
			<c:out value="Vous êtes déconnecté(e)." />
			<br>
			<c:url value="/first?nom=wick&prenom=john" var="first" />
			<a href="${ first }">Connect as John Wick</a>
		</c:otherwise>
	</c:choose>
</body>
</html>