package johann.airbnb.reservations;

import johann.airbnb.logements.Logement;

import java.util.Date;

public class Sejour {
    private  final Date dateArrivee;
    private  final int nbNuits;
    private  final Logement logement;
    private final int nbVoyageurs;

    public Sejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        this.dateArrivee = dateArrivee;
        this.nbNuits = nbNuits;
        this.logement = logement;
        this.nbVoyageurs = nbVoyageurs;
    }
    public void afficher(){
        logement.afficher();
        System.out.println("La date d'arrivée est le "+dateArrivee+" pour "+nbNuits+" nuits.");
        System.out.println("Le prix de ce séjour est de "+logement.getTarifParNuit()*nbNuits+"€.");
    }
}
