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
        
        <h1 class="page-header text-center">Hello World!</h1>
        
        <div class="container">
            
            <c:if test="${(param.doIt!=null) && (!check)}">
                
                <div class="alert alert-danger text-center">Erreur d'identification !</div>
            </c:if>    
            
            <h2 class="page-header">mon Formulaire</h2>
            
            <form class="formConnection" method="controller">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                    <input class="form-control" type="text" placeholder="Votre adresse e-mail" name="login">
                </div>
               
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-lock"></span>
                    </span>
                    <input class="form-control" id="pass1" type="password" placeholder="Votre mot de passe" name="password">
                </div> 
                <input type="hidden" name="log" value=""/>

                <div class="checkbox">
                    <label>
                        <input name="remember" type="checkbox"> Se souvenir de moi !
                    </label>
                </div>
                <button type="submit" name="doIt" class="btn btn-default">Submit</button>
            </form>
            

            <ul>
                <c:forEach var="m" items="${listeMembre}">
                    <li>id: ${m.idMembre} - mdp: ${m.mdpMembre} - email : ${m.mailMembre}</li> <br>
                </c:forEach>
                
            </ul>
            
        </div>
    </body>
   <%@include file="jspFooter.jsp" %>
