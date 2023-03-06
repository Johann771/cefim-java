package johann.airbnb.logements;

import johann.airbnb.utilisateurs.Hote;
import johann.airbnb.utilisateurs.Personne;


public abstract class Logement extends Object {

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
}