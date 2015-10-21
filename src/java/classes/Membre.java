package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Membre {
    
    private int idMembre;
    private int typeMembre;
    private String mdpMembre;
    private String nomMembre;
    private String prenomMembre;
    private String dateNaissanceMembre;
    private String mailMembre;
    private String telMembre;
    private String portMembre;


    private int actifMembre;
    private List<Adresse> adresses;
    private List<Commande> commandes;

    


    
    public Membre(){
        adresses = new ArrayList();
        commandes = new ArrayList();
    }


    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(int typeMembre) {
        this.typeMembre = typeMembre;
    }

    public String getMdpMembre() {
        return mdpMembre;
    }

    public void setMdpMembre(String mdpMembre) {
        this.mdpMembre = mdpMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getDateNaissanceMembre() {
        return dateNaissanceMembre;
    }

    public void setDateNaissanceMembre(String dateNaissanceMembre) {
        this.dateNaissanceMembre = dateNaissanceMembre;
    }

    public String getMailMembre() {
        return mailMembre;
    }

    public void setMailMembre(String mailMembre) {
        this.mailMembre = mailMembre;
    }

    public String getTelMembre() {
        return telMembre;
    }

    public void setTelMembre(String telMembre) {
        this.telMembre = telMembre;
    }
    
        public String getPortMembre() {
        return portMembre;
    }

    public void setPortMembre(String portMembre) {
        this.portMembre = portMembre;
    }

    public int getActifMembre() {
        return actifMembre;
    }

    public void setActifMembre(int actifMembre) {
        this.actifMembre = actifMembre;
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        return "Membre{" + "idMembre=" + idMembre + ", typeMembre=" + typeMembre + ", mdpMembre=" + mdpMembre + ", nomMembre=" + nomMembre + ", prenomMembre=" + prenomMembre + ", dateNaissanceMembre=" + dateNaissanceMembre + ", mailMembre=" + mailMembre + ", telMembre=" + telMembre + ", portMembre=" + portMembre + ", actifMembre=" + actifMembre + ", adresses=" + adresses + ", commandes=" + commandes + '}';
    }
    
    
          
      }
    
    
    


    
    

