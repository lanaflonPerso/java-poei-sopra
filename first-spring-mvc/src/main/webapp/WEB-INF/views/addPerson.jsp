<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
</head>
<body>
	<h2>Add new Person</h2>
	<form action="addPerson" method="post">
		Nom : <input type="text" name="nom"> 
		Prénom : <input type="text" name="prenom">
		<button type="submit">Envoyer</button>
	</form>
</body>
</html>