<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deconnexion</title>
</head>
<body>
<h3>Vous êtes bien déconnecté(e)!</h3>
<c:url value="/first" var="main" />
<a href="${ main }">Connect</a> 
</body>
</html>