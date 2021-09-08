package fr.eni.sortirapp.Bo;

import java.util.Date;
import java.util.List;

public class Sortie {
    private int id;
    private String nom;
    private Date dateHeureDebut;
    private int duree;
    private int nbInscriptionMax;
    private String infosSortie;
    private List<User> participants;
    private User organisateur;
    private Etat etat;
    private Date dateLimiteInsciption;
    private Campus campus;
    private Lieu lieu;

    public Sortie(int id, String nom, Date dateHeureDebut, int duree, int nbInscriptionMax, String infosSortie, List<User> participants, User organisateur, Etat etat, Date dateLimiteInsciption, Campus campus, Lieu lieu) {
        this.id = id;
        this.nom = nom;
        this.dateHeureDebut = dateHeureDebut;
        this.duree = duree;
        this.nbInscriptionMax = nbInscriptionMax;
        this.infosSortie = infosSortie;
        this.participants = participants;
        this.organisateur = organisateur;
        this.etat = etat;
        this.dateLimiteInsciption = dateLimiteInsciption;
        this.campus = campus;
        this.lieu = lieu;
    }

    public Sortie() {
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

    public Date getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(Date dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getNbInscriptionMax() {
        return nbInscriptionMax;
    }

    public void setNbInscriptionMax(int nbInscriptionMax) {
        this.nbInscriptionMax = nbInscriptionMax;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipant(List<User> participant) {
        this.participants = participant;
    }

    public User getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(User organisateur) {
        this.organisateur = organisateur;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Date getDateLimiteInsciption() {
        return dateLimiteInsciption;
    }

    public void setDateLimiteInsciption(Date dateLimiteInsciption) {
        this.dateLimiteInsciption = dateLimiteInsciption;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public String getInfosSortie() {
        return infosSortie;
    }

    public void setInfosSortie(String infosSortie) {
        this.infosSortie = infosSortie;
    }
}
