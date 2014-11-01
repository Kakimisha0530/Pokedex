/**
 * 
 */
package interfaceConsole;

import java.util.Scanner;

import cartes.Collection;
import cartes.Dresseur;
import cartes.Energie;
import cartes.Pokemon;

/**
 * @author aicha
 * 
 */
public class SousMenus {

	static class Ajout {		
		public static void lancer(Collection collection, boolean modif) {
			Scanner entree = new Scanner(System.in);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Saisissez le numero de la carte : ");
			int numero = Integer.parseInt(Menu.redemander_saisie(entree, 0));
			if (collection.existe_carte(numero) && !modif) {
				System.out.println("La carte existe deja. Voulez vpus la cpier ?(o/n)('non' par defaut)");
				String reponse = Menu.redemander_saisie(entree, 1);
				if(reponse.toLowerCase().equals("oui") || reponse.toLowerCase().equals("o"))
					collection.copier_carte(numero);
			}
			else if (!collection.existe_carte(numero) && modif) {
				System.out.println("Cette carte n'existe pas encore !! ");
			}
			else{
				
				int choix = -1;
				if(modif)
					System.out.println(collection.consulter_la_carte(numero));
				afficher_choix_type();
				choix = Integer.parseInt(Menu.redemander_saisie(entree, 0));
				while(choix > 3 && choix > 1){
					System.out.println("Veuillez choisir un type de carte valide : ");
					choix = Integer.parseInt(Menu.redemander_saisie(entree, 0));
				}
				
				switch (choix) {
				case 1:
					collection.ajouter_une_carte(ajouter_pokemon(numero,entree), modif);
					break;
				case 2:
					collection.ajouter_une_carte(ajouter_dresseur(numero,entree), modif);
					break;
				case 3:
					collection.ajouter_une_carte(ajouter_energie(numero,entree), modif);
					System.out.println("La carte ENERGIE N°" + numero + " a bien ete ajoutee !!");
					break;
				default:
					break;
				}
			}
		}
		
		private static void afficher_choix_type(){
			System.out.println("De quel type est la carte ? ");
			System.out.print("1. Pokemon\t");
			System.out.print("2. Dresseur\t");
			System.out.print("3. Energie\n");
		}
		
		private static Pokemon ajouter_pokemon(int numero,Scanner entree){
			return null;
		}
		
		private static Dresseur ajouter_dresseur(int numero,Scanner entree){
			return null;
		}
		
		private static Energie ajouter_energie(int numero,Scanner entree){
			System.out.println("Veuillez choisir le type d'energie");
			Energie.affiche_energies_types();
			int choix = Integer.parseInt(Menu.redemander_saisie(entree, 0));
			while(choix < 4 && choix > 0){
				System.out.println("Veuillez choisir un type d'energie valide : ");
				choix = Integer.parseInt(Menu.redemander_saisie(entree, 0));
			}
			
			return new Energie(numero, (choix-1));
		}
	}

	static class Suppression {
		public static void lancer(Collection collection) {

		}
	}

	static class Consultation {
		public static void lancer(Collection collection) {

		}
	}
}
