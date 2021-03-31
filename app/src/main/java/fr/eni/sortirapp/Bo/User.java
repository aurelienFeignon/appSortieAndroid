package fr.eni.sortirapp.Bo;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int id;
    private String nom;
    private String prenom;
    private String username;
    private String telephone;
    private String cheminImg;
    private boolean administrateur;
    private boolean actif;
    private String apiToken;
    private  Campus campus;

    public User() {
    }

    protected User(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        prenom = in.readString();
        username = in.readString();
        telephone = in.readString();
        cheminImg = in.readString();
        administrateur = in.readByte() != 0;
        actif = in.readByte() != 0;
        apiToken = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCheminImg() {
        return cheminImg;
    }

    public void setCheminImg(String cheminImg) {
        this.cheminImg = cheminImg;
    }

    public boolean isAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(boolean administrateur) {
        this.administrateur = administrateur;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(username);
        dest.writeString(telephone);
        dest.writeString(cheminImg);
        dest.writeByte((byte) (administrateur ? 1 : 0));
        dest.writeByte((byte) (actif ? 1 : 0));
        dest.writeString(apiToken);
    }
}
