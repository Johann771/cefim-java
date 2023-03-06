package johann.airbnb;
import johann.airbnb.reservations.*;
import johann.airbnb.logements.*;
import johann.airbnb.utilisateurs.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import johann.airbnb.outils.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class Main {
    public static void main(String[] args){
        Hote hote2 = new Hote("Johann", "Weytens", 20, 5);
        Maison maison2 = new Maison(hote2,50,"25 rue des oliviers",60,8,100, true);
        MaDate maDate = new MaDate(14,2,2023);
        Sejour sejour = SejourFactory.createSejour(maDate, 5,maison2,7);
        Voyageur voyageur = new Voyageur("Peter","Bardu",28);
        try {
            Reservation reservation = new Reservation(sejour,voyageur);
            reservation.afficher();
        }catch (Exception e){
            System.out.println(""+e);

        }

        Hote hote1 = new Hote("Bardu", "Peter",21, 12);
        Voyageur voyageur1 = new Voyageur("Martin", "Jean", 41);
        // Infos de la maison
        Logement maison3 = new Maison(hote1,30,"5 rue des logements",120,6,1000,true);
        //Logement appartement = new Appartement(hote1,100, "3 rue des logements",120,6,12,123);
        Logement logement3 = new Maison(hote1,1500,"4 rue des montagnes", 100,12,100,true);
        // critère
        int nbNuits = 30;
        Date date2 = new MaDate(11,2,2023);
        int nbVoyageurs = 12;
        Sejour sejour2;
        Date dateSaintValentin = new MaDate(14,02,2023);
        if (nbNuits > 5){
            sejour2 = SejourFactory.createSejour(date2, nbNuits, logement3, nbVoyageurs);
        } else {
            sejour2 = new SejourCourt(date2,nbNuits,logement3,nbVoyageurs);
        }
        Sejour sejour3 = SejourFactory.createSejour(maDate,20,logement3,6);
        Reservation reservation1 = null;
        try {
            reservation1 = new Reservation(sejour2,voyageur1);
            reservation1.afficher();

        } catch (Exception e) {
            System.out.println("Exception : "+ e);
        }

        try {

            // Ouvrir le fichier XML
            File XmlFile = new File("C:\\Users\\weyte\\Downloads\\AirBnB 2\\AirBnB\\src\\johann\\airbnb\\logements.xml");

            // Créer un objet DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Créer un objet DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Créer un objet Document à partir du fichier XML
            Document doc = dBuilder.parse(XmlFile);

            // Normaliser le fichier XML
            doc.getDocumentElement().normalize();

            // Obtenir la liste de tous les logements
            NodeList nodeList = doc.getElementsByTagName("Appartement");

            //Liste de logements
            ArrayList<Logement> logements = new ArrayList<>();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Parsing des appartements
            NodeList appartements = doc.getElementsByTagName("Appartement");
            for (int i = 0; i < appartements.getLength(); i++) {
                Element appartement = (Element) appartements.item(i);
                Hote hote = parseHote((Element) appartement.getElementsByTagName("hote").item(0));
                int tarifParNuit = Integer.parseInt(appartement.getElementsByTagName("tarifParNuit").item(0).getTextContent());
                String adresse = appartement.getElementsByTagName("adresse").item(0).getTextContent();
                int superficie = Integer.parseInt(appartement.getElementsByTagName("superficie").item(0).getTextContent());
                int nbVoyageursMax = Integer.parseInt(appartement.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());
                int numeroEtage = Integer.parseInt(appartement.getElementsByTagName("numeroEtage").item(0).getTextContent());
                int superficieBalcon = Integer.parseInt(appartement.getElementsByTagName("superficieBalcon").item(0).getTextContent());
                logements.add(new Appartement(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, numeroEtage, superficieBalcon));
            }
            System.out.println("Appartements : " + logements);

            NodeList maisons = doc.getElementsByTagName("Maison");
            for (int i = 0; i < maisons.getLength(); i++) {
                Element maison = (Element) maisons.item(i);
                Hote hote = parseHote((Element) maison.getElementsByTagName("hote").item(0));
                int tarifParNuit = Integer.parseInt(maison.getElementsByTagName("tarifParNuit").item(0).getTextContent());
                String adresse = maison.getElementsByTagName("adresse").item(0).getTextContent();
                int superficie = Integer.parseInt(maison.getElementsByTagName("superficie").item(0).getTextContent());
                int nbVoyageursMax = Integer.parseInt(maison.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());
                int superficieJardin = Integer.parseInt(maison.getElementsByTagName("superficieJardin").item(0).getTextContent());
                boolean piscine = true;
                logements.add(new Maison(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, superficieJardin, piscine));
            }
            System.out.println("Maisons : " +  logements);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Hote parseHote(Element element) {
        String nom = element.getElementsByTagName("nom").item(0).getTextContent();
        String prenom = element.getElementsByTagName("prenom").item(0).getTextContent();
        int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
        int delaiReponse = Integer.parseInt(element.getElementsByTagName("delaiReponse").item(0).getTextContent());
        return new Hote(nom, prenom, age, delaiReponse);
    }
}