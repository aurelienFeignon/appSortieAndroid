package fr.eni.sortirapp.Bo;


import java.util.Date;

public class AddSortie {
    private String nom;
    private String idVille;
    private String idLieu;
    private Date dateHeureDebut;
    private Date dateLimiteInscriptions;
    private Integer nbInscriptionMax;
    private Integer duree;
    private String rueLieu;
    private String nomLieu;
    private String latitudeLieu;
    private String longitudeLieu;
    private String infosSortie;
    private Integer idOrganisateur;
    private Integer idCampus;


    public AddSortie(String nom, String idVille, String idLieu, Date dateHeureDebut, Date dateLimiteInscriptions, Integer nbInscriptionMax, Integer duree, String rueLieu, String nomLieu, String latitudeLieu, String longitudeLieu, String infosSortie, Integer idOrganisateur, Integer idCampus) {
        this.nom = nom;
        this.idVille = idVille;
        this.idLieu = idLieu;
        this.dateHeureDebut = dateHeureDebut;
        this.dateLimiteInscriptions = dateLimiteInscriptions;
        this.nbInscriptionMax = nbInscriptionMax;
        this.duree = duree;
        this.rueLieu = rueLieu;
        this.nomLieu = nomLieu;
        this.latitudeLieu = latitudeLieu;
        this.longitudeLieu = longitudeLieu;
        this.infosSortie = infosSortie;
        this.idOrganisateur = idOrganisateur;
        this.idCampus = idCampus;
    }

    public AddSortie() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdVille() {
        return idVille;
    }

    public void setIdVille(String idVille) {
        this.idVille = idVille;
    }

    public String getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(String idLieu) {
        this.idLieu = idLieu;
    }

    public Date getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(Date dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public Date getDateLimiteInscriptions() {
        return dateLimiteInscriptions;
    }

    public void setDateLimiteInscriptions(Date dateLimiteInscriptions) {
        this.dateLimiteInscriptions = dateLimiteInscriptions;
    }

    public Integer getNbInscriptionMax() {
        return nbInscriptionMax;
    }

    public void setNbInscriptionMax(Integer nbInscriptionMax) {
        this.nbInscriptionMax = nbInscriptionMax;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getRueLieu() {
        return rueLieu;
    }

    public void setRueLieu(String rueLieu) {
        this.rueLieu = rueLieu;
    }

    public String getNomLieu() {
        return nomLieu;
    }

    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }

    public String getLatitudeLieu() {
        return latitudeLieu;
    }

    public void setLatitudeLieu(String latitudeLieu) {
        this.latitudeLieu = latitudeLieu;
    }

    public String getLongitudeLieu() {
        return longitudeLieu;
    }

    public void setLongitudeLieu(String longitudeLieu) {
        this.longitudeLieu = longitudeLieu;
    }

    public String getInfosSortie() {
        return infosSortie;
    }

    public void setInfosSortie(String infosSortie) {
        this.infosSortie = infosSortie;
    }

    public Integer getIdOrganisateur() {
        return idOrganisateur;
    }

    public void setIdOrganisateur(Integer idOrganisateur) {
        this.idOrganisateur = idOrganisateur;
    }

    public Integer getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(Integer idCampus) {
        this.idCampus = idCampus;
    }
}
