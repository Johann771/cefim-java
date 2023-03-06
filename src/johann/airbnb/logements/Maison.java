package johann.airbnb.logements;


import johann.airbnb.utilisateurs.Hote;

public class Maison extends Logement {

    private int superficeJardin;
    private boolean possedePiscine;

    public Maison(String name, Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficeJardin, boolean possedePiscine) {
        super(name,hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficeJardin = superficeJardin;
        this.possedePiscine = possedePiscine;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.println("Le logement est une maison située " + getAdresse());
        System.out.println("Superficie : " + getSuperficie() + "m2");
        System.out.println("Piscine : " + (possedePiscine ? "oui" : "non"));
    }

    @Override
    public int getSuperficeTotale() {
        return getSuperficie() + superficeJardin;
    }

}