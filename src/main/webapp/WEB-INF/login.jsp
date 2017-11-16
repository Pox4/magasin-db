<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="fr.sopra.utilisateurs.Utilisateurs"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="connexion.css" />
<title>Login</title>
</head>
<body>


<% Utilisateurs utilisateur = (Utilisateurs) request.getAttribute("utilisateur"); %>






<center>



<form method="post" >
            <fieldset>
                <legend>Inscription</legend>
                
                <label for="nom">Login </label>
                <input type="text" id="nom" name="login" value="" size="20" maxlength="20" />
                <br />
                
                 <label for="nom">Mot de passe </label>
                <input type="password" id="nom" name="password" value="" size="20" maxlength="20" />
                <br />
                
            

                <input type="submit"  class="sansLabel" />
                <br />
            </fieldset>
        </form>
	
	
	
	
	</center>















	
	<br>
	<br>
	
	<a href="inscription.html" >S'inscrire</a>



</body>
</html>