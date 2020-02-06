<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gérer mes adresses</title>
</head>
<body>
<h1>Gestion des adresses</h1>
	<h2>Modification ou suppression d'adresses : Bienvenue ${ sessionScope.type } ${ sessionScope.prenom }
		${ sessionScope.nom }</h2>
		
		<h2>Mes adresses</h2>
	
		<ul>
			<c:forEach items="${ adresses }" var="adresse">
				<li>
				<form action="gestionAdresse" method="post">
					<c:out value="${ adresse['rue'] }" /> 
					<c:out value="${ adresse['codePostal'] }" /> 
					<c:out value="${ adresse['ville'] }" /> 
					<input type="hidden" value="${ adresse['id'] }" name="idAd" />
					<button type="submit" name="choix" value="modifier">Modifier cette adresse</button>
					<button type="submit" name="choix" value="supprimer">Supprimer cette adresse</button>
				</form>
				</li>
			</c:forEach>
		</ul>
	
</body>
</html>