package classes;



public class Editeur {

    private int idEditeur;
    private String nomEditeur;
    private String nomContactEditeur;
    private String telEditeur;
    private String mailEditeur;

    public Editeur() {
    }

    public Editeur(int idEditeur, String nomEditeur, String nomContactEditeur, String telEditeur, String mailEditeur) {
        this.idEditeur = idEditeur;
        this.nomEditeur = nomEditeur;
        this.nomContactEditeur = nomContactEditeur;
        this.telEditeur = telEditeur;
        this.mailEditeur = mailEditeur;
    }

    public int getIdEditeur() {
        return idEditeur;
    }

    public void setIdEditeur(int idEditeur) {
        this.idEditeur = idEditeur;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    public String getNomContactEditeur() {
        return nomContactEditeur;
    }

    public void setNomContactEditeur(String nomContactEditeur) {
        this.nomContactEditeur = nomContactEditeur;
    }

    public String getTelEditeur() {
        return telEditeur;
    }

    public void setTelEditeur(String telEditeur) {
        this.telEditeur = telEditeur;
    }

    public String getMailEditeur() {
        return mailEditeur;
    }

    public void setMailEditeur(String mailEditeur) {
        this.mailEditeur = mailEditeur;
    }

}
