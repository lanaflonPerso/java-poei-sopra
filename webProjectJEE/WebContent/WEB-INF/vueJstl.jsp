<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL library</title>
</head>
<body>
	<c:out value="Hello world!"></c:out>
	<br>
	<!-- deux manières de demander une valeur par défaut (si la variable JEE n'est pas trouvée) -->
	<c:out value="${ JEE }" default="JSTL"></c:out>
	<c:out value="${ JEE }">JSTL</c:out>
	<!-- ... -->
	<br>
	<c:out value="<p>Bonjour 'John Wick'. </p>"></c:out>
	<c:out value="<p>Bonjour 'John Wick'. </p>" escapeXml="false"></c:out>
	<c:set var="JEE" value="J'aime la plateforme JEE." scope="request"></c:set>
	<c:out value="${ JEE }">JSTL</c:out>
	<c:set var="y" value="${ y + 1 }"></c:set>
	<br>
	<c:set var="x" value="${ 3 }"></c:set>
	<c:out value="x = ${ x }"></c:out>
	<br>
	<c:set var="y" value="${ y + 1 }"></c:set>
	<c:out value="y = ${ y }"></c:out>
	<br>
	<c:out value="x + y = ${ x + y }"></c:out>
	<br>
	<c:if test="${ 3 > 2 and 2 > 1 }" var="result" scope="session">
		<c:out value="${ result } : easy croquette!"></c:out>
	</c:if>
	<br>
	<h3>Exercice</h3>
	<c:set var="nbr" value="${ param.nbr }"></c:set>
	<c:if test="${ nbr > 0 }">
		<c:out value="${ nbr } est un nombre positif"></c:out>
	</c:if>
	<c:if test="${ nbr < 0 }">
		<c:out value="${ nbr } est un nombre négatif"></c:out>
	</c:if>
	<c:if test="${ nbr == 0 }">
		<c:out value="${ nbr } est un nombre nul"></c:out>
	</c:if>
	<h3>Exercice avec when... otherwise</h3>
	<c:set var="nbr2" value="${ param.nbr2 }"></c:set>
	<c:choose>
		<c:when test="${ nbr2 >0 }">${ nbr2 } est un nombre positif</c:when>
		<c:when test="${ nbr2 <0 }">${ nbr2 } est un nombre négatif</c:when>
		<c:when test="${ nbr2==0 }">${ nbr2 } est un nombre nul</c:when>
	</c:choose>
	<br>
	<h3>For Each : liste</h3>
	<c:forEach items="${ personnes }" var="element">
		<c:out value="${ element['nom'] }"></c:out>
		<br>
	</c:forEach>
	<h3>Affichage liste conditionnel</h3>
	<c:forEach items="${ personnes }" var="element" varStatus="status">
		<c:choose>
			<c:when test="${ status.count%2==0 }">
				<c:out value="${ status.count } : "></c:out>
				<c:out value="${ element['nom'] }"></c:out>
				<br>
			</c:when>
			<c:otherwise>
				<c:out value="${ status.count } : "></c:out>
				<c:out value="${ element['prenom'] }"></c:out>
				<br>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<h3>For Tokens</h3>
	<c:forTokens var="sousChaine" items="Bonjour, je m'appelle : John Wick"
		delims=" ">
	${ sousChaine } <br>
	</c:forTokens>
	<h3>Liens url</h3>
	<c:url value="/JstlServlet" var="monLien">
		<c:param name="nbr" value="1"></c:param>
		<c:param name="nbr2" value="-2"></c:param>
	</c:url>
	<a href="${ monLien}">Lien</a>
	<br>
	<h3>Liens url exercice</h3>
	<c:url value="/ExerciceServlet" var="LienExercice">
		<c:param name="id" value="1"></c:param>
	</c:url>
	<a href="${ LienExercice}">Retour à l'exercice</a>
</body>
</html>