package fr.eni.tp.qcm.bo;

import java.util.List;

public class Question {

    private static final long serialVersionUID = 1L;
    private int idQuestion, idTheme, points;
    private String enonce, media;
    private List<Proposition> propositions;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public List<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }

    public Question(int idQuestion, int idTheme, int points, String enonce, String media, List<Proposition> propositions) {
        this.idQuestion = idQuestion;
        this.idTheme = idTheme;
        this.points = points;
        this.enonce = enonce;
        this.media = media;
        this.propositions = propositions;
    }
    
    public Question() {
        
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", idTheme=" + idTheme +
                ", points=" + points +
                ", enonce='" + enonce + '\'' +
                ", media='" + media + '\'' +
                ", propositions=" + propositions +
                '}';
    }
}
