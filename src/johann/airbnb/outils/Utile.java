package johann.airbnb.outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utile {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    private Utile(){}

    /**
    Une méthode permettant de construire une date à partir d’une chaîne de
    caractères au format "jj-MM-yyy".
     **/
    public static Date StringtoDate(String str){
        Date result = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            result = dateFormat.parse(str);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return result;
    }

    /**Une méthode permettant de renvoyer une chaîne de caractère formatée de la façon
    suivante : jour/mois/année (ex : 07/01/2020). Cette méthode prend en paramètre un
    objet de type Date. **/
    public static String DatetoString(Date date){
        return SIMPLE_DATE_FORMAT.format(date);
    }
    public static Date createDate(int jour, int mois, int annee){
        Date date = new Date(annee-1900, mois-1, jour);
        return date;
    }
    public static String DatetoString2(Date date){
        String jour = (date.getDate() < 10 ? "0" : "") + date.getDate();
        String mois = (date.getMonth() < 9 ? "0" : "") + (date.getMonth()+1);
        int annee = (date.getYear()+1900);
        return jour + "/" + mois + "/" + annee;
    }
}
