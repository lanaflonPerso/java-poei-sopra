<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
</head>
<body>
	Bienvenue sur votre espace personnel.
	<a href="deconnect">CLIQUER</a> pour quitter.
	<h2>Bonjour ${ user.prenom } ${ user.nom }</h2>
	<br>Que voulez-vous faire?
	<br>
	<h3>Ajouter une nouvelle personne</h3>
	
	<form:form modelAttribute="personne" action="personne/ajouter" method="post">
		<form:label path="nom">Nom: </form:label>
		<form:input path="nom" />
		<br>
		<form:label path="prenom">Prénom: </form:label>
		<form:input path="prenom" />
		<br>
		<input type="submit" value="Ajouter" />
	</form:form>

	
	<h3>Consulter la DB, modifier ou supprimer une personne</h3>
	<c:forEach items="${ personnes }" var="personne">
		<div>
			<c:out value="${ personne.prenom } ${ personne.nom }"></c:out>
			<a href="personne/modifier/${ personne.num }">Modifier</a> <a
				href="personne/supprimer/${ personne.num }">Supprimer</a>
				<a href="personne/details/${ personne.num }">Afficher details</a>
		</div>
	</c:forEach>
	
</body>
</html>