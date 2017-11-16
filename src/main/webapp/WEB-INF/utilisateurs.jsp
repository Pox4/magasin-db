<%@page import="javax.ejb.NoMoreTimeoutsException"%>
<%@page import="fr.sopra.GestionDesProduits"%>
<%@page import="fr.sopra.Fabriquant"%>
<%@page import="fr.sopra.Categorie"%>
<%@page import="fr.sopra.GestionDesProduits"%>
<%@page import="fr.sopra.utilisateurs.GestionUtilisateur"%>
<%@page import="fr.sopra.utilisateurs.Utilisateurs"%>

<%@ page import="java.util.Map, java.util.HashMap, java.util.List, java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Utilisateurs</title>

<link rel="stylesheet" href="categorie.css">

</head>
<body>
<span><a href="deconnexion" >Deconnexion</a></span>

<h1>Liste des Utilisateurs :</h1>

<% Utilisateurs utilisateur = (Utilisateurs) request.getAttribute("utilisateur"); %>

<% List<Utilisateurs> listeUtilisateur = (List<Utilisateurs>) request.getAttribute("listeUtilisateur"); %>

 
<table>

<tr>

<th>Id</th>
<th>Prenom</th>
<th>Nom</th>
<th>Login</th>
<th>Password</th>

</tr>

<% for (int i=0; i<listeUtilisateur.size(); i++){%>

<tr class = "liste">

<td><%=listeUtilisateur.get(i).getId()%></td>
<td><%= listeUtilisateur.get(i).getPrenom() %></td>
<td><%= listeUtilisateur.get(i).getNom() %></td>
<td><%= listeUtilisateur.get(i).getLogin() %></td>
<td><%= listeUtilisateur.get(i).getPassword() %></td>


	<% } %>


</table>
	
	<br>
	<br>
	
	
	<center>
<h2> Liens :</h2>
<a href="fabriquants.html" >Liste des Fabriquants</a>
<br>
<a href="produits.html" >Liste des Produits</a>
<br>
<a href="categories.html" >Liste des Categories</a>
	
</center>

</body>
</html>