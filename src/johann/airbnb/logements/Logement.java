package johann.airbnb.logements;

import johann.airbnb.utilisateurs.Hote;
import johann.airbnb.utilisateurs.Personne;

public abstract class Logement {
    private final Hote hote;
    private final int tarifParNuit;
    private final String adresse;
    private final int superficie;
    private final int nbVoyageursMax;

    public Hote getHote() {
        return hote;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getSuperficie() {
        return superficie;
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }

    public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax) {
        this.hote = hote;
        this.tarifParNuit = tarifParNuit;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbVoyageursMax = nbVoyageursMax;
    }

    public int getTarifParNuit() {
        return tarifParNuit;
    }
    public abstract int getSuperficieTotal();

    public abstract void afficher();

//    public void afficher(){
//        hote.afficher();
//        System.out.println("Le logement est situé "+adresse+".");
//        System.out.println("Superficie : "+superficie+"m2");
//    }
}
