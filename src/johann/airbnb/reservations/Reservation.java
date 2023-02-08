package johann.airbnb.reservations;

import johann.airbnb.outils.MaDate;
import johann.airbnb.utilisateurs.Personne;
import johann.airbnb.utilisateurs.Voyageur;

import java.util.Date;

public class Reservation {
    private static int compteur = 0;
    private final int identifiant;
    private final Sejour sejour;
    private final Voyageur voyageur;
    private final boolean estValidée;
    private final MaDate dateDeReservation;

    public Reservation(Sejour sejour, Voyageur voyageur) {
        compteur++;
        this.identifiant = compteur;
        this.sejour = sejour;
        this.voyageur = voyageur;
        this.estValidée = false;
        this.dateDeReservation = new MaDate(6,2,2023);
    }
    public void afficher(){
        if(sejour.verificationDateArrivee()){

        }
        System.out.println("Réservation n° "+this.identifiant+" : ");
        System.out.println("Date de réservation : "+dateDeReservation);
        voyageur.afficher();
        System.out.println(" a fait une réservation chez : ");
        sejour.afficher();
    }
}
