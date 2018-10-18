package fr.eni.tp.qcm.bo;

public class Proposition {
    private int idProposition, idQuestion;
    private boolean estBonne, estRepondu;
    private String enonce;

    public Proposition() {
    	
    }
    
    public Proposition(int idProposition, int idQuestion, boolean estBonne, String enonce) {
        this.idProposition = idProposition;
        this.idQuestion = idQuestion;
        this.estBonne = estBonne;
        this.enonce = enonce;
    }

    public int getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(int idProposition) {
        this.idProposition = idProposition;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public boolean isEstBonne() {
        return estBonne;
    }

    public void setEstBonne(boolean estBonne) {
        this.estBonne = estBonne;
    }

    public boolean isEstRepondu() {
        return estRepondu;
    }

    public void setEstRepondu(boolean estRepondu) {
        this.estRepondu = estRepondu;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    @Override
    public String toString() {
        return "Proposition{" +
                "idProposition=" + idProposition +
                ", idQuestion=" + idQuestion +
                ", estBonne=" + estBonne +
                ", estRepondu=" + estRepondu +
                ", enonce='" + enonce + '\'' +
                '}';
    }
}
