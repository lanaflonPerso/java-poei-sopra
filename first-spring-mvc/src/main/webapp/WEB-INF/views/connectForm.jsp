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
	<form:form modelAttribute="perso" action="connect" method="post">
		<form:label path="nom">Nom: </form:label>
		<form:input path="nom" /><br>
		<form:errors path="nom" cssClass="error" /><br>
		<form:label path="prenom">Prénom: </form:label>
		<form:input path="prenom" /><br>
		<form:errors path="prenom" cssClass="error" /><br>
		<input type="submit" value="Connexion" />
	</form:form>
</body>
</html>

