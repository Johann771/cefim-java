package johann.airbnb.reservations;

import johann.airbnb.logements.Logement;

import java.util.Date;

public abstract class Sejour implements SejourInterface {
    private  final Date dateArrivee;
    private final int nbNuits;
    private  final Logement logement;
    private final int nbVoyageurs;
    protected int tarif;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
        this.miseAJourDuTarif();
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public int getNbNuits() {
        return nbNuits;
    }

    public Logement getLogement() {
        return logement;
    }

    public int getNbVoyageurs() {
        return nbVoyageurs;
    }

    public int getTarif() {
        return tarif;
    }

    @Override
    public boolean verificationDateArrivee() {
        Date dateactuelle = new Date();
        if (dateArrivee.after(dateactuelle)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public abstract boolean verificationNombreDeNuits();

    @Override
    public boolean verificationNombreDeVoyageurs() {
        if(this.nbVoyageurs <= logement.getNbVoyageursMax())
        {
            return true;

        } else{
            return false;
        }
    }
    public abstract void miseAJourDuTarif();
    public abstract void afficher();
}
