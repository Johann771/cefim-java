package johann.airbnb.outils;


import johann.airbnb.logements.*;
import java.util.ArrayList;
import java.util.Objects;

public class Search {
    private final int nbVoyageurs;
    private final int tarifMinParNuit;
    private final int tarifMaxParNuit;
    private final boolean possedePiscine;
    private final boolean possedeJardin;
    private final boolean possedeBalcon;
    private  Search(SearchBuilder searchBuilder) {
        this.nbVoyageurs = searchBuilder.nbVoyageurs;
        this.tarifMinParNuit = searchBuilder.tarifMinParNuit;
        this.tarifMaxParNuit = searchBuilder.tarifMaxParNuit;
        this.possedePiscine = searchBuilder.possedePiscine;
        this.possedeJardin = searchBuilder.possedeJardin;
        this.possedeBalcon = searchBuilder.possedeBalcon;
    }
    public ArrayList<Logement> result(){
         AirBnBData logements =  AirBnBData.getInstance();
         ArrayList<Logement> result = new ArrayList<>();

        for (Logement logement : logements.getLogementListe()) {
            if(logement instanceof Maison){
                if (logement.getNbVoyageursMax() >= this.nbVoyageurs && logement.getTarifParNuit() >= this.tarifMinParNuit && logement.getTarifParNuit() <= this.tarifMaxParNuit
                        && ((Maison) logement).isPossedePiscine() == this.possedePiscine && ((Maison) logement).getSuperficeJardin() > 0) {
                    result.add(logement);
                }
            }
            if(logement instanceof Appartement){
                if (logement.getNbVoyageursMax() >= this.nbVoyageurs && logement.getTarifParNuit() >= this.tarifMinParNuit && logement.getTarifParNuit() <= this.tarifMaxParNuit
                        && ((Appartement) logement).getSuperficieBalcon() > 0) {
                    result.add(logement);
                }
            }

        }
        return result;
    }

    public static class SearchBuilder{
        private final int nbVoyageurs;
        private int tarifMinParNuit;
        private int tarifMaxParNuit;
        private boolean possedePiscine;
        private boolean possedeJardin;
        private boolean possedeBalcon;
        public SearchBuilder(int nbVoyageurs) {
            this.nbVoyageurs = nbVoyageurs;
        }


        public SearchBuilder tarifMinParNuit(int tarifMinParNuit) {
            this.tarifMinParNuit = tarifMinParNuit;
            return this;
        }
        public SearchBuilder tarifMaxParNuit(int tarifMaxParNuit) {
            this.tarifMaxParNuit = tarifMaxParNuit;
            return this;
        }
        public SearchBuilder possedePiscine(boolean possedePiscine) {
            this.possedePiscine = possedePiscine;
            return this;
        }
        public SearchBuilder possedeJardin(boolean possedeJardin) {
            this.possedeJardin = possedeJardin;
            return this;
        }
        public SearchBuilder possedeBalcon(boolean possedeBalcon) {
            this.possedeBalcon = possedeBalcon;
            return this;
        }
        public Search build() {
            return new Search(this);
        }

    }

}
