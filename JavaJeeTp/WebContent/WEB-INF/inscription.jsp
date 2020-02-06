<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des adresses - Inscription</title>
</head>
<body>
	<h1>Gestion des adresses</h1>
	<h3>Inscription</h3>
	<form action="inscription" method="post">
		<input type="text" name="nom" placeholder="saisir nom"><br>
		<input type="text" name="prenom" placeholder="saisir prénom"><br>
		<label>Sexe :</label> 
		<select name="sexe">
			<option>Féminin</option>
			<option>Masculin</option>
		</select><br><br>
		<button type="submit">Valider mon inscription</button>
	</form>
</body>
</html>