<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.error {
	color: red
}
</style>
<title>Person Form</title>
</head>
<body>
	Bonjour ${ perso.nom }
	<form:form modelAttribute="personne" action="personne" method="post">
		<form:label path="nom">Nom: </form:label>
		<form:input path="nom" />
		<form:errors path="nom" cssClass="error" />
		<form:label path="prenom">Prénom: </form:label>
		<form:input path="prenom" />
		<form:errors path="prenom" cssClass="error" />
		<input type="submit" value="Ajouter" />
	</form:form>
	<a href="deconnect"> Déconnexion </a>

	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post">
		<input type="submit" value="Deconnection" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>