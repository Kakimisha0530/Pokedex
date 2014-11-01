/**
 * 
 */
package cartes;

import java.util.ArrayList;

import sauvegarde.SauvegardeBinaire;

/**
 * @author aicha
 * 
 */
public class Collection extends SauvegardeBinaire{

	private static transient final long serialVersionUID = 1L;
	private ArrayList<Carte> collection;
	public static final int TAILLE_PAR_DEFAUT = 39;
	private int taille;

	public Collection(int taille) {
		if(!this.recuperer()){
			this.taille = taille;
			this.collection = new ArrayList<>();
		}
	}
	
	public Collection() {
		this(TAILLE_PAR_DEFAUT);
	}

	public void supprimer_une_carte(int index) {
		if(index < this.collection.size())
			this.collection.remove(index);
	}

	public boolean ajouter_une_carte(Carte carte) {
		if(carte != null && carte.numero_inferieur_a(this.taille)){
			this.collection.add(carte);
			return true;
		}
		return false;
	}

	public String voir_la_carte(int index) {
		return (this.collection.get(index) != null) ? this.collection
				.get(index).toString() : "";
	}
	

	@Override
	protected void charger(Object obj) {
		if(obj instanceof Collection && obj != null){
			Collection jeu = (Collection)obj;
			this.taille = jeu.taille;
			this.collection = jeu.collection;
		}			
	}
	
	
}
