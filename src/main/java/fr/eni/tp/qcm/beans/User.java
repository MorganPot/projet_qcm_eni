package fr.eni.tp.qcm.beans;

public class User {
    /* Propriétés du bean */
    private String email;
    private String motPasse;

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMotPasse( String motPasse ) {
        this.motPasse = motPasse;
    }

    public String getMotPasse() {
        return motPasse;
    }
}