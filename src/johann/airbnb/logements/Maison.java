package johann.airbnb.logements;

import johann.airbnb.utilisateurs.Hote;
import johann.airbnb.utilisateurs.Personne;

public class Maison extends Logement{

        private int superficieJardin;
        private boolean possedePiscine;
    public Maison(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int superficieJardin, boolean possedePiscine) {
        super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficieJardin = superficieJardin;
        this.possedePiscine = possedePiscine;
    }

    @Override
    public int getSuperficieTotal() {
        return this.getSuperficie()+this.superficieJardin;
    }

    @Override
    public void afficher() {
        getHote().afficher();
        System.out.println("Le logement est une maison située : "+getAdresse()+".");
        System.out.println("Superficie : "+getSuperficieTotal());
        if(superficieJardin> 0){
            System.out.println("Jardin : Oui ("+superficieJardin+"m2)");

        }else {
            System.out.println("Jardin : Non");
        }
        if(possedePiscine){
            System.out.println("Piscine : Oui");
        } else {
            System.out.println("Piscine : Non");
        }
    }

}
