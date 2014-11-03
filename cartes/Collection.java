/**
 * 
 */
package cartes;

import java.util.ArrayList;
import java.util.HashMap;

import sauvegarde.SauvegardeBinaire;

/**
 * @author aicha
 * 
 */
public class Collection extends SauvegardeBinaire{

	private static transient final long serialVersionUID = 1L;
	private ArrayList<Carte> collection;
	private transient HashMap<Integer,Carte> liste_de_cartes_uniques;
	private transient HashMap<Integer,Integer> statistiques;
	public static final int TAILLE_PAR_DEFAUT = 39;
	private int taille;

	public Collection(int taille) {
		if(!this.recuperer()){
			this.taille = taille;
			this.collection = new ArrayList<>();
		}
		this.actualiser();
	}
	
	public Collection() {
		this(TAILLE_PAR_DEFAUT);
	}
	
	private void actualiser(){
		this.liste_de_cartes_uniques = new HashMap<>();
		this.statistiques = new HashMap<>();
		for(Carte c:collection){
			this.liste_de_cartes_uniques.put(c.get_numero(), c);
			if(this.statistiques.containsKey(c.get_numero()))
					this.statistiques.put(c.get_numero(), this.statistiques.get(c.get_numero()) + 1);
			else
				this.statistiques.put(c.get_numero(), 1);
		}
		this.sauvegarder();
	}

	public void supprimer_une_carte(int num,int nombre) {
		if(existe_carte(num)){
			Carte carte = this.liste_de_cartes_uniques.get(num);
			while(nombre > 0)
				this.collection.remove(this.collection.indexOf(carte));
			this.actualiser();
		}
	}
	
	public void modifier_une_carte(int numero,HashMap<String, Object> map){
		if(existe_carte(numero)){
			Carte carte = this.liste_de_cartes_uniques.get(numero).modifier_carte(map);
			ajouter_une_carte(carte, true);
		}
	}

	public boolean ajouter_une_carte(Carte carte,boolean modif) {
		if(carte != null && carte.numero_inferieur_a(this.taille)){
			if(modif){
				this.collection.remove(carte);
				for(int i = 0;i < this.statistiques.get(carte.get_numero());i++)
					this.collection.add(carte);
			}
			else
				this.collection.add(carte);
			this.actualiser();
			return true;
		}
		return false;
	}
	
	public boolean copier_carte(int num){
		if(this.existe_carte(num)){
			Carte c = (Carte)this.liste_de_cartes_uniques.get(num).clone();
			this.collection.add(c);
			this.actualiser();
			return true;
		}
		return false;
	}
	
	public String consulter_la_carte(int numero) {
		return (this.liste_de_cartes_uniques.get(numero) != null) ? (this.liste_de_cartes_uniques
				.get(numero).toString() + "\nExemplaires : " + this.statistiques.get(numero)) : "Cette carte n'existe pas";
	}
	
	public boolean existe_carte(int numero){
		return this.liste_de_cartes_uniques.containsKey(numero);
	}
	

	@Override
	protected void charger(Object obj) {
		if(obj instanceof Collection && obj != null){
			Collection jeu = (Collection)obj;
			this.taille = jeu.taille;
			this.collection = jeu.collection;
		}			
	}
	
	public String afficher_liste_carte(HashMap<Integer, Carte> liste,String message){
		
		String sep = "\n*****************************************************";
		String chaine = "";
		chaine += sep;
		
		if(liste.size() > 0){
			for (int num : liste.keySet()) {
				chaine += "\n" + this.consulter_la_carte(num);
				chaine += sep;
			}
		}
		else
			chaine += "\n" + message + sep;
		
		return chaine;
	}
	
	public String toString(){
		return this.afficher_liste_carte(liste_de_cartes_uniques, "Vous n'avez encore aucune carte !!");
	}
	
	public void rechercher_par_numero(int num){
		if(existe_carte(num))
			System.out.println(this.consulter_la_carte(num));
		else
			System.out.println("Aucune carte n'a ete trouvee pour le numero \"" + num + "\" !!");
	}
	
	public void rechercher_par_type(String type){
		HashMap<Integer, Carte> liste = new HashMap<Integer, Carte>();
		for(Carte carte:this.collection)
			if(carte.est_de_type(type))
				liste.put(carte.get_numero(), carte);
		System.out.println(this.afficher_liste_carte(liste, "Aucune carte n'a ete trouvee pour le type \"" + type + "\" !!"));
	}

	public String get_type(int numero) {
		if(existe_carte(numero))
			return this.liste_de_cartes_uniques.get(numero).type_de_carte();
		return "";
	}
	
	
}
