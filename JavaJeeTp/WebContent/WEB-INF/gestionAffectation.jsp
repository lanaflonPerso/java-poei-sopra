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
	<h2>Gestion de mes adresses : Bienvenue ${ sessionScope.type } ${ sessionScope.prenom }
		${ sessionScope.nom }</h2>

	<form action="gestionAffectation" method="post">
		<input type="text" name="rue" placeholder="saisir le nom de la rue" />
		<input type="text" name="codePostal"
			placeholder="saisir le code postal" /> <input type="text"
			name="ville" placeholder="saisir le nom de la ville" />
		<button type="submit" name="choix" value="nouvelleAdresse">Créer
			nouvelle adresse</button>
	</form>

	<h2>Mes adresses</h2>

	<ul>
		<c:forEach items="${ adresses }" var="adresse">
			<li>
				<form action="gestionAffectation" method="post">
					<c:out value="${ adresse['rue'] }" />
					<c:out value="${ adresse['codePostal'] }" />
					<c:out value="${ adresse['ville'] }" />
					<input type="hidden" name="idDiss" value="${ adresse['id'] }" />
					<button type="submit" name="choix" value="dissocier">Dissocier
						cette adresse</button>
				</form>
			</li>
		</c:forEach>
	</ul>

	<br>

	<h2>Autres adresses</h2>

	<ul>
		<c:forEach items="${ adressesNotSession }" var="adresse">
			<li>
				<form action="gestionAffectation" method="post">
					<c:out value="${ adresse['rue'] }" />
					<c:out value="${ adresse['codePostal'] }" />
					<c:out value="${ adresse['ville'] }" />
					<input type="hidden" name="idAss" value="${ adresse['id'] }" />
					<button type="submit" name="choix" value="associer">Associer
						cette adresse</button>
				</form>
			</li>
		</c:forEach>
	</ul>



	<form action="gestionAffectation" method="post">
		<button type="submit" name="choix" value="gestionCompte">Retour
			vers mon compte</button>
		<button type="submit" name="choix" value="gestionAdresse">Modifier
			ou supprimer une adresse</button>
	</form>


</body>
</html>