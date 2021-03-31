package fr.eni.sortirapp.Bo;

public class Lieu {
    private int id;
    private String nom;
    private String rue;
    private String latitude;
    private String Longitude;
    private Ville ville;

    public Lieu(int id, String nom, String rue, String latitude, String longitude, Ville ville) {
        this.id = id;
        this.nom = nom;
        this.rue = rue;
        this.latitude = latitude;
        Longitude = longitude;
        this.ville = ville;
    }

    public Lieu() {
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

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}
