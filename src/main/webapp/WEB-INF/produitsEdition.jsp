<%@page import="fr.sopra.Fabriquant"%>
<%@page import="fr.sopra.Produit"%>
<%@page import="fr.sopra.Categorie"%>

<%@ page import="java.util.Map, java.util.HashMap, java.util.List, java.util.ArrayList" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<% Produit produit = (Produit) request.getAttribute("produit"); %>
<% List<Fabriquant> listeFabriquants = (List<Fabriquant>) request.getAttribute("listeFabriquants"); %>
<% List<Categorie> listeCategories = (List<Categorie>) request.getAttribute("listCategories"); %>



<h1> Edition de Produit </h1>


<form method='post'  >
	
	<input  type='hidden'  name='produitId' value="<%=produit.getId() %>"  />
	<label> Nom du produit : <input type="text" name = "produitName" value="<%=produit.getId()!=null?produit.getId():"" %>"></label>
	<button class='agrandir'>OK</button>
	</form>







</body>
</html>