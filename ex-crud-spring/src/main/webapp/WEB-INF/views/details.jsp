<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Afficher details</title>
</head>
<body>

	Bienvenue sur votre espace personnel.
	<a href="deconnect">CLIQUER</a> pour quitter.
	<h2>Bonjour ${ user.prenom } ${ user.nom }</h2>
	
	<form:form modelAttribute="persDetails" action="details">
	Num : ${ persDetails.num } <br>
	Nom : ${ persDetails.nom } <br>
	Prénom : ${ persDetails.prenom }
	</form:form>
	

</body>
</html>