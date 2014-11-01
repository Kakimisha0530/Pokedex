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
	public static final int AJOUTER = 1;
	public static final int SUPPRIMER = 2;
	public static final int MODIFIER = 3;
	public static final int CONSULTER = 4;
	public static final int QUITTER = 5;
	
	public static int redemander_saisie(Scanner entree){
		String saisie = "";
		while (!Utils.isInteger(saisie = entree.nextLine()))
			System.out.println("CETTE ENTREE N'EST PAS VALIDE VEUILLEZ RECOMMENCER");
		return Integer.parseInt(saisie);
	}
	
	public static void main(String[] args) {
		Collection collection = new Collection();
		if(collection.sauvegarder())
			System.out.println("premiere sauvegarde\n\n\n");
		else
			System.out.println("echec sauvegarde\n\n\n");
		
		System.out.println("BONJOUR CHER UTILISATEUR\n\n");
		
		boolean stop = false;
		Scanner entree = new Scanner(System.in);
		int choix = 0;
		
		while(!stop){
			System.out.println("================================================================");
			System.out.println("QUE SOUHAITEZ VOUS FAIRE ?");
			System.out.println("1. AJOUTER UNE CARTE A VOTRE COLLECTION");
			System.out.println("2. SUPPRIMER UNE CARTE");
			System.out.println("3. MODIFIER UNE CARTE");
			System.out.println("4. CONSULTER MES CARTES");
			System.out.println("5. QUITTER");
			
			choix = redemander_saisie(entree);
			
			switch (choix) {
			case 1:
				break;
			case 2:
				System.out.println("supprimer");
				break;
			case 3:
				System.out.println("modifier");
				break;
			case 4:
				System.out.println("consulter");
				break;
			case 5:
				stop = true;
				break;

			default:
				System.out.println("CETTE ENTREE N'EST PAS VALIDE VEUILLEZ RECOMMENCER");
				break;
			}
		}
		
		entree.close();
		System.out.println("AU REVOIR !!");
	}
}
