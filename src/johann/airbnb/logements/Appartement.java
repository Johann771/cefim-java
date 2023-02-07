package johann.airbnb.logements;

import johann.airbnb.utilisateurs.Hote;

public class Appartement extends Logement{

    private int numeroEtage;
    private int superficieBalcon;
    public Appartement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageursMax, int numeroEtage, int superficieBalcon) {
        super(hote, tarifParNuit, adresse, superficie, nbVoyageursMax);
        this.superficieBalcon = superficieBalcon;
        this.numeroEtage = numeroEtage;
    }

    @Override
    public int getSuperficieTotal() {
        return this.superficieBalcon+getSuperficie();
    }

    @Override
    public void afficher() {
        getHote().afficher();
        if(numeroEtage > 1){
            System.out.println("Le logement est un appartement située : "+getAdresse()+" au "+numeroEtage+"ème étage.");
        }else{
            System.out.println("Le logement est un appartement située : "+getAdresse()+" au "+numeroEtage+"er étage.");
        }
        System.out.println("Superficie : "+getSuperficie());
        if(superficieBalcon > 0){
            System.out.println("Balcon : Oui ("+superficieBalcon+"m2)");
        }
        else{
            System.out.println("Balcon : Non");
        }
    }
}
