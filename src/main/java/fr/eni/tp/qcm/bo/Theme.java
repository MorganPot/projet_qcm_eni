package fr.eni.tp.qcm.bo;

public class Theme {
    private int idTheme;
    private String libelle;
    
    public Theme(){
    	
    }

    public Theme(int idTheme, String libelle) {
        this.idTheme = idTheme;
        this.libelle = libelle;
    }
    
    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "idTheme=" + idTheme +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
