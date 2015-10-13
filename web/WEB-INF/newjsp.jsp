<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspCatalogue
    Created on : 12 oct. 2015, 11:20:47
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
        
        
            <h1>mon catalogue</h1>
            
            
            <table>

                
                ${listeLivre}
                
                <c:forEach var="livre" items="listeLivre">

                    
                    
                    <tr>
                    
                <div>
                    
                    <td> <img src="http://lorempixel.com/400/200/"></td>
                    <td>
                        <p>titre <small> - mon sous titre</small></p>
                        <p>ecrit par: auteur | petit passage du resume</p>
                        
                    </td>
                    <td>
                        <button class="btn btn-primary">voir détail</button>
                        
                        <button class="btn btn-success">+</button>
                        
                    </td>
                    
                </div>
                    
                </tr>
                
               
                </c:forEach>
                
                

                
            </table>
        
        
        
        
        </div>
        
    </body>
</html>
