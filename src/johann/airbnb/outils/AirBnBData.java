package johann.airbnb.outils;
import johann.airbnb.utilisateurs.*;
import johann.airbnb.logements.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class AirBnBData {

            private static AirBnBData instance = null;
            private static ArrayList<Hote> HoteListe = new ArrayList<>();
            private static ArrayList<Logement> LogementListe = new ArrayList<>();
            private static ArrayList<Voyageur> VoyageurListe = new ArrayList<>();


    private AirBnBData(ArrayList<Hote> hoteListe, ArrayList<Logement> logementListe, ArrayList<Voyageur> voyageurListe) {

        // Création d'hôtes
        Hote hote1 = new Hote("Dupont", "Pierre", 35, 24);
        Hote hote2 = new Hote("Martin", "Sophie", 42, 48);
        Hote hote3 = new Hote("Lefevre", "Julie", 28, 12);

        // Ajout des hôtes à la liste d'Hotes
        HoteListe.add(hote1);
        HoteListe.add(hote2);
        HoteListe.add(hote3);

        // Création de logements
        Logement logement1 = new Appartement("Appartement 1", hote1, 100, "12 Rue des Lilas", 50, 2, 2, 3);
        Logement logement2 = new Maison("Maison 1", hote2, 150, "5 Rue du Château", 100, 4, 6,true);
        Logement logement3 = new Maison("Maison 5", hote2, 150, "5 Rue du Château", 100, 4, 6, true);

        // Ajout des logements à la liste de Logements
        LogementListe.add(logement1);
        LogementListe.add(logement2);
        LogementListe.add(logement3);

        // Création de voyageurs
        Voyageur voyageur1 = new Voyageur("Alexandre", "Durand", 25);
        Voyageur voyageur2 = new Voyageur("Julie", "Dumont", 32);
        Voyageur voyageur3 = new Voyageur("Antoine", "Lemoine", 18);

        // Ajout des voyageurs à la liste de Voyageurs
        VoyageurListe.add(voyageur1);
        VoyageurListe.add(voyageur2);
        VoyageurListe.add(voyageur3);

    }

    public static ArrayList<Logement> getLogementListe() {
        return LogementListe;
    }
    public static AirBnBData getInstance(){
        if (instance == null){
            instance = new AirBnBData(HoteListe, LogementListe, VoyageurListe);
        }
        return instance;
    }
}
