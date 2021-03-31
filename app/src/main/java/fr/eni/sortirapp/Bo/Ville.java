package fr.eni.sortirapp.Bo;

public class Ville {
    private int id;
    private String nom;
    private String codePostal;

    public Ville(int id, String nom, String codePostal) {
        this.id = id;
        this.nom = nom;
        this.codePostal = codePostal;
    }

    public Ville() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
