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

        <style>

        </style>


    </head>

    <body>

        <%@include file="jspHeader.jsp" %>

        <div class="container">

            <h1>detail detailLivre !</h1>

            <img src="http://lorempixel.com/400/200/"> <br>

            titre ${detailLivre.titreLivre} <br>
            sous titre ${detailLivre.sousTitreLivre} <br>


            resume ${detailLivre.resumeLivre}<br>
            prix ht ${detailLivre.prixHTLivre}<br>
            valeur tva ${detailLivre.tvaLivre.valeurTauxTva} <br>
            nom taux tva ${detailLivre.tvaLivre.nomTauxTva}<br>

            <h2>Carateristiques détaillées</h2>

            <table class="table">
                <tr>

                    <td>auteur nom-prenom</td>
                    <td>${detailLivre.auteurLivre.nomAuteur} ${detailLivre.auteurLivre.prenomAuteur}</td>

                </tr>

                <tr>

                    <td>nom editeur</td>
                    <td>${detailLivre.editeurLivre.nomEditeur}</td>

                </tr>

                <tr>

                    <td>date parution </td>
                    <td>${detailLivre.dateLivre}</td>

                </tr>

                <tr>

                    <td>num isbn</td>
                    <td>${detailLivre.idLivre}</td>

                </tr>

            </table>

            <%-- envoie au panier de l'article via son ID, je met un champ hidden panier pour que mon controller le detecte --%>
            <form method="get" action="controller">
                <input type="hidden" name="panier" value="${detailLivre.idLivre}" />
                <input class="btn btn-success" type="submit" name="sendToPanier" value="Ajouter" />

                

            </form>

            <h2 class="page-header text-center">partie commentaire</h2>

            <p class="text-danger text-center well">! Attention, seul les membres ayant acheté le livre sur notre site peuvent commenter, les autres peuvent seulement les consulter</p>

            <form method="get" action="controller">
                <div class="form-group">
                    <label for="titre">Titre</label>
                    <input class="form-control" id='titre' name="titre" type="text" placeholder="mettez l'idée general de votre commentaire en quelques mots" />
                </div>

                <div class="form-group">
                    <label for="contenu">Mon commentaire</label>

                    <textarea id="contenu" class="form-control" rows="3" name="contenu" placeholder='contenu de votre commentaire'></textarea>
                </div>

                <input type="hidden" name="detailLivre" />
                <input type="hidden" name="isbn" value="${detailLivre.idLivre}" />
                <input type="hidden" name="membre" value="${auth.idMembre}" />
                <button name="comentSend" type="submit" class="btn btn-default">Submit</button>
            </form>
isbn membre contenu titre date note


            <c:forEach var="commentaire" items="${listeCommentaire}">
                <div class="commentair">
                    <h4>${commentaire.membre.nomMembre} ${commentaire.membre.prenomMembre} :</h4> 
                    <p class="text-center text-primary">${commentaire.titreCommenter} - <small>${commentaire.dateCommenter}</small></p>

                    <blockquote>${commentaire.contenuCommenter}</blockquote>
                </div>
            </c:forEach>


    </body>
    <%@include file="jspFooter.jsp" %>