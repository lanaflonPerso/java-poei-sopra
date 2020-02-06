<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier une personne</title>
</head>
<body>

	Bienvenue sur votre espace personnel.
	<a href="deconnect">CLIQUER</a> pour quitter.
	<h2>Bonjour ${ user.prenom } ${ user.nom }</h2>
	<h3>Modifier une personne</h3>

	<form:form modelAttribute="persUpd"
		action="/excrudspring/personne/modifier" method="post">
		<form:hidden path="num" />
		<form:label path="nom">Nom: </form:label>
		<form:input path="nom" />
		<br>
		<form:label path="prenom">Prénom: </form:label>
		<form:input path="prenom" />
		<br>
		<input type="submit" value="Modifier" />
	</form:form>
</body>
</html>