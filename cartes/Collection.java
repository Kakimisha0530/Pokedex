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

	public void supprimer_une_carte(int index) {
		if(index < this.collection.size()){
			Carte carte = this.collection.get(index);
			this.statistiques.put(carte.get_numero(), this.statistiques.get(carte.get_numero()) - 1);
			if(this.statistiques.get(carte.get_numero()) < 1)
				this.liste_de_cartes_uniques.remove(carte.get_numero());
			this.collection.remove(index);
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
	
	public String toString(){
		String sep = "\n*****************************************************";
		String chaine = "";
		chaine += sep;
		
		if(this.collection.size() > 0){
			for (int num : this.liste_de_cartes_uniques.keySet()) {
				chaine += "\n" + this.consulter_la_carte(num);
				chaine += sep;
			}
		}
		else
			chaine += "\nVous n'avez encore aucune carte !!" + sep;
		
		return chaine;
	}

	public String get_type(int numero) {
		if(existe_carte(numero))
			return this.liste_de_cartes_uniques.get(numero).type_de_carte();
		return "";
	}
	
	
}
