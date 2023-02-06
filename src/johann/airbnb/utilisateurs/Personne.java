package johann.airbnb.utilisateurs;

public class Personne {
    private static String prenom;
    private static String nom;
    private  static int age;

    public Personne(String prenom, String nom, int age) {
        Personne.prenom = prenom;
        Personne.nom = nom;
        Personne.age = age;
    }
    public void afficher(){
        System.out.println(prenom +" "+ nom +" ("+ age+" ans)");
    }
}
