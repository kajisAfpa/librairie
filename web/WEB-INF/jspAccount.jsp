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
        
        <h1 class="page-header text-center">Mon compte</h1>
        
        <div class="container">
        
        <table class="table table-striped">
            
            <tr class="row">
                
                <td class="col-lg-4">Nom</td>
                <td class="col-lg-5">${auth.nomMembre}</td>
                <td class="col-lg-3"><button class="btn btn-primary">modifier</button> </td>
                
            </tr>
        
            
            <tr class="row">
                
                <td class="col-lg-4">Prenom</td>
                <td class="col-lg-5">${auth.prenomMembre}</td>
                <td class="col-lg-3"><button class="btn btn-primary">modifier</button> </td>
                
            </tr>
        
            
            <tr class="row">
                
                <td class="col-lg-4">Adresse Email</td>
                <td class="col-lg-5">${auth.mailMembre}</td>
                <td class="col-lg-3"><button class="btn btn-primary">modifier</button> </td>
                
            </tr>
        
            
            <tr class="row">
                
                <td class="col-lg-4">Telephone fixe</td>
                <td class="col-lg-5">${auth.telMembre}</td>
                <td class="col-lg-3"><button class="btn btn-primary">modifier</button> </td>
                
            </tr>
       
            
            <tr class="row">
                
                <td class="col-lg-4">Portable</td>
                <td class="col-lg-5">${auth.portMembre}</td>
                <td class="col-lg-3"><button class="btn btn-primary">modifier</button> </td>
                
            </tr>
       
            
            <tr class="row">
                
                <td class="col-lg-4">Date de naissance</td>
                <td class="col-lg-5">${auth.dateNaissanceMembre}</td>
                <td class="col-lg-3"><button class="btn btn-primary">modifier</button> </td>
                
            </tr>
        
            
            <tr class="row">
                
                <td class="col-lg-4">Nom</td>
                <td class="col-lg-5">${auth.nomMembre}</td>
                <td class="col-lg-3"><button class="btn btn-primary">modifier</button> </td>
                
            </tr>
        </table>
                
                
        </div>
    </body>
</html>
