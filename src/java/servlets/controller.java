package servlets;

import beans.Authentification;
import beans.beanCommentaire;
import beans.beanLivre;
import classes.Membre;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sql.ReqCommentaire;
import sql.ReqLivre;
import sql.ReqMembre;
import sql.ReqTheme;

@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {
    
    private Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "/WEB-INF/jspIndex.jsp";

//        mes variable de scope application et session
        ServletContext application = this.getServletContext();
        HttpSession session = request.getSession();
        
        /* ---------------------------partie Index --------------------------------- */
        
//        si il ya un cookie on veut qu'il se connecte direct:
        ReqMembre reqMembre = new ReqMembre();
        
//        si cookie 'remember' existe(ayant comme valeur un id Membre), 
//        tu me set un nouvel attribut session(le nom de variable que j'utilise pour stocker l'objet membre habituellement) 
//        qui aura comme valeur un objet dont l'id est la valeur du cookie(idMembre)

        
        
         
        /* ---------------------------partie Authentification --------------------------------- */
        
        if(request.getParameter("log") != null) {
        
        url = "/WEB-INF/jspForm.jsp";
            
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String doIt = request.getParameter("doIt");

//        creation bean authentification ds le scope application
        Authentification auth= (Authentification) session.getAttribute("authentification");

//        si le bean Authentification n'existe pas encore, on le cree puis le set dans scope application
        if (auth == null) {
            auth = new Authentification();
            session.setAttribute("authentification", auth);
        }

        
        ReqMembre req = new ReqMembre();
        
            try {
                request.setAttribute("listeMembre", req.getListeMembre());
            } catch (ClassNotFoundException | SQLException ex) {
               ex.printStackTrace();
            }
        
        if( doIt != null ) {
        
        try {
            for(Membre m : req.getListeMembre()) {
                if(auth.check(login, password, m.getMailMembre(), m.getMdpMembre())) {
                    //go page de succes !
                 url = "/WEB-INF/jspSucces.jsp";
                 
                 //envoie variable de session, ainsi je recupere l'objet entier avec tout ses attributs(nom, prenom, adresse...)
                 session.setAttribute("auth", m);
                 
                 //envoie de la fonction qui check si c'est bien authentifié: si false on peut envoyer un msg d'erreur a la page du formulaire
                 request.setAttribute("check", auth.check(login, password, m.getMailMembre(), m.getMdpMembre()));   
                 
                if(request.getParameter("remember") != null) {
                    Cookie cc = new Cookie("remember", ""+m.getIdMembre());
                    //c.setMaxAge(60*2);
                    cc.setMaxAge(120);
                    response.addCookie(cc);
                }
                 
                }
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        }
        
        
        
        } //fin IF ?log
        
        if(request.getParameter("deconnection") != null) {
            if(session.getAttribute("auth") != null) {
                session.setAttribute("auth", null);
            }
        }
        
       
        
        /* ---------------------------partie compte --------------------------------- */
        
        if(request.getParameter("account") != null) {
            url = "/WEB-INF/jspAccount.jsp";
        }
        
        
        
        /* ---------------------------partie catalogue --------------------------------- */
        
        if(request.getParameter("catalog") != null) {
        
        url = "/WEB-INF/jspCatalog.jsp";

//        creation bean livre ds le scope application
        beanLivre livre = (beanLivre) application.getAttribute("livre");

//        si le bean livre n'existe pas encore, on le cree puis le set dans scope application
        if (livre == null) {
            livre = new beanLivre();
            application.setAttribute("livre", livre);
        }

//        instance ma methode sql listant tout mes livre
        ReqLivre reqListeLivre = new ReqLivre();

//        les bornes des pages
        int nbr_article = 10;
        int depart = 0;

        //nombre de page
        int nbrPage = 0;
        try {
            nbrPage = reqListeLivre.nbrTotalArticle() / nbr_article;
            
//            envoie a ma jsp variable nbre page
            request.setAttribute("nbrPage", nbrPage);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

//                si url page existe:
        if (request.getParameter("page") != null) {
//            article de depart est valeur get.page - 1 * nbr_article
            depart = (Integer.parseInt(request.getParameter("page")) - 1) * nbr_article;
        }

        //        affichage sur ma jsp
//        envoie de ma liste ds ma jsp via la metode request. nom de ma variable 'listeLivre'
        request.setAttribute("listeLivre", null);
        try {
            request.setAttribute("listeLivre", reqListeLivre.getListeLivre(depart, nbr_article));
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

//        on refait ce processus pour chaque cas d'affichage (affichage par sous theme, par search...)
        
        if (request.getParameter("categorie") != null) {
//            calcul nombre page
            try {
                nbrPage = reqListeLivre.nbrTotalArticleByCat(request.getParameter("categorie")) / nbr_article;
                request.setAttribute("nbr_article_trouve", reqListeLivre.nbrTotalArticleByCat(request.getParameter("categorie")));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
//            envoie a ma jsp variable nbre page
            request.setAttribute("nbrPage", nbrPage);

            //envoie de ma liste d'article a ma jsp
            try {
                request.setAttribute("listeLivre", reqListeLivre.getListeLivreByCat(depart, nbr_article, "" + request.getParameter("categorie")));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        

        if (request.getParameter("search") != null) {
            try {
                nbrPage = reqListeLivre.nbrTotalArticleBySearch(request.getParameter("search")) / nbr_article;
                request.setAttribute("nbr_article_trouve", reqListeLivre.nbrTotalArticleBySearch(request.getParameter("search")));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }

            //envoie a ma jsp variable nbre page
            request.setAttribute("nbrPage", nbrPage);

            //envoie de ma liste d'article a ma jsp
            try {
                request.setAttribute("listeLivre", reqListeLivre.getListeLivreBySearch(request.getParameter("search"), depart, nbr_article));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }

            //recherche global ds 'search'
        
        /*
        if (request.getParameter("searchTitre") != null) {
            try {
                nbrPage = reqListeLivre.nbrTotalArticleByTitre(request.getParameter("searchTitre")) / nbr_article;
                request.setAttribute("nbr_article_trouve", reqListeLivre.nbrTotalArticleByTitre(request.getParameter("searchTitre")));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }

            //envoie a ma jsp variable nbre page
            request.setAttribute("nbrPage", nbrPage);

            //envoie de ma liste d'article a ma jsp
            try {
                request.setAttribute("listeLivre", reqListeLivre.getListeLivreByTitre(request.getParameter("searchTitre"), depart, nbr_article));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
        if (request.getParameter("searchIsbn") != null) {
            try {
                nbrPage = reqListeLivre.nbrTotalArticleByIsbn(request.getParameter("searchIsbn")) / nbr_article;
                request.setAttribute("nbr_article_trouve", reqListeLivre.nbrTotalArticleByIsbn(request.getParameter("searchIsbn")));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }

            //envoie a ma jsp variable nbre page
            request.setAttribute("nbrPage", nbrPage);

            //envoie de ma liste d'article a ma jsp
            try {
                request.setAttribute("listeLivre", reqListeLivre.getListeLivreByIsbn(request.getParameter("searchIsbn"), depart, nbr_article));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }

        if (request.getParameter("searchAuteur") != null) {
            try {
                nbrPage = reqListeLivre.nbrTotalArticleByAuteur(request.getParameter("searchAuteur")) / nbr_article;
                request.setAttribute("nbr_article_trouve", reqListeLivre.nbrTotalArticleByAuteur(request.getParameter("searchAuteur")));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }

            //envoie a ma jsp variable nbre page
            request.setAttribute("nbrPage", nbrPage);

            //envoie de ma liste d'article a ma jsp
            try {
                request.setAttribute("listeLivre", reqListeLivre.getListeLivreByAuteur(request.getParameter("searchAuteur"), depart, nbr_article));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        */
        
        } //fin IF ?catalog
        
        /* ---------------------------partie commentaire Livre (droit de commenter)--------------------------------- */
        
        
//        si get CommentSend existe
        String comentSend = request.getParameter("comentSend");
        if (comentSend != null) {

            String msg_comment = null;
            String isbn = request.getParameter("isbn");
            String membre = request.getParameter("membre");
            String contenu = request.getParameter("contenu");
            String titre = request.getParameter("titre");

            //url = "/WEB-INF/jspComment.jsp";
//            stu verifie si l'utilisateur est authentifié
            if (session.getAttribute("auth") == null) {
//                si il ne lest pas tu lui renvoies un msg
                msg_comment = "Vous n'avez pas accès aux commentaires, connectez-vous à votre compte Membre";
                request.setAttribute("retour_comment", msg_comment);
            } else {
//                sinon si il est authentifié, tu fais appel a la methode qui check si il a acheté ce livre
                beanCommentaire commentaire = new beanCommentaire();
//                cette methode necessite le id Membre et le num isbn du livre a commenter
//                si ca return false:

                if (!commentaire.checkCommentaire(membre, isbn)) {
                    msg_comment = "Vous n'avez pas acheté ce livre, vous n'avez donc pas accès aux commentaires";
                    request.setAttribute("retour_comment", msg_comment);
                } else {
//                    sinon si ca return true
                    msg_comment = "Commentaire ajouté avec succès ! Merci d'avoir laissé votre avis";
                    request.setAttribute("retour_comment", msg_comment);

                    ReqCommentaire req = new ReqCommentaire();

                    try {
                        req.insertCommentaire(membre, isbn, contenu, titre, null, "3");
                    } catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        }

        
        
        
        /* ---------------------------partie detail Livre --------------------------------- */

        //page du detail du livre
        if (request.getParameter("detailLivre") != null) {
            url = "/WEB-INF/detailLivre.jsp";
            //instance ma methode sql prenant unlivre selon num isbn
            ReqLivre reqLivreDetail = new ReqLivre();

            //envoie de mon livre ds ma jsp via la metode request. nom de ma variable 'detailLivre'
            request.setAttribute("detailLivre", null);
            try {
                request.setAttribute("detailLivre", reqLivreDetail.getLivre(request.getParameter("detailLivre")));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
            
            //envoie affichage commentaire
            ReqCommentaire reqComLivre = new ReqCommentaire();
            String detailLivre = request.getParameter("detailLivre");
            try {
                request.setAttribute("listeCommentaire", reqComLivre.getListCommentaire(detailLivre));
            } catch (ClassNotFoundException | SQLException ex) {
               ex.printStackTrace();
            }
            
            if(request.getParameter("comentSend") != null) {
                request.setAttribute("comentSuccess", null);
            }

        } //fin if ?detailLivre
        
        

//        requete de ma liste de theme
        ReqTheme reqListTheme = new ReqTheme();

//        envoie a ma jsp liste theme
        try {
            request.setAttribute("ListeTheme", reqListTheme.getTheme());
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        

        request.getRequestDispatcher(url).include(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
