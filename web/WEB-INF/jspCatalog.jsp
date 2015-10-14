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
        <link rel="stylesheet" href="css/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>


    </head>


    <body>



        <div class="container">



            <h1 class="page-header text-center">mon catalogue</h1>


            <div class="row">

                
                <%-- sommaire cote --%>
                <div class="col-md-2">

                    <ul class="sommaire nav nav-pills nav-stacked ">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#">Profile</a></li>
                        <li class="disabled"><a href="#">Disabled</a></li>
                        <li class="dropdown">
                            <a aria-expanded="false" class="dropdown-toggle" data-toggle="dropdown" href="#">
                                Dropdown <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                    </ul>

                </div>





                <div class="col-md-10">



                    <table class="table table-striped">



                        <c:forEach var="livre" items="${listeLivre}">

                            <%-- resume du livre en mode substring --%>
                            <c:set var="resume" value="${livre.resumeLivre}"/>
                            <c:set var="cutResume" value="${fn:substring(resume, 0, 70)}" />


                            <tr>

                            <div class="row">

                                <td class="col-md-2"> <img src="http://lorempixel.com/400/200/"></td>
                                <td class="col-md-6 contenu">

                                    <p class="title text-center">${livre.titreLivre} <small> - ${livre.sousTitreLivre}</small></p>
                                    <p>ecrit par: ${livre.auteurLivre.nomAuteur} ${livre.auteurLivre.prenomAuteur} <br>
                                        Résumé: ${cutResume}...
                                    </p>

                                </td>
                                <td class="col-md-2">

                                    <div style="height: 50px">
                                        <button class="btn-lg btn btn-default btn-block">${livre.prixHTLivre}€ HT </button>
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

                </div>
            </div>


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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="css/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

</html>
