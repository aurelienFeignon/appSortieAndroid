package fr.eni.sortirapp.Bo;

public class Inscription {
    private int idParticipant;
    private int idSortie;

    public Inscription(int idParticipant, int idSortie) {
        this.idParticipant = idParticipant;
        this.idSortie = idSortie;
    }

    public Inscription() {
    }

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }

    public int getIdSortie() {
        return idSortie;
    }

    public void setIdSortie(int idSortie) {
        this.idSortie = idSortie;
    }
}
