<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="erreur.jsp" %>
<%@ page import="org.eclipse.model.Personne"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exercice personnes JEE</title>
</head>
<body>
	<h3>Liste des personnes</h3>
	<%
		Personne pers1 = (Personne) request.getAttribute("personne1");
		Personne pers2 = (Personne) request.getAttribute("personne2");
		Personne pers3 = (Personne) request.getAttribute("personne3");
		Personne pers4 = (Personne) request.getAttribute("personne4");

		List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");

		for (Personne personne : personnes) {
			out.print(personne + "<br>");
		}
	%>

	<h3>Personne demandée</h3>
	<%
		String id = (String) request.getAttribute("id");

		if (id != null) {
			switch (id) {
			case ("1"):
				out.print(pers1);
				break;
			case ("2"):
				out.print(pers2);
				break;
			case ("3"):
				out.print(pers3);
				break;
			case ("4"):
				out.print(pers4);
				break;
			default:
				out.print("");
			}
		}
	%>
	<h3>EL : Expression Language</h3>
	${ personne1 }
	<br> ${ personne1.nom }
	<br> ${ personne1.getNom() }
	<br> ${ personne1["nom"] }

	<h3>Sports</h3>
	${ sports.get(0) } ${ sports[0] } ${ sports['0'] } ${ sports["0"] }

	<p>J'aime le ${ sports.get(0) } mais je déteste le ${ sports.get(1) }.
		J'aime le ${ sports.get(2) } et le ${ sports.get(3) }.</p>

	<h3>Gestion des exceptions</h3>
	<%
	/* try { */
	/* 	int x = 3 / 0; */
	/* }
	catch (Exception e) {
		out.print("Erreur : " + e.getMessage());
	} */
	%>
</body>
</html>