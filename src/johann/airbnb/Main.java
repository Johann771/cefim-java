package johann.airbnb;
import johann.airbnb.reservations.*;
import johann.airbnb.logements.*;
import johann.airbnb.utilisateurs.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import johann.airbnb.outils.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class Main {

    //Liste de logements
    private static ArrayList<Logement> logements = new ArrayList<>();

    public static void main(String[] args){

//        Hote hote2 = new Hote("Johann", "Weytens", 20, 5);
//        Maison maison2 = new Maison("maison 2",hote2,50,"25 rue des oliviers",60,8,100, true);
//        MaDate maDate = new MaDate(14,2,2023);
//        Sejour sejour = SejourFactory.createSejour(maDate, 5,maison2,7);
//        Voyageur voyageur = new Voyageur("Peter","Bardu",28);
//        try {
//            Reservation reservation = new Reservation(sejour,voyageur);
//            reservation.afficher();
//        }catch (Exception e){
//            System.out.println(""+e);
//
//        }
//
//        Hote hote1 = new Hote("Bardu", "Peter",21, 12);
//        Voyageur voyageur1 = new Voyageur("Martin", "Jean", 41);
        // Infos de la maison
        //Logement maison3 = new Maison(hote1,30,"5 rue des logements",120,6,1000,true);
        //Logement appartement = new Appartement(hote1,100, "3 rue des logements",120,6,12,123);
        //Logement logement3 = new Maison(hote1,1500,"4 rue des montagnes", 100,12,100,true);
        // critère
//        int nbNuits = 30;
//        Date date2 = new MaDate(11,2,2023);
//        int nbVoyageurs = 12;
//        Sejour sejour2;
//        Date dateSaintValentin = new MaDate(14,02,2023);
//        if (nbNuits > 5){
//            sejour2 = SejourFactory.createSejour(date2, nbNuits, logement3, nbVoyageurs);
//        } else {
//            sejour2 = new SejourCourt(date2,nbNuits,logement3,nbVoyageurs);
//        }
//        Sejour sejour3 = SejourFactory.createSejour(maDate,20,logement3,6);
//        Reservation reservation1 = null;
//        try {
//            reservation1 = new Reservation(sejour2,voyageur1);
//            reservation1.afficher();
//
//        } catch (Exception e) {
//            System.out.println("Exception : "+ e);
//        }
        try {

            // Ouvrir le fichier XML
            File XmlFile = new File("/Users/johannweytens/Downloads/AirBnB/src/johann/airbnb/logements.xml");

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

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            // Parsing des appartements
            NodeList appartements = doc.getElementsByTagName("Appartement");
            for (int i = 0; i < appartements.getLength(); i++) {
                Element appartement = (Element) appartements.item(i);
                String name = appartement.getAttribute("name");
                Hote hote = parseHote((Element) appartement.getElementsByTagName("hote").item(0));
                int tarifParNuit = Integer.parseInt(appartement.getElementsByTagName("tarifParNuit").item(0).getTextContent());
                String adresse = appartement.getElementsByTagName("adresse").item(0).getTextContent();
                int superficie = Integer.parseInt(appartement.getElementsByTagName("superficie").item(0).getTextContent());
                int nbVoyageursMax = Integer.parseInt(appartement.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());
                int numeroEtage = Integer.parseInt(appartement.getElementsByTagName("numeroEtage").item(0).getTextContent());
                int superficieBalcon = Integer.parseInt(appartement.getElementsByTagName("superficieBalcon").item(0).getTextContent());
                logements.add(new Appartement(name,hote, tarifParNuit, adresse, superficie, nbVoyageursMax, numeroEtage, superficieBalcon));
            }
            System.out.println("Appartements : " + logements);

            NodeList maisons = doc.getElementsByTagName("Maison");
            for (int i = 0; i < maisons.getLength(); i++) {
                Element maison = (Element) maisons.item(i);
                String name = maison.getAttribute("name");
                Hote hote = parseHote((Element) maison.getElementsByTagName("hote").item(0));
                int tarifParNuit = Integer.parseInt(maison.getElementsByTagName("tarifParNuit").item(0).getTextContent());
                String adresse = maison.getElementsByTagName("adresse").item(0).getTextContent();
                int superficie = Integer.parseInt(maison.getElementsByTagName("superficie").item(0).getTextContent());
                int nbVoyageursMax = Integer.parseInt(maison.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());
                int superficieJardin = Integer.parseInt(maison.getElementsByTagName("superficieJardin").item(0).getTextContent());
                boolean piscine = true;
                logements.add(new Maison(name,hote, tarifParNuit, adresse, superficie, nbVoyageursMax, superficieJardin, piscine));
            }
            System.out.println("Maisons : " +  logements);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Maison mamaison = findMaisonByName("Maison 1");
        System.out.println("Maison 1 : " + mamaison);
        Appartement monAppartement = findAppartementByName("Appartement 1");
        System.out.println("Appartement 1 : " + monAppartement);
        Appartement monAppartement2 = findAppartementByName("Appartement 2");
        System.out.println("Logement 1 : " + monAppartement2);
        Maison maMaison2 = findLogementByNameWithGenericity("Maison 2");
        System.out.println("Maison 2 : " + maMaison2);


        GenericityClassToCompare<Logement> integerGenericityClassToCompare = new GenericityClassToCompare<>(maMaison2,mamaison);
        Logement i = integerGenericityClassToCompare.getHigher();
        i.afficher();






        Date dateArrivee = new MaDate(1,1,2023);
        int nbNuits = 10;
        int nbVoyageurs = 12;
        Maison maison = new Maison("Maison1",new Hote("Johann",
                "Weytens", 30, 10), 100, "Rue de la paix",
                100, 10, 100, true);

        // Créer une copie de dateArrivee
        Date dateArriveeCopy = new Date(dateArrivee.getTime());

//        Sejour sejour = new SejourLong(dateArriveeCopy, nbNuits, maison, nbVoyageurs);
//        dateArrivee.setYear(98);
//        sejour.afficher();

        Sejour sejour2 = new SejourLong(dateArrivee, nbNuits, maison, nbVoyageurs);
        // J'utilise une copie défensive
        Date date = sejour2.getDateArrivee();
        date.setYear(98);
        sejour2.afficher();







    }
    private static Hote parseHote(Element element) {
        String nom = element.getElementsByTagName("nom").item(0).getTextContent();
        String prenom = element.getElementsByTagName("prenom").item(0).getTextContent();
        int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());
        int delaiReponse = Integer.parseInt(element.getElementsByTagName("delaiReponse").item(0).getTextContent());
        return new Hote(nom, prenom, age, delaiReponse);
    }
    private  static Maison findMaisonByName(String name){
        for (Logement logement : logements ) {
            if (logement instanceof Maison) {
                if (logement.getName().equals(name) && logement != null) {
                    return (Maison) logement;
                }
            }
        }
        return null;
    }
    private  static Appartement findAppartementByName(String name){
        for (Logement logement : logements) {
            if (logement instanceof Appartement) {
                if (logement.getName().equals(name) && logement != null) {
                    return (Appartement) logement;
                }
            }
        }
        return null;
    }
    private static Logement findLogementByName(String name){
        for (Logement logement : logements) {
            if (logement.getName().equals(name) && logement != null) {
                return logement;
            }
        }
        return null;
    }

    private static <T extends Logement> T findLogementByNameWithGenericity(String name) {
        for (Logement logement : logements) {
            if (Objects.equals(logement.getName(), name) && logement != null) {
                return (T) logement;
            }
        }
        return null;
    }


}