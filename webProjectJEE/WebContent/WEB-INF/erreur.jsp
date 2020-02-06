<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'erreur</title>
</head>
<body>
<h3>Oups... Erreur</h3>
	Problème : 
	<%=exception.getMessage()%>
</body>
</html>