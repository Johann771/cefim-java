package johann.airbnb.reservations;

import johann.airbnb.logements.Logement;

import java.sql.SQLOutput;
import java.util.Date;

public class SejourSaintValentin extends Sejour{
    private int nbBouteilleDeVouvray;

    public SejourSaintValentin(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        nbBouteilleDeVouvray = nbNuits;
    }


    @Override
    public boolean verificationNombreDeNuits() {
        return getNbNuits() < 5;
    }

    @Override
    public void miseAJourDuTarif() {
        tarif = getNbNuits() * getLogement().getTarifParNuit() - 10;
    }

    @Override
    public void afficher() {
        System.out.println("C'est un séjout pour la saint valentin et on va avoir "+ nbBouteilleDeVouvray+" de bouteilles de Vouvray");
        System.out.println("Prix du séjour "+tarif);
    }
}
