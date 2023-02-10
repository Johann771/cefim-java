package johann.airbnb.reservations;

import johann.airbnb.outils.MaDate;
import johann.airbnb.utilisateurs.Personne;
import johann.airbnb.utilisateurs.Voyageur;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Reservation {
    private static int compteur = 0;
    private final int identifiant;
    private final Sejour sejour;
    private final Voyageur voyageur;
    private final boolean estValidée;
    private final MaDate dateDeReservation;

    public Reservation(Sejour sejour, Voyageur voyageur) throws Exception {

        if(sejour != null){
            throw new Exception("Sejour null");
        }
        // Vérification de la date d'arrivée
        if (!sejour.verificationDateArrivee()) {
            throw new IllegalArgumentException("Erreur avec la date d'arrivée");
        }
        //Vérification du nombre de nuits
        if (!sejour.verificationNombreDeNuits()) {
            throw new Exception("Erreur avec le nombre de nuits");
        }
        // Vérification du nombre de voyageurs
        if (!sejour.verificationNombreDeVoyageurs()) {
            throw new Exception("Erreur avec le nombre de voyageurs");
        }

                compteur++;
                this.identifiant = compteur;
                this.sejour = sejour;
                this.voyageur = voyageur;
                this.estValidée = false;
                this.dateDeReservation = new MaDate(6,2,2023);
        try {
            FileWriter fw = new FileWriter("reservations.txt", true);
            fw.write(this.toString() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return this.identifiant + "," + this.sejour.toString() + "," + this.voyageur + "," + this.estValidée + "," + this.dateDeReservation;
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
