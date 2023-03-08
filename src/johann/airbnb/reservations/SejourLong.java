package johann.airbnb.reservations;

import johann.airbnb.logements.Logement;

import java.util.Date;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface{

    private static final int PROMOTION_EN_POURCENTAGE = 20;
    private int promotion;
    public SejourLong(Date dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
        super(dateArrivee, nbNuits, logement, nbVoyageurs);
    }


    @Override
    public void afficher() {
        getLogement().afficher();
        System.out.println("La date d'arrivée est le "+getDateArrivee()+" pour "+getNbNuits()+" nuits.");
        System.out.println("Le prix de ce séjour long est de "+getLogement().getTarifParNuit()*getNbNuits()+"€ "+"("+promotion+"€ de promotion).");
    }

    @Override
    public boolean beneficiePromotion() {
        return true;
    }

    @Override
    public int getTarif() {
        return tarif;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    @Override
    public boolean verificationNombreDeNuits() {
        if (getNbNuits() >= 1 && getNbNuits()<=31){
            return true;
        }
        return false;
    }

    @Override
    public void miseAJourDuTarif() {
        tarif = getLogement().getTarifParNuit()*getNbNuits();
        promotion = tarif * PROMOTION_EN_POURCENTAGE/100;
        tarif = tarif-promotion;
    }
}
