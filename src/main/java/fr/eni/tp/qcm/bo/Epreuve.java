package fr.eni.tp.qcm.bo;

import java.sql.Date;
import java.util.Calendar;

public class Epreuve {
    private static final long serialVersionUID = 1L;
    private int idEpreuve;
    private int idTest;
    private int idUtilisateur;
    private int tempsEcoule;
    private float noteObtenue;
    private String etat, niveauObtenu;
    private long debut;
	private long fin;

    public Epreuve()
    {
    	
    }
    
    public Epreuve(int idEpreuve, int idTest, int idUtilisateur, int tempsEcoule, float noteObtenue, String etat, String niveauObtenu, long debut, long fin) {
        this.idEpreuve = idEpreuve;
        this.idTest = idTest;
        this.idUtilisateur = idUtilisateur;
        this.tempsEcoule = tempsEcoule;
        this.noteObtenue = noteObtenue;
        this.etat = etat;
        this.niveauObtenu = niveauObtenu;
        this.debut = debut;
        this.fin = fin;
    }
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdEpreuve() {
        return idEpreuve;
    }

    public void setIdEpreuve(int idEpreuve) {
        this.idEpreuve = idEpreuve;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getTempsEcoule() {
        return tempsEcoule;
    }

    public void setTempsEcoule(int tempsEcoule) {
        this.tempsEcoule = tempsEcoule;
    }

    public float getNoteObtenue() {
        return noteObtenue;
    }

    public void setNoteObtenue(float noteObtenue) {
        this.noteObtenue = noteObtenue;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNiveauObtenu() {
        return niveauObtenu;
    }

    public void setNiveauObtenu(String niveauObtenu) {
        this.niveauObtenu = niveauObtenu;
    }

    public long getDebut() {
        return debut;
    }

    public void setDebut(long debut) {
        this.debut = debut;
    }

    public long getFin() {
        return fin;
    }

    public void setFin(long fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Epreuve{" +
                "idEpreuve=" + idEpreuve +
                ", idTest=" + idTest +
                ", idUtilisateur=" + idUtilisateur +
                ", tempsEcoule=" + tempsEcoule +
                ", noteObtenue=" + noteObtenue +
                ", etat='" + etat + '\'' +
                ", niveauObtenu='" + niveauObtenu + '\'' +
                ", debut=" + debut +
                ", fin=" + fin +
                '}';
    }
}
