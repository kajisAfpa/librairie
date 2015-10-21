package classes;

import java.util.ArrayList;
import java.util.List;

public class Adresse {
    
    private int idAdresse;
    private String nomAdresse;
    private String prenomAdresse;
    private String typeAdresse;
    private String libelleAdresse;
    private String rueAdresse;
    private String cpAdresse;
    private String villeAdresse;
    private String paysAdresse;
    private List<Membre> membres;

   

    public Adresse() {
        membres = new ArrayList();
    }
    

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getNomAdresse() {
        return nomAdresse;
    }

    public void setNomAdresse(String nomAdresse) {
        this.nomAdresse = nomAdresse;
    }

    public String getPrenomAdresse() {
        return prenomAdresse;
    }

    public void setPrenomAdresse(String prenomAdresse) {
        this.prenomAdresse = prenomAdresse;
    }

    public String getTypeAdresse() {
        return typeAdresse;
    }

    public void setTypeAdresse(String typeAdresse) {
        this.typeAdresse = typeAdresse;
    }

    public String getLibelleAdresse() {
        return libelleAdresse;
    }

    public void setLibelleAdresse(String libelleAdresse) {
        this.libelleAdresse = libelleAdresse;
    }

    public String getRueAdresse() {
        return rueAdresse;
    }

    public void setRueAdresse(String rueAdresse) {
        this.rueAdresse = rueAdresse;
    }

    public String getCpAdresse() {
        return cpAdresse;
    }

    public void setCpAdresse(String cpAdresse) {
        this.cpAdresse = cpAdresse;
    }

    public String getVilleAdresse() {
        return villeAdresse;
    }

    public void setVilleAdresse(String villeAdresse) {
        this.villeAdresse = villeAdresse;
    }

    public String getPaysAdresse() {
        return paysAdresse;
    }

    public void setPaysAdresse(String paysAdresse) {
        this.paysAdresse = paysAdresse;
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }

    @Override
    public String toString() {
        return "Adresse{" + "idAdresse=" + idAdresse + ", nomAdresse=" + nomAdresse + ", prenomAdresse=" + prenomAdresse + ", typeAdresse=" + typeAdresse + ", cpAdresse=" + cpAdresse + ", villeAdresse=" + villeAdresse + ", membres=" + membres + '}';
    }
    

    
    
    
}
