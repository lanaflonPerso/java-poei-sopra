<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.error {
	color: red
}
</style>
<title>Connection Form</title>
</head>
<body>
<h3>Page de connexion</h3>
	<form:form modelAttribute="user" action="connect" method="post">
		<form:label path="nom">Nom: </form:label>
		<form:input path="nom" />
		<br>
		<form:label path="prenom">Prénom: </form:label>
		<form:input path="prenom" />
		<br>
		<input type="submit" value="Connexion" />
	</form:form>
</body>
</html>

