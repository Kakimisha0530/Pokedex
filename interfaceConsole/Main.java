/**
 * 
 */
package interfaceConsole;

import java.util.Scanner;

import utils.Utils;
import cartes.Collection;

/**
 * @author aicha
 * 
 */
public class Main {
	public static void main(String[] args) {
		Collection collection = new Collection(39);
		Scanner entree = new Scanner(System.in);
		String choix = "0";
		System.out.println("BONJOUR CHER UTILISATEUR");
		System.out.println("QUE SOUHAITEZ VOUS FAIRE ?");
		System.out.println("1. AJOUTER UNE CARTE A VOTRE COLLECTION");
		System.out.println("2. SUPPRIMER UNE CARTE");
		System.out.println("Entrez votre choix et taper : ");
		while (!Utils.isInteger(choix = entree.nextLine())
				|| (Integer.parseInt(choix) != 1 && Integer.parseInt(choix) != 2))
			System.out
					.println("CETTE ENTREE N'EST PAS VALIDE VEUILLEZ RECOMMENCER");
		System.out.println("VOUS AVEZ CHOISIS : " + choix);
	}
}
