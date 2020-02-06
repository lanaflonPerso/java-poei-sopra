<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Third Page</title>
</head>
<body>
	<h3>Welcome to Third Page</h3>
	<c:out value="Bienvenue ${ prenom } ${ nom } ! " />
	<br>
	<c:out value="Vous êtes bien connecté." />
	<br>
	<c:url value="/first?nom=wick&prenom=john" var="first" />
	<a href="${ first }">Go to first Page</a>
	<br>

	<c:url value="/second" var="second" />
	<a href="${ second }">Go to second Page</a>
	<br>

	<c:url value="/first" var="deconnect" />
	<a href="${ deconnect }">Disconnect</a>
</body>
</html>