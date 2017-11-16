<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
 <link type="text/css" rel="stylesheet" href="connexion.css" />
</head>
<body>


<center>



<form method="post" >
            <fieldset>
                <legend>Inscription</legend>
                
                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <br />
                
                 <label for="nom">Prenom </label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                <br />
                
                <label for="nom">Login</label>
                <input type="text" id="login" name="login" value="" size="20" maxlength="20" />
                <br />

                <label for="email">Adresse email <span class="requis"></span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis"></span></label>
                <input type="password" id="motdepasse" name="password" value="" size="20" maxlength="20" />
                <br />
                <br>

                <input type="submit"  class="sansLabel" />
                <br />
            </fieldset>
        </form>
	
	
	
	
	</center>
















</body>
</html>