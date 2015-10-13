/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import beans.beanLivre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cdi418
 */
public class ReqLivre {
    
    public List<beanLivre> getListeLivre() throws ClassNotFoundException, SQLException {
        
        List<beanLivre> liste = new ArrayList();
        
        MaConnection mc = MaConnection.getInstance();
    
    
    
        String req = "SELECT l.isbn13Livre, "
                + "quantiteLivre, "
                + "dateLivre, "
                + " poidsLivre, "
                + "imageLivre, "
                + "prixLivre, "
                + "titreLivre, "
                + " sousTitreLivre, "
                + "resumeLivre, "
                
                + "edit.idEditeur as idEdit, edit.nomEditeur, "  //dans livre
                + "a.idAuteur, a.nomAuteur, a.prenomAuteur, a.biographieAuteur, a.dateDecesAuteur, a.dateNaissanceAuteur, "
                + "sst.idSousTheme, sst.nomSousTheme, "
                + "tva.idTva, tva.nomTauxTva, tva.valeurTauxTva "
                + "FROM Livre as l "
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
				 //fin sous theme
                + "WHERE actifLivre = 1 " //  AND l.isbn13Livre = '9782011691699'
                + "ORDER BY titreLivre" ;
        
        System.out.println(req);
        
        Statement stm = mc.createStatement();
        
        ResultSet rs = stm.executeQuery(req);
        
        while(rs.next()) {
            
            beanLivre livre = new beanLivre();
            
            
            livre.setIdLivre(rs.getString("isbn13Livre"));
            livre.setTitreLivre(rs.getString("titreLivre"));
            livre.setSousTitreLivre(rs.getString("sousTitreLivre"));
            livre.setResumeLivre(rs.getString("resumeLivre"));
            livre.setPoidsLivre(rs.getFloat("poidsLivre"));
            livre.setDateLivre(rs.getString("dateLivre"));
            livre.setImageLivre(rs.getString("imageLivre"));
            livre.setQuantiteLivre(rs.getInt("quantiteLivre"));
            livre.setPrixHTLivre(rs.getFloat("prixLivre"));
            livre.getEditeurLivre().setIdEditeur(rs.getInt("idEdit"));
            livre.getEditeurLivre().setNomEditeur(rs.getString("nomEditeur"));
            livre.getAuteurLivre().setIdAuteur(rs.getInt("idAuteur"));
            livre.getAuteurLivre().setNomAuteur(rs.getString("nomAuteur"));
            livre.getAuteurLivre().setPrenomAuteur(rs.getString("prenomAuteur"));
            livre.getAuteurLivre().setBiographieAuteur(rs.getString("biographieAuteur"));
            livre.getAuteurLivre().setDateNaissanceAuteur(rs.getString("dateNaissanceAuteur"));
            livre.getAuteurLivre().setDateDecesAuteur(rs.getString("dateDecesAuteur"));
            livre.getSousThemeLivre().setIdSousTheme(rs.getInt("idSousTheme"));
            livre.getSousThemeLivre().setNomSousTheme(rs.getString("nomSousTheme"));
            livre.getTvaLivre().setIdTva(rs.getInt("idTva"));
            livre.getTvaLivre().setNomTauxTva(rs.getString("nomTauxTva"));
            livre.getTvaLivre().setValeurTauxTva(rs.getFloat("valeurTauxTva"));
//            a.idAuteur, a.nomAuteur, a.prenomAuteur, a.biographieAuteur, a.dateDecesAuteur, a.dateNaissanceAuteur, "
//                + "sst.idSousTheme, sst.nomSousTheme, "
//                + "tva.idTva, tva.nomTauxTva, tva.valeurTauxTva "
                    
                    
            liste.add(livre);
            
        }
        
        
        return liste;
        
    }
    
    public static void main(String[] args) {
        ReqLivre req = new ReqLivre();
        try {
            for(beanLivre l : req.getListeLivre()) {
                System.out.println(l.getTitreLivre() + " " + l.getSousTitreLivre() + " " + 
                        l.getEditeurLivre().getNomEditeur() + " " + l.getEditeurLivre().getIdEditeur() + " " +
                        l.getAuteurLivre().getBiographieAuteur() + " " + l.getAuteurLivre().getDateDecesAuteur() + " " +
                        l.getAuteurLivre().getDateNaissanceAuteur() + " " + l.getAuteurLivre().getNomAuteur() + " " +
                        l.getAuteurLivre().getPrenomAuteur() + " " + l.getAuteurLivre().getIdAuteur() + " " + 
                        l.getSousThemeLivre().getNomSousTheme() + l.getSousThemeLivre().getIdSousTheme() + " " +
                        l.getTvaLivre().getNomTauxTva() + " " + l.getTvaLivre().getValeurTauxTva() + " " + 
                        l.getTvaLivre().getIdTva()
                );
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
