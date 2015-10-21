/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import beans.beanLivre;

/**
 *
 * @author kevin
 */
public class LigneCommande {
    
    private int idLigneCommande;
    private beanLivre livreLigneCommande;
    private int idCommande;
    private String qtLigneCommande;
    private Float prixLigneCommande;
    private Float TvaLigneCommande;

    public LigneCommande() {
        this.livreLigneCommande = new beanLivre();
    }

    public int getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(int idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public beanLivre getLivreLigneCommande() {
        return livreLigneCommande;
    }

    public void setLivreLigneCommande(beanLivre livreLigneCommande) {
        this.livreLigneCommande = livreLigneCommande;
    }

 



    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCmmande) {
        this.idCommande = idCmmande;
    }

    public String getQtLigneCommande() {
        return qtLigneCommande;
    }

    public void setQtLigneCommande(String qtLigneCommande) {
        this.qtLigneCommande = qtLigneCommande;
    }

    public Float getPrixLigneCommande() {
        return prixLigneCommande;
    }

    public void setPrixLigneCommande(Float prixLigneCommande) {
        this.prixLigneCommande = prixLigneCommande;
    }

    public Float getTvaLigneCommande() {
        return TvaLigneCommande;
    }

    public void setTvaLigneCommande(Float TvaLigneCommande) {
        this.TvaLigneCommande = TvaLigneCommande;
    }

    @Override
    public String toString() {
        return "LigneCommande{" + "idLigneCommande=" + idLigneCommande + ", livreLigneCommande=" + livreLigneCommande + ", idCommande=" + idCommande + ", qtLigneCommande=" + qtLigneCommande + ", prixLigneCommande=" + prixLigneCommande + ", TvaLigneCommande=" + TvaLigneCommande + '}';
    }

   

   
    
    
    
}


