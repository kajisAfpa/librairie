/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class Commande {
    
    private int idCommande;
    private int idMembre;
    private int idAdresse;
    private String numeroCommande;
    private String dateCommande;
    private int etatCommande;
    private Float fdpCommande;
    private List<LigneCommande> ligneCommande;

    public Commande() {
        this.ligneCommande = new ArrayList();
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(String numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(int etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Float getFdpCommande() {
        return fdpCommande;
    }

    public void setFdpCommande(Float fdpCommande) {
        this.fdpCommande = fdpCommande;
    }

    public List<LigneCommande> getLigneCommande() {
        return ligneCommande;
    }

    public void setLigneCommande(List<LigneCommande> ligneCommande) {
        this.ligneCommande = ligneCommande;
    }

    @Override
    public String toString() {
        return "Commande{" + "idCommande=" + idCommande + ", idMembre=" + idMembre + ", idAdresse=" + idAdresse + ", numeroCommande=" + numeroCommande + ", dateCommande=" + dateCommande + ", etatCommande=" + etatCommande + ", fdpCommande=" + fdpCommande + ", ligneCommande=" + ligneCommande + '}';
    }

  
    
    
    
}
