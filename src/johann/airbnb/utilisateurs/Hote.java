package johann.airbnb.utilisateurs;

public class Hote extends Personne{
    private int delaiDeReponse;
    public Hote(String prenom, String nom, int age, int delaiDeReponse) {
        super(prenom, nom, age);
        this.delaiDeReponse = delaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.print(" qui s'engage à répondre dans les "+delaiDeReponse+" heures");
    }
}
