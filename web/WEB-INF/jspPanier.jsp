<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspPanier
    Created on : 13 oct. 2015, 14:15:59
    Author     : cdi418
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Panier</h1>
        
    <c:forEach var="livre" items="${listePanier}">
        
        <h2>${livre.titreLivre}</h2><br>
        
    </c:forEach>
        
    </body>
</html>
