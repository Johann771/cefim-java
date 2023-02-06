package johann.airbnb.reservations;

import johann.airbnb.utilisateurs.Personne;

import java.util.Date;

public class Reservation {
    private int identifiant;
    private Sejour sejour;
    private Personne voyageur;
    private boolean estValidée;
    private Date dateDeReservation;

    public Reservation(Sejour sejour, Personne voyageur) {
        this.identifiant = 1;
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
