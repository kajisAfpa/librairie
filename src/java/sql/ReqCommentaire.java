package sql;

import beans.beanCommentaire;
import classes.Adresse;
import classes.Commande;
import classes.LigneCommande;
import classes.Membre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReqCommentaire {

    public Membre getCommentairValidator(String idMembre) throws ClassNotFoundException, SQLException {
    
    Membre m = new Membre();
    
    
    MaConnection mc = MaConnection.getInstance();
    
    String req = "select m.idMembre as membreId, m.typeMembre, m.nomMembre, m.prenomMembre, "
                    + "m.mailMembre, m.mdpMembre, m.telMembre, portMembre,  m.dateNaissanceMembre, m.actifMembre"
                    + " from Membre m "
            
            //chercher via num idMembre et numIsbn du livre qu'il veut commenter 
                    +"where m.idMembre = ?"; 
    

    
        PreparedStatement pstm = mc.prepareStatement(req);
        
        pstm.setString(1, idMembre);
        
        
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next()) {
                    m.setIdMembre(rs.getInt("membreId"));
                    m.setTypeMembre(rs.getInt("typeMembre"));
                    m.setNomMembre(rs.getString("nomMembre"));
                    m.setPrenomMembre(rs.getString("prenomMembre"));
                    m.setMailMembre(rs.getString("mailMembre"));
                    m.setMdpMembre(rs.getString("mdpMembre"));
                    m.setTelMembre(rs.getString("telMembre"));
                    m.setPortMembre(rs.getString("portMembre"));
                    m.setDateNaissanceMembre(rs.getString("dateNaissanceMembre"));
                    m.setActifMembre(rs.getInt("actifMembre"));
        }
        
        rs.close();
        pstm.close();
        
        
//        liste Adresse
        String reqAdresse = "select a.idAdresse, a.nomAdresse, a.prenomAdresse, a.typeAdresse, a.libelleAdresse, a.rueAdresse, a.cpAdresse, a.villeAdresse "
                + "from Adresse a "
                + "join Facturation f "
                + "on f.idAdresse = a.idAdresse "
                + "join Membre m "
                + "on  m.idMembre = f.idMembre "
                + "where m.idMembre = ? ";
        
                PreparedStatement pstm01 = mc.prepareStatement(reqAdresse);
            
            
                pstm01.setInt(1, m.getIdMembre());
                ResultSet rs01 = pstm01.executeQuery();
                while(rs01.next()){
                    Adresse adr  = new Adresse();
                    adr.setIdAdresse(Integer.valueOf(rs01.getString("idAdresse")));
                    adr.setNomAdresse(rs01.getString("nomAdresse"));
                    adr.setPrenomAdresse(rs01.getString("prenomAdresse"));
                    adr.setTypeAdresse(rs01.getString("typeAdresse"));
                    adr.setLibelleAdresse(rs01.getString("libelleAdresse"));
                    adr.setRueAdresse(rs01.getString("rueAdresse"));
                    adr.setCpAdresse(rs01.getString("cpAdresse"));
                    adr.setVilleAdresse(rs01.getString("villeAdresse"));
                    
                    m.getAdresses().add(adr);
                }
                rs01.close();
                pstm01.close();
    
    
    //liste de commande
                
                Commande c = new Commande();
                
        String reqCommande = "select com.idCommande, com.idMembre as comIdMembre, com.idAdresse, com.numeroCommande, com.etatCommande, com.fdpCommande, m.idMembre "
                +" from Commande com join Membre m on m.idMembre = com.idMembre "
                + "where m.idMembre = ? ";
        
                PreparedStatement pstm02 = mc.prepareStatement(reqCommande);
            
            
                pstm02.setInt(1, m.getIdMembre());
                ResultSet rs02 = pstm02.executeQuery();
                while(rs02.next()){
                    
                    c.setIdCommande(rs02.getInt("idCommande"));
                    c.setIdMembre(rs02.getInt("idMembre"));
                    c.setIdAdresse(rs02.getInt("idAdresse"));
                    c.setNumeroCommande(rs02.getString("numeroCommande"));
                    c.setEtatCommande(rs02.getInt("etatCommande"));
                    c.setFdpCommande(rs02.getFloat("fdpCommande"));
                    
                    m.getCommandes().add(c);
                }
                rs02.close();
                pstm02.close();
                
            
                
//           liste ligne de commande dans une commande
                
                String reqLigneCommande = "select ligne.idLigneCommande, ligne.idCommande as ligneIdCom, ligne.isbn13Livre as LigneIdLivre, "
                        + "ligne.prixLigneCommande, ligne.qtLigneCommande, ligne.TvaLigneCommande, com.idCommande, "
                        + " l.isbn13Livre, quantiteLivre,  dateLivre, poidsLivre, imageLivre, prixLivre,  titreLivre, sousTitreLivre, resumeLivre, edit.idEditeur as idEdit, edit.nomEditeur, a.idAuteur, a.nomAuteur, a.prenomAuteur, a.biographieAuteur, a.dateDecesAuteur, a.dateNaissanceAuteur, sst.idSousTheme, sst.nomSousTheme, tva.idTva, tva.nomTauxTva, tva.valeurTauxTva "
                + "from LigneCommande ligne "
                + "join Commande com on com.idCommande = ligne.idCommande "
                + "join livre l on ligne.isbn13Livre = l.isbn13Livre "
                        //editeur
                + "LEFT JOIN Editeur as edit "
                + "ON edit.idEditeur = l.idEditeur "
				 //fin editeur
				  
				 //auteur
                + "LEFT JOIN Ecriture as e "
                + "ON e.isbn13Livre = l.isbn13Livre "
                + "LEFT JOIN Auteur as a "
                + "ON a.idAuteur = e.idAuteur "
				 //fin auteur

				 //tva
                + "LEFT JOIN ApplicationTva as ap "
                + "ON ap.isbn13Livre = l.isbn13Livre "
                + "LEFT JOIN Tva as tva "
                + "ON tva.idTva = ap.idTva "
				 //fin tva

				 //sous theme
                + "LEFT JOIN Appartenance as app "
                + "ON l.isbn13Livre = app.isbn13Livre "
                + "LEFT JOIN SousTheme as sst "
                + "ON sst.idSousTheme = app.idSousTheme "
                + "where com.idCommande = 1 ";
        
//                PreparedStatement pstm03 = mc.prepareStatement(reqLigneCommande);
                Statement stm01 = mc.createStatement();
            
                
            for(int i = 0; i<m.getCommandes().size(); i++){
                Commande c01 = m.getCommandes().get(i);
//                pstm03.setInt(1, c01.getIdCommande());
//                ResultSet rs03 = pstm03.executeQuery();
                ResultSet rs03 = stm01.executeQuery(reqLigneCommande);
                while(rs03.next()){
                    LigneCommande ligne = new LigneCommande();
                    
                    ligne.setIdLigneCommande(rs03.getInt("idLigneCommande"));
                    ligne.setIdCommande(rs03.getInt("ligneIdCom"));
                    ligne.setPrixLigneCommande(rs03.getFloat("prixLigneCommande"));
                    ligne.setQtLigneCommande(rs03.getString("qtLigneCommande"));
                    ligne.setTvaLigneCommande(rs03.getFloat("TvaLigneCommande"));
                    
                    ligne.getLivreLigneCommande().setIdLivre(rs03.getString("isbn13Livre"));
                    ligne.getLivreLigneCommande().setIdLivre(rs03.getString("isbn13Livre"));
            ligne.getLivreLigneCommande().setTitreLivre(rs03.getString("titreLivre"));
            ligne.getLivreLigneCommande().setSousTitreLivre(rs03.getString("sousTitreLivre"));
            ligne.getLivreLigneCommande().setResumeLivre(rs03.getString("resumeLivre"));
            ligne.getLivreLigneCommande().setPoidsLivre(rs03.getFloat("poidsLivre"));
            ligne.getLivreLigneCommande().setDateLivre(rs03.getString("dateLivre"));
            ligne.getLivreLigneCommande().setImageLivre(rs03.getString("imageLivre"));
            ligne.getLivreLigneCommande().setQuantiteLivre(rs03.getInt("quantiteLivre"));
            ligne.getLivreLigneCommande().setPrixHTLivre(rs03.getFloat("prixLivre"));
            ligne.getLivreLigneCommande().getEditeurLivre().setIdEditeur(rs03.getInt("idEdit"));
            ligne.getLivreLigneCommande().getEditeurLivre().setNomEditeur(rs03.getString("nomEditeur"));
            ligne.getLivreLigneCommande().getAuteurLivre().setIdAuteur(rs03.getInt("idAuteur"));
            ligne.getLivreLigneCommande().getAuteurLivre().setNomAuteur(rs03.getString("nomAuteur"));
            ligne.getLivreLigneCommande().getAuteurLivre().setPrenomAuteur(rs03.getString("prenomAuteur"));
            ligne.getLivreLigneCommande().getAuteurLivre().setBiographieAuteur(rs03.getString("biographieAuteur"));
            ligne.getLivreLigneCommande().getAuteurLivre().setDateNaissanceAuteur(rs03.getString("dateNaissanceAuteur"));
            ligne.getLivreLigneCommande().getAuteurLivre().setDateDecesAuteur(rs03.getString("dateDecesAuteur"));
            ligne.getLivreLigneCommande().getSousThemeLivre().setIdSousTheme(rs03.getInt("idSousTheme"));
            ligne.getLivreLigneCommande().getSousThemeLivre().setNomSousTheme(rs03.getString("nomSousTheme"));
            ligne.getLivreLigneCommande().getTvaLivre().setIdTva(rs03.getInt("idTva"));
            ligne.getLivreLigneCommande().getTvaLivre().setNomTauxTva(rs03.getString("nomTauxTva"));
            ligne.getLivreLigneCommande().getTvaLivre().setValeurTauxTva(rs03.getFloat("valeurTauxTva"));

                    
                    
                    
                    c01.getLigneCommande().add(ligne);
                }
                rs03.close();
            }
            
//            pstm03.close();
            stm01.close();
            


    
    
        return m;
    
}
    

//    affichage commentaire
    
    public List<beanCommentaire> getListCommentaire(String isbn) throws ClassNotFoundException, SQLException {
        
        List<beanCommentaire> liste = new ArrayList();
        
        MaConnection mc = MaConnection.getInstance();
        
        String req="select com.idMembre, com.isbn13Livre, contenuCommenter, noteCommenter, dateCommenter, titreCommenter, "
                + "l.isbn13Livre as idLivre, m.idMembre as idMemb, m.nomMembre, m.prenomMembre from Commentaire com "
                + "join Membre m on com.idMembre = m.idMembre "
                + "join Livre l on com.isbn13Livre = l.isbn13Livre "
                + "where l.isbn13Livre = ?";
        
        PreparedStatement pstm = mc.prepareStatement(req);
        
        pstm.setString(1, isbn);
        
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next()) {
            
            beanCommentaire c = new beanCommentaire();
            
            c.getMembre().setIdMembre(rs.getInt("idMemb"));
            c.getMembre().setNomMembre(rs.getString("nomMembre"));
            c.getMembre().setPrenomMembre(rs.getString("prenomMembre"));
            c.getLivre().setIdLivre(rs.getString("idLivre"));
            c.setContenuCommenter(rs.getString("contenuCommenter"));
            c.setDateCommenter(rs.getString("dateCommenter"));
            c.setNoteCommenter(rs.getInt("noteCommenter"));
            c.setTitreCommenter(rs.getString("titreCommenter"));
            
            liste.add(c);
            
        }
        
        return liste;
        
    }
    
    /*
    public void insertCommentaire(int idMembre, String isbn, String contenu,  String titre, String date, int note) 
            throws ClassNotFoundException, SQLException {
        
        MaConnection mc = MaConnection.getInstance();
        
        String req = " INSERT INTO Commentaire (idMembre, isbn13Livre, contenuCommenter, "
                + "titreCommenter, dateCommenter, noteCommenter ) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?)";
        
        System.out.println(req);
        
        PreparedStatement pstm = mc.prepareStatement(req);
        
        pstm.setInt(1, idMembre);
        pstm.setString(2, isbn);
        pstm.setString(3, contenu);
        pstm.setString(4, titre);
        pstm.setString(5, date);
        pstm.setInt(6, note);
        
        
    }
    */
    
    public void insertCommentaire(String idMembre, String isbn, String contenu,  String titre, String date, String note) 
            throws ClassNotFoundException, SQLException {
        
        MaConnection mc = MaConnection.getInstance();
        
        String req = "INSERT INTO Commentaire (idMembre, isbn13Livre, contenuCommenter, titreCommenter, dateCommenter, noteCommenter ) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        System.out.println(req);
        
        PreparedStatement pstm = mc.prepareStatement(req);
        
        pstm.setString(1, idMembre);
        pstm.setString(2, isbn);
        pstm.setString(3, contenu);
        pstm.setString(4, titre);
        pstm.setString(5, date);
        pstm.setString(6, note);
        
        pstm.executeUpdate();
    }
    
    public static void main(String[] args) {
        ReqCommentaire req = new ReqCommentaire();
        
        try {
            req.insertCommentaire("6", "9782012710658", "commentaire via java", "titre", "2015-10-21", "3");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
//        
//        try {
//            for(beanCommentaire c : req.getListCommentaire("9782011691699")) {
//                System.out.println(c.toString());
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            ex.printStackTrace();
//        }
        
        
    }
    
    
    
    
}
