package johann.airbnb.logements;

import johann.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {

    private final int superficieBalcon;
    private final int numeroEtage;

    public Appartement(String name, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieBalcon, int numeroEtage) {
        super(name, hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficieBalcon = superficieBalcon;
        this.numeroEtage = numeroEtage;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.print("Le logement est un appartement situé " + getAdresse());

        if (numeroEtage == 0) {
            System.out.println(" au rez-de-chaussé.");
        } else if (numeroEtage == 1) {
            System.out.println(" au 1er étage.");
        } else {
            System.out.println(" au " + numeroEtage + "ème étage.");
        }

        System.out.println("Superficie : " + getSuperficie() + "m2");
        System.out.println("Balcon : " + (superficieBalcon > 0 ? "Oui (" + superficieBalcon + "m2)" : "Non"));
    }

    @Override
    public int getSuperficeTotale() {
        return getSuperficie() + superficieBalcon;
    }
}