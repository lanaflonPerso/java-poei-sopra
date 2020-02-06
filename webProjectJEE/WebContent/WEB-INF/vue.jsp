<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page import="org.eclipse.model.Personne" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java JEE</title>
</head>
<body>	
	<%
	Personne personne = new Personne();
	personne.setNum(1);
	personne.setNom("Wick");
	personne.setPrenom("John");
	out.print(personne +"<br>");
	Personne personneEnvoi=(Personne)request.getAttribute("personneEnvoi");
	out.print("Hello " + personneEnvoi.getPrenom() + " " + personneEnvoi.getNom() + " ! <br>");
	String notreVille =(String)request.getAttribute("maVille");
	out.print("Bienvenue à " + notreVille);
	%>
</body>
</html>