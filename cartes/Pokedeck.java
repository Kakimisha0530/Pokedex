package cartes;

import java.util.ArrayList;

import sauvegarde.SauvegardeBinaire;

/**
 * Représentation du deck
 * @author aicha
 *
 */
public class Pokedeck{

	private static final long serialVersionUID = 1L;
	private ArrayList<Carte> cartes;
	
	public Pokedeck() {
		this.cartes = new ArrayList<>();
	}
	
	public void supprimer_une_carte(int index) {
		this.cartes.remove(index);
	}	
	
	public void ajouter_une_carte(Carte carte) {
		this.cartes.add(carte);
	}
}
