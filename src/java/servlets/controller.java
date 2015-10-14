package servlets;

import beans.beanLivre;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sql.ReqLivre;


@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url ="/WEB-INF/jspCatalog.jsp";
        
//        mes variable de scope application et session
        
        ServletContext application = this.getServletContext();
        HttpSession session = request.getSession();
        
        
        
//        creation bean livre ds le scope application
        beanLivre livre = (beanLivre) application.getAttribute("livre");
        
//        si le bean livre n'existe pas encore, on le cree puis le set dans scope application
        if(livre == null) {
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
        if(request.getParameter("page") != null) {
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

       
        
        
        //page du detail du livre
        if(request.getParameter("detailLivre") != null) {
            url="/WEB-INF/detailLivre.jsp";
        //instance ma methode sql prenant unlivre selon num isbn
        ReqLivre reqLivreDetail = new ReqLivre();
        
        //envoie de mon livre ds ma jsp via la metode request. nom de ma variable 'detailLivre'
        request.setAttribute("detailLivre", null);
        try {
            request.setAttribute("detailLivre", reqLivreDetail.getLivre(request.getParameter("detailLivre")));
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        

        }
        
//        ma liste qui aura tout les livre du panier
//         scope session
         List<beanLivre> listePanier =  null;
//                 (List<beanLivre>) session.getAttribute("panier");
//         if(listePanier == null) {
             listePanier = new ArrayList();
//             session.setAttribute("panier", listePanier);
//         }
         
//        si un livre est envoyé au panier ---->
        if(request.getParameter("sendToPanier") != null) {
            url ="/WEB-INF/jspPanier.jsp";
           ReqLivre reqLivrePanier = new ReqLivre();
        
//           si url panier (parametre num isbn) est present
           if(request.getParameter("panier") != null) {
//               tu me cree un livre
               beanLivre livrePanier = new beanLivre();
//               ce livre a comme valeur la ligne de ma bdd WHERE isbn = request.getParameter("panier")
//               donc appel a ma methode qui prend tout les attributs WHERE isbn = ?
                try {
                    livrePanier = reqLivrePanier.getLivre(request.getParameter("panier"));
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
//                je prends ma liste Panier...
                listePanier.add(livrePanier);
//                ajoute le livre créé a celle ci et renvoie ma liste a ma jsp
                request.setAttribute("listePanier", listePanier);
           }
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
