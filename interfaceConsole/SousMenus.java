/**
 * 
 */
package interfaceConsole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import utils.Utils;
import cartes.Attaque;
import cartes.Collection;
import cartes.Dresseur;
import cartes.Energie;
import cartes.Pokemon;

/**
 * @author aicha
 * 
 */
public class SousMenus {
	
	public static boolean lancer(int menu,Collection collection){
		boolean stop = false;
		switch (menu) {
		case Menu.AJOUTER:
			SousMenus.ajouter(collection,false);
			break;
		case Menu.SUPPRIMER:
			SousMenus.supprimer(collection);
			break;
		case Menu.MODIFIER:
			SousMenus.ajouter(collection,true);
			break;
		case Menu.CONSULTER:
			SousMenus.consulter(collection);
			break;
		case Menu.RECHERCHER:
			SousMenus.rechercher(collection);
			break;
		case Menu.QUITTER:
			stop = true;
			break;

		default:
			System.out.println("Cette entree n'est pas valide. Veuillez recommencer : ");
			break;
		}
		return stop;
	}
	
	private static void afficher_choix_type(){
		System.out.println("De quel type est la carte ? ");
		System.out.print("1. Pokemon\t");
		System.out.print("2. Dresseur\t");
		System.out.print("3. Energie\n");
	}
	
	private static int choix_type(String nom){
		int choix = -1;
		switch (nom.toLowerCase()) {
		case "pokemon":choix = 1;
			break;
		case "dresseur": choix = 2;
			break;
		case "energie": choix = 3;
			break;
		}
		
		return choix;
	}
	
	private static String choix_type(int type){
		String choix = "";
		switch (type) {
		case 1:choix = "pokemon";
			break;
		case 2: choix = "dresseur";
			break;
		case 3: choix = "energie";
			break;
		}
		
		return choix;
	}

	private static void ajouter(Collection collection, boolean modif) {
			Scanner entree = new Scanner(System.in);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Saisissez le numero de la carte : ");
			int numero = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
			if (collection.existe_carte(numero) && !modif) {
				System.out.println("La carte existe deja. Voulez vous la copier ?(o/n)('non' par defaut)");
				String reponse = Menu.redemander_saisie(entree, 1 , true);
				if(Utils.nettoyer_chaine(reponse.toLowerCase()).equals("oui") || Utils.nettoyer_chaine(reponse.toLowerCase()).equals("o")){
					collection.copier_carte(numero);
					System.out.println("La carte a bien ete copiee !! ");
				}
			}
			else if (!collection.existe_carte(numero) && modif) {
				System.out.println("Cette carte n'existe pas encore !! ");
			}
			else{
				
				int choix = -1;
				if(modif){
					System.out.println(collection.consulter_la_carte(numero) + "\n");
					choix = choix_type(collection.get_type(numero));
				}
				if(choix < 0){
					afficher_choix_type();
					choix = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
					while(choix > 3 || choix < 1){
						System.out.println("Veuillez choisir un type de carte valide : ");
						choix = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
					}
				}
				
				switch (choix) {
				case 1:
					if(modif)
						collection.modifier_une_carte(numero, ajouter_pokemon(entree, modif));
					else{
						Pokemon temp = new Pokemon(numero, 0, 0, "", 0, null);
						collection.ajouter_une_carte(temp.modifier_carte(ajouter_pokemon(entree, modif)),modif);
					}
					System.out.println("La carte POKEMON N�" + numero + " a bien ete " + ((modif)?"modifiee":"ajoutee") + " !!");
					break;
				case 2:
					if(modif)
						collection.modifier_une_carte(numero, ajouter_dresseur(entree, modif));
					else{
						Dresseur temp = new Dresseur(numero, 0, "", "");
						collection.ajouter_une_carte(temp.modifier_carte(ajouter_dresseur(entree, modif)),modif);
					}
					System.out.println("La carte DRESSEUR N�" + numero + " a bien ete " + ((modif)?"modifiee":"ajoutee") + " !!");
					break;
				case 3:
					if(modif)
						collection.modifier_une_carte(numero, ajouter_energie(entree, modif));
					else{
						Energie temp = new Energie(numero, 0);
						collection.ajouter_une_carte(temp.modifier_carte(ajouter_energie(entree, modif)),modif);
					}
					System.out.println("La carte ENERGIE N�" + numero + " a bien ete " + ((modif)?"modifiee":"ajoutee") + " !!");
					break;
				default:
					break;
				}
			}
		}
		
		private static HashMap<String, Object> ajouter_pokemon(Scanner entree,boolean modif){
			int type = 0,niveau = 0, pts_de_vie = 0;
			String nom = "";
			HashMap<String,Attaque>attaques = new HashMap<>();
			HashMap<String, Object> map = new HashMap<>();
			//nom du pokemon
			System.out.println("Veuillez entrer le nom de la carte : ");
			if(modif)System.out.println("laisser vide pour ne pas modifier l'ancien");
			nom = Menu.redemander_saisie(entree, 1 , modif);
			//choix du type d'energie
			System.out.println("\nVeuillez choisir le d'energie du Pokemon : ");
			if(modif)System.out.println("Entrer 0 pour ne pas modifier l'ancien ");
			Energie.affiche_energies_types();
			type = Integer.parseInt(Menu.redemander_saisie(entree, 0 , modif));
			if(modif && type == 0)
				type = 0;
			else{
				while(type > 12 || type < 1){
					System.out.println("Veuillez choisir un type d'energie valide : ");
					type = Integer.parseInt(Menu.redemander_saisie(entree, 0 , modif));
				}
			}
			//choix du niveau
			System.out.println("\nVeuillez choisir le niveau du Pokemon : ");
			if(modif)System.out.println("Entrer 0 pour ne pas modifier l'ancien ");
			Pokemon.affiche_niveau_pokemon();
			niveau = Integer.parseInt(Menu.redemander_saisie(entree, 0 , modif));
			if(modif && niveau == 0)
				niveau = 0;
			else{
				while(niveau > 3 || niveau < 1){
					System.out.println("Veuillez choisir un niveau valide : ");
					niveau = Integer.parseInt(Menu.redemander_saisie(entree, 0 , modif));
				}
			}
			//points de vie
			System.out.println("\nVeuillez entrer le nombre de points de vie du Pokemon : ");
			if(modif)System.out.println("si la valeur est <= 0 les points de vir ne seront pas modifies");
			pts_de_vie = Integer.parseInt(Menu.redemander_saisie(entree, 0 , modif));
			//les attaques
			System.out.println("Les attaques du Pokemon : ");
			boolean stop = false;
			String reponse = "";
			while(!stop){
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Ajouter une nouvelle attaque ?(o/n)('non' par defaut)");
				reponse = Menu.redemander_saisie(entree, 1, true);
				if(Utils.nettoyer_chaine(reponse.toLowerCase()).equals("oui") || Utils.nettoyer_chaine(reponse.toLowerCase()).equals("o")){
					Attaque att = ajouter_attaque(entree);
					attaques.put(att.get_nom(),att);
					System.out.println("L'attaque a bien ete ajoutee !! ");
				}
				else
					stop = true;
			}
			System.out.println("Voulez vous : ");
			System.out.println("1. Remplacer toutes les attaques");
			System.out.println("2. Ajouter les ataques � votre liste (par defaut)");
			int choix = Integer.parseInt(Menu.redemander_saisie(entree, 0, false));//HashMap<String, Object>
			if(choix != 1)map.put("concat_attaques",true);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
			
			map.put("type", (type - 1));
			map.put("pts_de_vie", pts_de_vie);
			map.put("nom", nom);
			map.put("niveau", (niveau - 1));
			map.put("attaques", attaques);
			
			return map;
		}
		
		private static Attaque ajouter_attaque(Scanner entree){
			String nom = "",description="";
			char bonus_char = ' ';
			int degats = 0;
			ArrayList<Integer> energies = new ArrayList<>();
			//nom
			System.out.println("Veuillez entrer le nom de l'attaque : ");
			nom = Menu.redemander_saisie(entree, 1 , false);
			//description
			System.out.println("Veuillez entrer la description de l'attaque : ");
			description = Menu.redemander_saisie(entree, 1 , true);
			//bonus
			System.out.println("Le nombre de degat est-il evolutif ?");
			System.out.println("si oui entrez l'operateur correspondant(+ ou * ou -, vide par defaut) : ");
			String bonus = Menu.redemander_saisie(entree, 1 , true);
			bonus_char = (Utils.nettoyer_chaine(bonus).length() > 0)?Utils.nettoyer_chaine(bonus).charAt(0):' ';
			//degats
			System.out.println("Veuillez entrer le nombre de degats inflige par l'attaque : ");
			degats = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
			//energies
			System.out.println("Choisissez les types d'energies requis pour l'attaque (entrez 0 pour terminer): ");
			Energie.affiche_energies_types();
			boolean stop = false;
			int choix = 0;
			while(!stop){
				choix = Integer.parseInt(Menu.redemander_saisie(entree, 0, false));
				if(choix == 0)
					stop = true;
				else{
					if(choix > 12 || choix < 1){
						System.out.print("Ce type n'energie n'existe pas !!\n");
					}
					else
						energies.add(choix-1);
				}
			}
			return new Attaque(nom, degats, bonus_char, description, energies);
		}
		
		private static HashMap<String, Object> ajouter_dresseur(Scanner entree, boolean modif){
			int choix = 0;
			String nom = "",actions = "";
			
			System.out.println("Veuillez entrer le nom de la carte : ");
			if(modif)System.out.println("Laisser vide  pour ne pas modifier l'ancien ");
			nom = Menu.redemander_saisie(entree, 1 , modif);
			
			System.out.println("Veuillez choisir le type de dresseur : ");
			if(modif)System.out.println("Entrer 0 pour ne pas modifier l'ancien ");
			Dresseur.affiche_dresseurs_types();
			choix = Integer.parseInt(Menu.redemander_saisie(entree, 0 , modif));
			if(modif && choix == 0)
				choix = 0;
			else{
				while(choix > 3 || choix < 1){
					System.out.println("Veuillez choisir un type de dresseur valide : ");
					choix = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
				}
			}
			
			System.out.println("Que permet cette carte dresseur ?");
			if(modif)System.out.println("Laisser vide  pour ne pas modifier l'ancien ");
			actions = Menu.redemander_saisie(entree, 1 , true);
			HashMap<String, Object> map = new HashMap<>();
			map.put("nom", nom);
			map.put("type", (choix - 1));
			map.put("actions", actions);
			return map;
		}
		
		private static HashMap<String, Object> ajouter_energie(Scanner entree, boolean modif){
			System.out.println("Veuillez choisir le type d'energie");
			if(modif)
				System.out.println("entrez 0 pour garder le type existant :");
			Energie.affiche_energies_types();
			int choix = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
			if(modif && choix == 0)
				choix = 0;
			else{
				while(choix > 12 || choix < 1){
					System.out.println("Veuillez choisir un type d'energie valide : ");
					choix = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
				}
			}
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("type", (choix - 1));
			return map;
		}

	private static void supprimer(Collection collection) {
		Scanner entree = new Scanner(System.in);
		boolean stop = false;
		while(!stop){
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Entrez le numero de la carte a supprimer (0 pour revenir au menu principal) : ");
			int numero = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
			if(numero == 0)
				stop = true;
			else{
				System.out.println(collection.consulter_la_carte(numero));
				System.out.println();
				if(collection.existe_carte(numero)){
					System.out.println("Voulez vous supprimer tous les exemplaires de cette carte ? (O/N)");
					String choix = Menu.redemander_saisie(entree, 1, true);
					
					while(!est_oui_ou_non(choix))
						choix = Menu.redemander_saisie(entree, 1, true);
					String chaine = Utils.nettoyer_chaine(choix).toLowerCase();
					
					if(chaine.equals("n") || chaine.equals("non")){
						System.out.println("Entrez le nombre d'exemplaires a supprimer : ");
						int nb = Integer.parseInt(Menu.redemander_saisie(entree, 0, false));
						collection.supprimer_une_carte(numero, nb);
						System.out.println(nb + " exemplaires de la carte ont ete supprimes !!");
					}
					else if(chaine.equals("o") || chaine.equals("oui") || chaine.equals("")){
						collection.supprimer_une_carte(numero, -1);
						System.out.println("Tous les exemplaires de la carte ont ete supprimes !!");
					}
				}
			}
		}
	}
	
	private static boolean est_oui_ou_non(String choix){
		String chaine = Utils.nettoyer_chaine(choix).toLowerCase();
		return chaine.equals("n") || chaine.equals("non") || chaine.equals("o") 
				|| chaine.equals("oui") || chaine.equals("");
	}

	private static void consulter(Collection collection) {
			System.out.println("\nVotre collection : ");
			System.out.println(collection);
		}
	
	private static void rechercher(Collection collection) {
			Scanner entree = new Scanner(System.in);
			boolean stop = false;
			int choix = 0;
			while(!stop){
				System.out.println("________________________________________________________________________");
				System.out.println("Nouvelle recherche : ");
				System.out.println("Entrez le critere de recherche (0 pour revenir au menu principal) : ");
				System.out.println("1.Numero de carte \t 2.Type de carte ");
				choix = Integer.parseInt(Menu.redemander_saisie(entree, 0 , false));
				switch (choix) {
				case 1:
					System.out.println("Veuillez renseigner le numero de la carte recherchee : ");
					int num = Integer.parseInt(Menu.redemander_saisie(entree, 0, false));
					collection.rechercher_par_numero(num);
					break;
				case 2:
					System.out.println("Veuillez renseigner le Type de carte recherche : ");
					afficher_choix_type();
					int type = Integer.parseInt(Menu.redemander_saisie(entree, 0, false));
					collection.rechercher_par_type(choix_type(type));
					break;
				case 0:
					stop = true;
					break;
				default:
					System.out.println("Ce critere n'est pas valide");
					break;
				}
			}
					
		}
	}
