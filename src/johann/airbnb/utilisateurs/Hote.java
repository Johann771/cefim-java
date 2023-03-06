package johann.airbnb.utilisateurs;

public class Hote extends Personne {

    private int delaiDeReponse;

    public Hote(String pNom, String pPrenom, int pAge, int delaiDeReponse) {
        super(pNom, pPrenom, pAge);
        this.delaiDeReponse = delaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Delai : " + delaiDeReponse);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        if (!super.equals(o))
            return false;

        Hote hote = (Hote) o;
        return delaiDeReponse == hote.delaiDeReponse;
    }

}