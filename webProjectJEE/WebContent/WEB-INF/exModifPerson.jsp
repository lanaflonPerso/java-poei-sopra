<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ mtd }Person</title>
</head>
<body>
	<h1>${ mtd }Person</h1>
	<c:choose>
		<c:when test="${ test == true }">
			<c:choose>
				<c:when test="${ mtd.equals('add') }">
					<form method="post" action="modifPerson">
						<div>Formulaire d’ajout d’une Personne</div>
						<input type="hidden" name="mtd" value="${ mtd }" />
						<div>
							<label for="nom">Nom</label> <input type="text" id="nom"
								name="nom" />
						</div>
						<div>
							<label for="prenom">Prénom</label> <input type="text" id="prenom"
								name="prenom" />
						</div>
						<input type="submit" value="Add" /><br>
						<c:url value="/modifPerson" var="lienAccueil" />
						<a href="${ lienAccueil }">Retour</a><br>
					</form>
				</c:when>
				<c:when test="${ mtd.equals('edit') }">
					<form method="post" action="modifPerson">
						<div>Formulaire de modification d’une Personne</div>
						<input type="hidden" name="mtd" value="${ mtd }" />
						<div>
							<label for="num">Num</label> <input type="text" id="num"
								name="num" />
						</div>
						<div>
							<label for="nom">Nouveau nom</label> <input type="text" id="nom"
								name="nom" />
						</div>
						<div>
							<label for="prenom">Nouveau prénom</label> <input type="text"
								id="prenom" name="prenom" />
						</div>
						<input type="submit" value="Edit" /><br>
						<c:url value="/modifPerson" var="lienAccueil" />
						<a href="${ lienAccueil }">Retour</a><br>
					</form>
				</c:when>
				<c:when test="${ mtd.equals('remove') }">
					<form method="post" action="modifPerson">
						<div>Formulaire de suppression d’une Personne</div>
						<input type="hidden" name="mtd" value="${ mtd }" />
						<div>
							<label for="num">Num</label> <input type="text" id="num"
								name="num" />
						</div>
						<input type="submit" value="Remove" /><br>
						<c:url value="/modifPerson" var="lienAccueil" />
						<a href="${ lienAccueil }">Retour</a><br>
					</form>
				</c:when>
				<c:otherwise>
					<div>Bienvenue sur la page d'accueil</div>
					<c:url value="/modifPerson?mtd=add" var="lienAdd" />
					<a href="${ lienAdd }">Add person</a>
					<br>
					<c:url value="/modifPerson?mtd=edit" var="lienEdit" />
					<a href="${ lienEdit }">Edit person</a>
					<br>
					<c:url value="/modifPerson?mtd=remove" var="lienRemove" />
					<a href="${ lienRemove }">Remove person</a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<div>Operation has been succesfully done</div>
			<c:url value="/modifPerson" var="lienAccueil" />
			<a href="${ lienAccueil }">Return to main page</a>
			<br>
		</c:otherwise>
	</c:choose>
</body>
</html>