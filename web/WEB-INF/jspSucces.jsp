<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>


    </head>

    <body>
        
        <%@include file="jspHeader.jsp" %>
        
        <h1 class="page-header text-center">Success ! </h1>
        
        <div class="container">
            
        
        <div class="alert alert-success text-center">Bravo ${auth.nomMembre} ${auth.prenomMembre}, tu t'es connecté avec succès mon ga !</div>
        
        
        
        </div>
        
    </body>
</html>
