<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jstl Function</title>
</head>
<body>
	<h3>Jstl Function</h3>
	<c:out value="hello contient ${ fn:length('hello') } lettres"></c:out><br>
	<c:out value="${ fn:toUpperCase('hello world') }"></c:out>
	<h3>Jstl Format</h3>
	<c:set var="montant" value="112233.44" />
	montant = <fmt:formatNumber value="${ montant }" type="currency"/><br>
	montant = <fmt:formatNumber value="${ montant }" type="currency" currencySymbol="£"/><br>
	montant = <fmt:formatNumber value="${ montant }" type="currency" maxIntegerDigits="3"/><br>
</body>
</html>