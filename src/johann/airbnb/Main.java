package johann.airbnb;
import johann.airbnb.outils.Utile;
import johann.airbnb.reservations.*;
import johann.airbnb.logements.*;
import johann.airbnb.utilisateurs.*;
import java.util.Date;
import johann.airbnb.outils.*;
public class Main {
    public static void main(String[] args){

//        Voyageur voyageur = new Voyageur("Maxime", "Albert", 29);
        Hote hote = new Hote("Peter","Bardu", 28, 12);
//        Logement maison = new Maison(hote,40,"81 Rue Colbert, 37000 Tours",140,10);
//        Sejour vacances = new Sejour(new Date(),4,maison,1);
//        Reservation reservation = new Reservation(vacances, voyageur);
//        maison.afficher();
//        reservation.afficher();
       Maison Maison = new Maison(hote,40,"81 Rue Colbert, 37000 Tours",140,10,4, true);
//        appartement.afficher();
//        Date uneDate = new Date();
//        String DateString = Utile.DatetoString(uneDate);
//        System.out.println(DateString);
//        String uneDate2 = "06-02-2023";
//        Date StringDate = Utile.StringtoDate(uneDate2);
//        System.out.println(StringDate);
//        Date uneDate = Utile.createDate(13,2, 2002);
//        String result = Utile.DatetoString(uneDate);
//        System.out.println(result);
            MaDate unedate = new MaDate(29,6,2002);
            System.out.println(unedate.toString());
    }
}