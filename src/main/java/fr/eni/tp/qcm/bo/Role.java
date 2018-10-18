package fr.eni.tp.qcm.bo;

public class Role extends Utilisateur {

    private int codeProfil;
    private String libelle;

    public int getCodeProfil() {
        return codeProfil;
    }

    public void setCodeProfil(int codeProfil) {
        this.codeProfil = codeProfil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Role(int idUtilisateur, String nom, String prenom, String email, String password) {
        super(idUtilisateur, nom, prenom, email, password);
    }

    public Role(int idUtilisateur, String nom, String prenom, String email, String password, int codeProfil, String libelle) {
        super(idUtilisateur, nom, prenom, email, password);
        this.codeProfil = codeProfil;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Role{" +
                "codeProfil=" + codeProfil +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
