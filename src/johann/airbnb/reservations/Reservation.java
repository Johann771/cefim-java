package johann.airbnb.reservations;

import johann.airbnb.utilisateurs.Personne;

import java.util.Date;

public class Reservation {
    private static int compteur = 0;
    private int identifiant;
    private Sejour sejour;
    private Personne voyageur;
    private boolean estValidée;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Personne voyageur) {
        compteur++;
        this.identifiant = compteur;
        this.sejour = sejour;
        this.voyageur = voyageur;
        this.estValidée = false;
        this.dateDeReservation = new Date();
    }
    public void afficher(){
        voyageur.afficher();
        System.out.println("a fait une réservation chez : ");
        sejour.afficher();
    }
}
