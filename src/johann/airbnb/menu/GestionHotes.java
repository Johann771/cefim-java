package johann.airbnb.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import johann.airbnb.utilisateurs.Hote;

class GestionHotes {


	static void listerHotes() {
		System.out.println("-------------------------------------");

		// Afficher la liste des hôtes
		for (int i = 0; i<Menu.listHotes.size(); i++){
			System.out.print("Hote n°"+(i+1)+" : ");
			Menu.listHotes.get(i).afficher();
		}


		System.out.println("Saisir une option : ");
		System.out.println("1 : Ajouter un hôte");
		System.out.println("2 : Supprimer un hôte");
		System.out.println("3 : Retour");

		switch (Menu.choix(3)) {
			case 1:
				try {
					ajouterHote();
				}catch (Exception e){
					System.out.println("Erreur lors de l'ajout de l'hote : "+e);
					Menu.scanner.next();
					listerHotes();
				}
				break;
			case 2:
				try {
					supprimerHote();
				}catch (IndexOutOfBoundsException e){
					System.out.println("Cet indice n'existe pas : "+e);
					listerHotes();
				}catch (InputMismatchException e){
					System.out.println("Erreur lors de la saisie : "+e);
					Menu.scanner.next();
					listerHotes();
				}

				break;
			case 3:
				Menu.listerMenu();
				break;
		}		
	}

	private static void ajouterHote() throws Exception {
		System.out.println("-------------------------------------");
		System.out.println("Ajouter un nouvel hôte");

		System.out.println("Veuillez saisir un prénom");
		String prenom = Menu.scanner.next();
		System.out.println("Veuillez saisir un nom");
		String nom = Menu.scanner.next();
		System.out.println("Veuillez saisir un âge");
		int age = Menu.scanner.nextInt();
		System.out.println("Veuillez saisir un délai ");
		int delai = Menu.scanner.nextInt();
		Hote hote = new Hote(prenom, nom, age, delai);
		System.out.println("hôte correctement ajouté");
		Menu.listHotes.add(hote);
		hote.afficher();
		listerHotes();
	}

	/**
	 *
	 * @throws InputMismatchException
	 * @throws IndexOutOfBoundsException
	 */
	private static void supprimerHote() throws InputMismatchException,IndexOutOfBoundsException  {

		System.out.println("-------------------------------------");
		System.out.println("Supprimer un hôte");

		System.out.println("Veuillez saisir le numero de l'hote à supprimer");
		int index = Menu.scanner.nextInt();
		Menu.listHotes.remove(index-1);
		System.out.println("hote correctement supprimé");
		// TODO
		listerHotes();
	}
}
