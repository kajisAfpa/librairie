package classes;


public class Tva {
    
    private int idTva;
    private float valeurTauxTva;
    private String nomTauxTva;
    
    public Tva(){
        
    }
    
    
    public Tva(int idTva, float valeurTauxTva, String nomTauxTva) {
        this.idTva = idTva;
        this.valeurTauxTva = valeurTauxTva;
        this.nomTauxTva = nomTauxTva;
    }

    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    public float getValeurTauxTva() {
        return valeurTauxTva;
    }

    public void setValeurTauxTva(float valeurTauxTva) {
        this.valeurTauxTva = valeurTauxTva;
    }

    public String getNomTauxTva() {
        return nomTauxTva;
    }

    public void setNomTauxTva(String nomTauxTva) {
        this.nomTauxTva = nomTauxTva;
    }

    @Override
    public String toString() {
        return valeurTauxTva+"";
    }
    
    
    
    
}
