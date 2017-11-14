<%@page import="fr.sopra.Fabriquant"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fabriquants Edit</title>
</head>
<body>


<% Fabriquant fabriquant = (Fabriquant) request.getAttribute("fabriquant"); %>


<h1> Edition de Fabriquant </h1>


<form method='post'  >
	
	<input  type='hidden'  name='fabriquantId' value="<%=fabriquant.getId() %>"  />
	<label> Nom du fabriquant : <input type="text" name = "fabriquantName" value="<%=fabriquant.getId()!=null?fabriquant.getId():"" %>"></label>
	<button class='agrandir'>OK</button>
	</form>









</body>
</html>