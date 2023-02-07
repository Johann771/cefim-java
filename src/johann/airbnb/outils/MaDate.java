package johann.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MaDate extends java.util.Date {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * @author Johann Weytens
     * @param jour jour entre 1 et 31
     * @param mois mois entre 1 et 12
     * @param annee annee du style 2023
     */
    public MaDate(int jour, int mois, int annee){
        super(annee-1900,mois-1,jour);
    }

    @Override
    public String toString() {
        return (this.getDate() < 10 ? "0" : "") +
                this.getDate()+"/"+(this.getMonth() < 9 ? "0" : "")
                + (this.getMonth()+1)+"/"+(this.getYear()+1900);
    }
}
