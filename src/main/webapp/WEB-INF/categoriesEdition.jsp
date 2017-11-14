<%@page import="fr.sopra.Categorie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories Edit</title>
</head>
<body>


<% Categorie categorie = (Categorie) request.getAttribute("categorie"); %>

<h1> Edition de Categorie </h1>


<form method='post'  >
	
	<input  type='hidden'  name='categorieId' value="<%=categorie.getId() %>"  />
	<label> Nom de la categorie : <input type="text" name = "categorieName" value="<%=categorie.getId()!=null?categorie.getId():"" %>"></label>
	<button class='agrandir'>OK</button>
	</form>



</body>
</html>