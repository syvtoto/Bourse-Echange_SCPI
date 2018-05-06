<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Une erreur est survenue</title>
<% 
String orig = (String)request.getAttribute("orig");
String info = (String)request.getAttribute("info");
%>
</head>
<body>
<p><% out.print(info); %></p>
<p><a href='<% out.print(orig); %>'>Retour</a></p>
<p><a href="controleur?action=index">Retour à l'index</a></p>
</body>
</html>