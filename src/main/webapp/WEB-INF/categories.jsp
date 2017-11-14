<%@page import="javax.ejb.NoMoreTimeoutsException"%>
<%@page import="fr.sopra.GestionDesProduits"%>
<%@page import="fr.sopra.Fabriquant"%>
<%@page import="fr.sopra.Categorie"%>
<%@page import="fr.sopra.GestionDesProduits"%>
<%@ page import="java.util.Map, java.util.HashMap, java.util.List, java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories</title>

<link rel="stylesheet" href="categorie.css">

</head>
<body>

<h1>Liste des Categories :</h1>

<% Categorie categorie = (Categorie) request.getAttribute("categorie"); %>

<% List<Categorie> listeCategories = (List<Categorie>) request.getAttribute("listeCategories"); %>

 <% Map<Integer, Long> nbProduitsParCategorie = (Map<Integer, Long>) request.getAttribute("nbrProduitsParCategorie");%>

<table>

<tr>

<th>id</th>
<th>nom</th>
<th>nombre de produits</th>

</tr>

<% for (int i=0; i<listeCategories.size(); i++){%>

<tr class = "liste">

<td><%=listeCategories.get(i).getId()%></td>
<td><%=listeCategories.get(i).getNom()%></td>
<td><%= nbProduitsParCategorie.get(listeCategories.get(i).getId()) %></td>

<td>

<form method='get' action="http://localhost:8080/jpa-101-1.0-SNAPSHOT/edition.html" type = 'submit'>
	
	<input  type='hidden'  name='categorie' value='<%= listeCategories.get(i).getId()%>'/>
	<button class='agrandir2'>Editer</button>
	</form>
</td>

<td>
<form method='post' action="http://localhost:8080/jpa-101-1.0-SNAPSHOT/suppressionCategorie.html"  >
	
	<input  type='hidden' name="categorieSupprimer" value="<%= listeCategories.get(i).getId()%>"  />
	<button class='agrandir2'>X</button>
	</form>
	</td>
	</tr>
	<% } %>


</table>


	<br>
	<br>
	
<form method='get' action="http://localhost:8080/jpa-101-1.0-SNAPSHOT/edition.html" type = 'submit' >
 
	
	<button class='agrandir'>Nouvelle Categorie</button>
	</form>
	
	<br>
	<br>
	
	
	<center>
<h2> Liens :</h2>
<a href="fabriquants.html" >Liste des Fabriquants</a>
<br>
<a href="produits.html" >Liste des Produits</a>
	
</center>

</body>
</html>





