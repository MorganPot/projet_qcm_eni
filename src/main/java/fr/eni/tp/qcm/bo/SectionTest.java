package fr.eni.tp.qcm.bo;

public class SectionTest {

    private int idTest, idTheme, nbQuestionATraiter;

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public int getNbQuestionATraiter() {
        return nbQuestionATraiter;
    }

    public void setNbQuestionATraiter(int nbQuestionATraiter) {
        this.nbQuestionATraiter = nbQuestionATraiter;
    }

    public SectionTest(int idTest, int idTheme, int nbQuestionATraiter) {
        this.idTest = idTest;
        this.idTheme = idTheme;
        this.nbQuestionATraiter = nbQuestionATraiter;
    }

    @Override
    public String toString() {
        return "SectionTest{" +
                "idTest=" + idTest +
                ", idTheme=" + idTheme +
                ", nbQuestionATraiter=" + nbQuestionATraiter +
                '}';
    }
}
