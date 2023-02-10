package johann.airbnb;
import johann.airbnb.outils.Utile;
import johann.airbnb.reservations.*;
import johann.airbnb.logements.*;
import johann.airbnb.utilisateurs.*;
import java.util.Date;
import johann.airbnb.outils.*;


public class Main {
    public static void main(String[] args){
        Hote hote = new Hote("Johann", "Weytens", 20, 5);
        Maison maison = new Maison(hote,50,"25 rue des oliviers",60,8,100, true);
        MaDate maDate = new MaDate(14,2,2023);
        Sejour sejour = SejourFactory.createSejour(maDate, 5,maison,7);
        Voyageur voyageur = new Voyageur("Peter","Bardu",28);
        try {
            Reservation reservation = new Reservation(sejour,voyageur);
            reservation.afficher();
        }catch (Exception e){
            System.out.println(""+e);

        }

        Hote hote1 = new Hote("Bardu", "Peter",21, 12);
        Voyageur voyageur1 = new Voyageur("Martin", "Jean", 41);
        // Infos de la maison
        Logement maison2 = new Maison(hote1,30,"5 rue des logements",120,6,1000,true);
        Logement appartement = new Appartement(hote1,100, "3 rue des logements",120,6,12,123);
        Logement logement3 = new Maison(hote1,1500,"4 rue des montagnes", 100,12,100,true);
        // critère
        int nbNuits = 30;
        Date date2 = new MaDate(11,2,2023);
        int nbVoyageurs = 12;
        Sejour sejour2;
        Date dateSaintValentin = new MaDate(14,02,2023);
        if (nbNuits > 5){
            sejour2 = SejourFactory.createSejour(date2, nbNuits, logement3, nbVoyageurs);
        } else {
            sejour2 = new SejourCourt(date2,nbNuits,logement3,nbVoyageurs);
        }
        Sejour sejour3 = SejourFactory.createSejour(maDate,20,logement3,6);
        Reservation reservation1 = null;
        try {
            reservation1 = new Reservation(sejour2,voyageur1);
            reservation1.afficher();

        } catch (Exception e) {
            System.out.println("Exception : "+ e);
        }
    }
}