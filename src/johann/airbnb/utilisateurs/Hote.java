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
        if(delaiDeReponse >1){
            System.out.println(" qui s'engage à répondre dans les "+delaiDeReponse+" heures ");
        }
        else {
            System.out.println(" qui s'engage à répondre dans l'heure");
        }
    }
}
