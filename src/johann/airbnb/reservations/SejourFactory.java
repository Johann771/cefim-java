package johann.airbnb.reservations;

import johann.airbnb.logements.Logement;
import johann.airbnb.outils.MaDate;

import java.util.Date;

public class SejourFactory {

    private static final Date DATE_SAINT_VALENTIN = new MaDate(14,2,2023);
    private static final int NB_NUITS = 5;


    public static Sejour createSejour(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs){
        Sejour sejour;
        if (dateArrivee.equals(DATE_SAINT_VALENTIN)&& nbNuits < 5 && nbVoyageurs == 2){
            sejour = new SejourSaintValentin(dateArrivee, nbNuits, logement, nbVoyageurs);
        }
        else if (nbNuits > 5){
            sejour = new SejourLong(dateArrivee, nbNuits, logement, nbVoyageurs);
        } else {
            sejour = new SejourCourt(dateArrivee,nbNuits,logement,nbVoyageurs);
        }
        return sejour;
    }
}
