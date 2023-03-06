package johann.airbnb.utilisateurs;

import java.util.Objects;

public class Personne extends Object {

    private final String nom;
    private final String prenom;
    private final int age;

    public Personne(String nom, String prenom, int age) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public void afficher() {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + age + " ans)";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Personne personne = (Personne) o;
        return age == personne.age && Objects.equals(nom, personne.nom) &&
                Objects.equals(prenom, personne.prenom);
    }
}