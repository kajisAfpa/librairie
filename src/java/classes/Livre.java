package classes;


import java.util.ArrayList;
import java.util.HashMap;

public class Livre {

    private String idLivre;
    private String titreLivre;
    private String sousTitreLivre;
    private String dateLivre;
    private String resumeLivre;
    private String imageLivre;
    private float prixHTLivre;
    private float poidsLivre;
    private int quantiteLivre;

    private Auteur auteurLivre;
    private Editeur editeurLivre;
    private Tva tvaLivre;
    private SousTheme sousThemeLivre;
    private HashMap motsClefs;

    public Livre() {
    }

    public Livre(String idLivre, String titreLivre, String sousTitreLivre, String dateLivre, String resumeLivre, String imageLivre, float prixHTLivre, float poidsLivre, int quantiteLivre) {
        this.idLivre = idLivre;
        this.titreLivre = titreLivre;
        this.sousTitreLivre = sousTitreLivre;
        this.dateLivre = dateLivre;
        this.resumeLivre = resumeLivre;
        this.imageLivre = imageLivre;
        this.prixHTLivre = prixHTLivre;
        this.poidsLivre = poidsLivre;
        this.quantiteLivre = quantiteLivre;
    }

    public String getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(String idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getSousTitreLivre() {
        return sousTitreLivre;
    }

    public void setSousTitreLivre(String sousTitreLivre) {
        this.sousTitreLivre = sousTitreLivre;
    }

    public String getDateLivre() {
        return dateLivre;
    }

    public void setDateLivre(String dateLivre) {
        this.dateLivre = dateLivre;
    }

    public String getResumeLivre() {
        return resumeLivre;
    }

    public void setResumeLivre(String resumeLivre) {
        this.resumeLivre = resumeLivre;
    }

    public String getImageLivre() {
        return imageLivre;
    }

    public void setImageLivre(String imageLivre) {
        this.imageLivre = imageLivre;
    }

    public float getPrixHTLivre() {
        return prixHTLivre;
    }

    public void setPrixHTLivre(float prixHTLivre) {
        this.prixHTLivre = prixHTLivre;
    }

    public float getPoidsLivre() {
        return poidsLivre;
    }

    public void setPoidsLivre(float poidsLivre) {
        this.poidsLivre = poidsLivre;
    }

    public int getQuantiteLivre() {
        return quantiteLivre;
    }

    public void setQuantiteLivre(int quantiteLivre) {
        this.quantiteLivre = quantiteLivre;
    }

    public Auteur getAuteurLivre() {
        return auteurLivre;
    }

    public void setAuteurLivre(Auteur auteurLivre) {
        this.auteurLivre = auteurLivre;
    }

    public Editeur getEditeurLivre() {
        return editeurLivre;
    }

    public void setEditeurLivre(Editeur editeurLivre) {
        this.editeurLivre = editeurLivre;
    }

    public Tva getTvaLivre() {
        return tvaLivre;
    }

    public void setTvaLivre(Tva tvaLivre) {
        this.tvaLivre = tvaLivre;
    }

    public SousTheme getSousThemeLivre() {
        return sousThemeLivre;
    }

    public void setSousThemeLivre(SousTheme sousThemeLivre) {
        this.sousThemeLivre = sousThemeLivre;
    }

    public HashMap getMotsClefs() {
        return motsClefs;
    }

    public void setMotsClefs(HashMap motsClefs) {
        this.motsClefs = motsClefs;
    }

}
