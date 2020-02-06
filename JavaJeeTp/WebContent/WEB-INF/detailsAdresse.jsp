<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier adresse</title>
</head>
<body>
	<h1>Gestion des adresses</h1>
	<h2>Modification d'adresses : Bienvenue ${ sessionScope.type } ${ sessionScope.prenom }
		${ sessionScope.nom }</h2>
	<form action="detailsAdresse" method="post">
		<label>Rue :</label> <input type="text"
			placeholder="${ adresseToUpdate['rue'] }" name="rue"><br>
		<label>Code postal :</label> <input type="text"
			placeholder="${ adresseToUpdate['codePostal'] }" name="codePostal"><br>
		<label>Ville :</label> <input type="text"
			placeholder="${ adresseToUpdate['ville'] }" name="ville"><br>
		<br>
		<button type="submit" name="choix" value="enregistrer">Enregistrer les modifications</button><br>
	</form>
	
	<button type="submit" name="choix" value="deconnexion"></button>
</body>
</html>