package fr.eni.tp.qcm.bo;

public class Promotion {

    private static final long serialVersionUID = 1L;
    private String codePromo, libelle;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(String codePromo) {
        this.codePromo = codePromo;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Promotion(String codePromo, String libelle) {
        this.codePromo = codePromo;
        this.libelle = libelle;
    }

    public Promotion(){

    }

    @Override
    public String toString() {
        return "Promotion{" +
                "codePromo='" + codePromo + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
