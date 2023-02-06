package johann.airbnb;
import johann.airbnb.outils.Utile;
import johann.airbnb.reservations.*;
import johann.airbnb.logements.*;
import johann.airbnb.utilisateurs.*;
import java.util.Date;
import johann.airbnb.outils.*;
public class Main {
    public static void main(String[] args){

        Personne hote;
        Personne voyageur;
        Logement maison;
        Sejour vacances;
        Reservation reservation;
        voyageur = new Personne("Maxime", "Albert", 29);
        hote = new Personne("Peter","Bardu", 28);
        maison = new Logement(hote,40,"81 Rue Colbert, 37000 Tours",140,10);
        vacances = new Sejour(new Date(),4,maison,1);
        reservation = new Reservation(vacances, voyageur);
        reservation.afficher();


//        Date uneDate = new Date();
//        String DateString = Utile.DatetoString(uneDate);
//        System.out.println(DateString);
//
//        String uneDate2 = "06-02-2023";
//        Date StringDate = Utile.StringtoDate(uneDate2);
//        System.out.println(StringDate);


        Date uneDate = Utile.createDate(13,2, 2002);
        String result = Utile.DatetoString(uneDate);
        System.out.println(result);

    }
}