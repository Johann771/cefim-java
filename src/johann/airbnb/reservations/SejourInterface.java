package johann.airbnb.reservations;

public interface SejourInterface {
    public abstract boolean verificationDateArrivee();
    public abstract boolean verificationNombreDeNuits();
    public abstract boolean verificationNombreDeVoyageurs();
    public abstract void afficher();

}
