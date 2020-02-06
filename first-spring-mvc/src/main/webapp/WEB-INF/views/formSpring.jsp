<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form spring page</title>
</head>
<body>
	Je suis :
	<br>
	<form:radiobuttons items="${ genre }" path="sexe" />
	<br>
	<form:checkboxes items="${ genre }" path="sexe" />
	<br>
	<form:select path="personnes">
		<form:option value="-" label="--Choisir une personne--" />
	</form:select>
	<br>
	<form:select path="personnes" items="${ personnes }" multiple="true" />
	<br>
	<form:select path="personnes" items="${ personnes }"/>
	<br>
	
	

</body>
</html>