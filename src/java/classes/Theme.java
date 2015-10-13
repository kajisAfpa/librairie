package classes;

import java.util.HashMap;

public class Theme {
    
    private int idTheme;
    private String nomTheme;
    
    private HashMap sousThemeTheme;

    public Theme(int idTheme, String nomTheme) {
        this.idTheme = idTheme;
        this.nomTheme = nomTheme;
        this.sousThemeTheme = new HashMap<Integer, Theme>(); 
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getNomTheme() {
        return nomTheme;
    }

    public void setNomTheme(String nomTheme) {
        this.nomTheme = nomTheme;
    }

    public HashMap getSousThemeTheme() {
        return sousThemeTheme;
    }

    public void setSousThemeTheme(HashMap sousThemeTheme) {
        this.sousThemeTheme = sousThemeTheme;
    }

    @Override
    public String toString() {
        return nomTheme;
    }


    
    
    
}
