package johann.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MaDate extends java.util.Date {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public MaDate(long date) {
        super(date);
    }
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
