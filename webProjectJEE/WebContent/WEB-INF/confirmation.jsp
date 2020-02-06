<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personne ajoutée</title>
</head>
<body>
	Person ${ personne.prenom } ${ personne.nom } has been successfully
	added to our database.
	<br>
	<c:url value="/ajoutPersonne" var="lienFormulaire">
	</c:url>
	<a href="${ lienFormulaire }">Retour à l'exercice</a>

</body>
</html>