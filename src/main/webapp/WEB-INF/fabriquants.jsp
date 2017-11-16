<%@page import="fr.sopra.Fabriquant"%>
<%@ page import="java.util.Map, java.util.HashMap, java.util.List, java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fabriquants</title>
<link rel="stylesheet" href="fabriquant.css">
</head>
<body>
<span><a href="deconnexion" >Deconnexion</a></span>
<div>
<h1>Liste des Fabriquants : </h1>
</div>

<% Fabriquant fabriquant = (Fabriquant) request.getAttribute("fabriquant"); %>

<% List<Fabriquant> listeFabriquants = (List<Fabriquant>) request.getAttribute("listeFabriquants"); %>

<% Map<Integer, Long> nbProduitsParFabriquant = (Map<Integer, Long>) request.getAttribute("nbrProduitsParFabriquant");%>

<table>

<tr>

<th>id</th>
<th>nom</th>
<th> Nombre de produits </th>

</tr>

<% for (int i=0; i<listeFabriquants.size(); i++){%>

<tr>

<td><%=listeFabriquants.get(i).getId()%></td>
<td><%=listeFabriquants.get(i).getNom()%></td>
<td><%=nbProduitsParFabriquant.get(listeFabriquants.get(i).getId())%></td>

<td>

<form method='get' action="http://localhost:8080/jpa-101-1.0-SNAPSHOT/editionfab.html" type = 'submit'>
	
	<input  type='hidden'  name='fabriquant' value='<%= listeFabriquants.get(i).getId()%>'/>
	<button class='agrandir2'>Editer</button>
	</form>
</td>

<td>
<form method='post' action="http://localhost:8080/jpa-101-1.0-SNAPSHOT//suppressionFabriquant.html" >
	
	<input  type='hidden' name="fabriquantSupprimer" value="<%= listeFabriquants.get(i).getId()%>"  />
	<button class='agrandir2'>X</button>
	</form>
	</td>
	</tr>
	<% } %>


</table>


	<br>
	<br>
	
<form method='get' action="http://localhost:8080/jpa-101-1.0-SNAPSHOT/editionfab.html" type = 'submit' >
	<button class='agrandir'>Nouveau Fabriquant</button>
	</form>
	
	
		<center>
<h2> Liens :</h2>
<a href="categories.html" >Liste des Categories</a>
<br>
<a href="produits.html" >Liste des Produits</a>
<br>
<a href="utilisateurs.html" >Liste des Utilisateurs</a>
	
</center>
	
	

</body>
</html>