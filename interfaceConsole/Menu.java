package interfaceConsole;

import java.util.Scanner;
import cartes.Collection;
import utils.Utils;

/**
 * @author aicha
 * 
 */
public class Menu {
	public static final int AJOUTER = 1;
	public static final int SUPPRIMER = 2;
	public static final int MODIFIER = 3;
	public static final int CONSULTER = 4;
	public static final int RECHERCHER = 5;
	public static final int QUITTER = 6;

	public void lancer() {
		Collection pokemon = new Collection();
		boolean arreter = false;
		Scanner entree = new Scanner(System.in);
		int choix = 0;
		System.out.println("BONJOUR CHER UTILISATEUR\n");

		while (!arreter) {
			this.afficher_menu();
			choix = Integer.parseInt(Menu.redemander_saisie(entree,0,false));
			arreter = this.lancer_menu_choix(choix,pokemon);
		}
		
		entree.close();
		pokemon.sauvegarder();
		System.out.println("AU REVOIR !!!");
	}

	public static String redemander_saisie(Scanner entree, int type, boolean vide) {
		String saisie = "";
		//boolean bon_type;
		if(type > 0){
			if(vide)
				saisie = entree.nextLine();
			else
				while (Utils.chaine_non_vide(saisie = entree.nextLine()))
					System.out.println("Veuilez entrer un texte non vide : ");
		}
		else
			while (!Utils.isInteger(saisie = entree.nextLine()))
				System.out.println("Cette entree n'est pas valide. Veuillez recommencer : ");
		return saisie;
	}

	private boolean lancer_menu_choix(int choix,Collection collection) {
		return SousMenus.lancer(choix,collection);
	}

	private void afficher_menu() {
		System.out.println("================================================================");
		System.out.println("QUE SOUHAITEZ VOUS FAIRE ?");
		System.out.println("1. AJOUTER UNE CARTE A VOTRE COLLECTION");
		System.out.println("2. SUPPRIMER UNE CARTE");
		System.out.println("3. MODIFIER UNE CARTE");
		System.out.println("4. CONSULTER MES CARTES");
		System.out.println("5. RECHERCHER DANS MES CARTES");
		System.out.println("6. QUITTER");
	}
}
