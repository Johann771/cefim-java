package johann.airbnb.reservations;

import johann.airbnb.logements.Logement;

import java.util.Date;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface{

    public SejourCourt(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
        tarif = nbNuits* logement.getTarifParNuit();
    }

    @Override
    public void afficher() {
        getLogement().afficher();
        System.out.println("La date d'arrivée est le "+getDateArrivee()+" pour "+getNbNuits()+" nuits.");
        System.out.println("Le prix de ce séjour court est de "+getLogement().getTarifParNuit()*getNbNuits()+"€ "+".");
    }


    @Override
    public boolean beneficiePromotion() {
        return false;
    }

    @Override
    public int getTarif() {
        return this.tarif;
    }

    @Override
    public boolean verificationNombreDeNuits() {
        if (getNbNuits() >= 1 && getNbNuits()<=31){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void miseAJourDuTarif() {
    }
}
