<%@page import="fr.sopra.GestionDesProduits"%>
<%@page import="fr.sopra.Fabriquant"%>
<%@page import="fr.sopra.Categorie"%>
<%@page import="fr.sopra.Produit"%>
<%@ page
	import="java.util.Map, java.util.HashMap, java.util.List, java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Produits</title>
<link rel="stylesheet" href="produit.css">
</head>
<body>

	<div>
		<h1>Liste des Produits :</h1>
	</div>
	<br>
	<br>
	
	
	<center>
	<form>
    <label>Rechercher un produit par nom : <input type="text" name="search"></label>
    
    <br>
    <br>
    
    <button class="agrandir2">OK</button>
    
</form>

<br>
<br>
<br>

</center>

	<%
		List<Produit> listeProduits = (List<Produit>) request.getAttribute("listeProduits");
	
	%>

	<table>

		<tr>

			<th>id</th>
			<th>nom</th>
		    <th>Reference</th> 
			<th>Categorie</th>
			<th>Fabriquant</th> 
			

		</tr>

		<%
			for (int i = 0; i < listeProduits.size(); i++) {
		%>

		<tr>

			<td><%=listeProduits.get(i).getId()%></td>
			<td><%=listeProduits.get(i).getNom()%></td>
			 <td><%=listeProduits.get(i).getReference()%></td>
			<td><%=listeProduits.get(i).getCategorie().getNom()%></td>
			<td><%=listeProduits.get(i).getFabriquant().getNom()%></td> 

			<td>

				<form method='get'
					action="http://localhost:8080/jpa-101-1.0-SNAPSHOT/editionprod.html"
					type='submit'>

					<input type='hidden' name='produit'
						value='<%=listeProduits.get(i).getId()%>' />
					<button class='agrandir2'>Editer</button>
				</form>
			</td>

			<td>
				<form method='post'
				action="http://localhost:8080/jpa-101-1.0-SNAPSHOT/supprimerProduit">

					<input type='hidden' name="produitSupprimer"
						value="<%=listeProduits.get(i).getId()%>" />
					<button class='agrandir2'>X</button>
				</form>
			</td>
		</tr>
		<%
			}
		%>


	</table>
	


	<br>
	<br>
<center>
	<form method='get'
		action="http://localhost:8080/jpa-101-1.0-SNAPSHOT/editionprod.html"
		type='submit'>
		

		<button class='agrandir'>Nouveau Produit</button>
	</form>
	</center>
	
	<br>
	<br>
	
			<center>
<h2> Liens :</h2>
<a href="categories.html" >Liste des Categories</a>
<br>
<a href="fabriquants.html" >Liste des Fabriquants</a>
	
</center>


<center>
<h2> Lien de téléchargement :</h2>
<a href="export.xls" download="export.xls">Télécharger</a>
	
</center>

</body>
</html>