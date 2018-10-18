package fr.eni.tp.qcm.bo;

import java.util.List;

public class Test {

    private int idTest, seuil_haut, seuil_bas;
    private String libelle, description;
    private float duree;
    private List<SectionTest> sectionTestList;

    public Test()
    {
    	
    }
    
    public Test(int idTest, float duree, String libelle, String description, int seuil_haut, int seuil_bas, List<SectionTest> sectionTestList) {
        this.idTest = idTest;
        this.duree = duree;
        this.libelle = libelle;
        this.description = description;
        this.seuil_haut = seuil_haut;
        this.seuil_bas = seuil_bas;
        this.sectionTestList = sectionTestList;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeuil_haut() {
        return seuil_haut;
    }

    public void setSeuil_haut(int seuil_haut) {
        this.seuil_haut = seuil_haut;
    }

    public int getSeuil_bas() {
        return seuil_bas;
    }

    public void setSeuil_bas(int seuil_bas) {
        this.seuil_bas = seuil_bas;
    }

    public List<SectionTest> getSectionTestList() {
        return sectionTestList;
    }

    public void setSectionTestList(List<SectionTest> sectionTestList) {
        this.sectionTestList = sectionTestList;
    }

    @Override
    public String toString() {
        return "Test{" +
                "idTest=" + idTest +
                ", duree=" + duree +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", seuil_haut=" + seuil_haut +
                ", seuil_bas=" + seuil_bas +
                ", sectionTestList=" + sectionTestList +
                '}';
    }
}
