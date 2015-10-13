<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <link rel="stylesheet" href="bootstrap-3.3.5-dist/css/bootstrap.min.css"/>

        <style>

            tr {
                box-sizing: content-box;
                transition: 0.1s linear;
                
            }


            td {
                //border: 1px solid black;
                height: 100px;
                max-height: 100px;
            }

            td img {
                width: 100%;
            }

            .title {
                border-bottom: #eee solid 1px;
                background: #fff;
            }

            tr:hover {
                //border-left: 5px solid #0D87E9;
                box-shadow: 2px 3px 5px #ebebeb;

            }
            
            .contenu p {
                height: 30px;
            }





        </style>

    </head>
    <body>

        <div class="container">


            <h1 class="page-header text-center">mon catalogue</h1>


            <table class="table table-striped">



                <c:forEach var="livre" items="${listeLivre}">

                    <%-- resume du livre en mode substring --%>
                    <c:set var="resume" value="${livre.resumeLivre}"/>
                    <c:set var="cutResume" value="${fn:substring(resume, 0, 100)}" />


                    <tr>

                    <div class="row">

                        <td class="col-md-2"> <img src="http://lorempixel.com/200/150/"></td>
                        <td class="col-md-8 contenu">

                            <p class="title text-center">${livre.titreLivre} <small> - ${livre.sousTitreLivre}</small></p>
                            <p>ecrit par: ${livre.auteurLivre.nomAuteur} ${livre.auteurLivre.prenomAuteur} <br>
                                Résumé: ${cutResume}...
                            </p>

                        </td>
                        <td class="col-md-2">

                            <div style="height: 50px">
                                <button class="btn-lg btn btn-danger">HT ${livre.prixHTLivre}</button>
                            </div>

                            <div style="height: 50px">
                                <a href="controller?detailLivre=${livre.idLivre}"><button class="btn btn-primary">voir détail</button></a>

                                <button class="btn btn-success">+</button>
                            </div>


                        </td>

                    </div>

                    </tr>


                </c:forEach>




            </table>


            <h2 class="page-header text-center">Pagination, la VRAIE !!</h2>


            <nav>
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>

                    <c:forEach varStatus="i" begin="1" end="${nbrPage + 1}">

                        <li><a href="controller?page=${i.index}">${i.index}</a></li>  

                    </c:forEach>

                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>



        </div>

    </body>
</html>
