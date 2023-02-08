package johann.airbnb.utilisateurs;

public class Personne {
    private String prenom;
    private String nom;
    private int age;

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }
    public void afficher(){
        System.out.print(prenom +" "+ nom +" ("+ age+" ans)");
    }
}
