package fr.eni.sortirapp.Bo;

import androidx.annotation.NonNull;

import java.util.List;

public class Ville {
    private int id;
    private String nom;
    private String codePostal;
    private List<Lieu> lieux;

    public Ville(int id, String nom, String codePostal, List<Lieu> lieux) {
        this.id = id;
        this.nom = nom;
        this.codePostal = codePostal;
        this.lieux = lieux;
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

    public List<Lieu> getLieux() {
        return lieux;
    }

    public void setLieux(List<Lieu> lieux) {
        this.lieux = lieux;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
