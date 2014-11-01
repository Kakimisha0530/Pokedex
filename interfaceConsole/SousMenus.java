/**
 * 
 */
package interfaceConsole;

import java.util.Scanner;

import cartes.Collection;

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
				if(modif)
					System.out.println(collection.consulter_la_carte(numero));
			}
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
