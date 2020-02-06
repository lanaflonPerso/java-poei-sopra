<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des adresses - Connexion</title>
</head>
<body>
	<h1>Gestion des adresses</h1>
	<h3>Connexion</h3>
	<form method="post" action="index">
		<div>
			<input type="text" name="nom" placeholder="saisir nom" />
		</div>
		<div>
			<input type="password" name="pwd" placeholder="saisir mot de passe" />
		</div>
		<button type="submit" name="choix" value="connexion">Me
			connecter</button>
		<br>
		<button type="submit" name="choix" value="inscription">Inscription</button>
	</form>
</body>
</html>