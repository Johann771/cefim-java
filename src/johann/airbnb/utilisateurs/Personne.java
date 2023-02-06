package johann.airbnb.utilisateurs;

public class Personne {
    private static String prenom;
    private static String nom;
    private  static int age;

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
    }
    public void afficher(){
        System.out.println(this.prenom +" "+ this.nom +" ("+this.age+" ans)");
    }
}
