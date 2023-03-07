package johann.airbnb.logements;

import johann.airbnb.utilisateurs.Hote;
import johann.airbnb.utilisateurs.Personne;


public  abstract class Logement extends Object implements Comparable<Logement> {

    private String name;
    private Hote hote;
    private int tarifParNuit;
    private String adresse;
    private int superficie;
    private int nbVoyageursMax;

    public Logement(String name, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        super();
        this.name = name;
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }
    public String getName() {
        return name;
    }
    public int getSuperficie() {
        return superficie;
    }

    public Hote getHote() {
        return hote;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }

    public abstract int getSuperficeTotale();

    public abstract void afficher();

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Logement o) {
        return this.getTarifParNuit() - o.getTarifParNuit();
    }
}