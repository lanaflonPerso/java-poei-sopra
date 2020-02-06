<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion de mon compte</title>
</head>
<body>
	<h1>Gestion des adresses</h1>
	<h2>Espace personnel : Bienvenue ${ sessionScope.type } ${ sessionScope.prenom }
		${ sessionScope.nom }</h2>

	<h3>Mes données personnelles :</h3>
	<form action="gestionCompte" method="post">
		<label>Nom :</label><input type="text"
			placeholder="${ sessionScope.nom }" name="nom"><br> <label>Prénom
			:</label><input type="text" placeholder="${ sessionScope.prenom }"
			name="prenom"><br> <label>Sexe :</label><input
			type="text" placeholder="${ sessionScope.sexe }" name="sexe"><br><br>
		<button type="submit" name="choix" value="modifCompte">Mettre
			à jour mes données personnelles</button>
		<br>
		<button type="submit" name="choix" value="supprCompte">Supprimer
			mon compte</button>
	</form>
	<br>

	<h2>Que voulez-vous faire?</h2>
	<br>
	<form action="gestionCompte" method="post">
		<button type="submit" name="choix" value="gestionAffectation">Gérer
			mes adresses</button>
		<button type="submit" name="choix" value="gestionAdresse">Modifier
			ou supprimer une adresse</button>
	</form>

</body>
</html>