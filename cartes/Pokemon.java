package cartes;

import java.util.ArrayList;

/**
 * 
 * @author aicha
 *
 */
public class Pokemon extends Carte
{
	private int niveau;
	private int points_de_vie;
	private int type_energie;
	private ArrayList<Attaque> attaques;
	private final String[] 	NIVEAU_NOM = {"Basic","Niveau 1","Niveau 2"};
	
	
	public Pokemon(int num,String nom,int niveau,ArrayList<Attaque> attaques) {
		super(num,nom);
		if(attaques != null)
			this.attaques = attaques;
		else
			this.attaques = new ArrayList<>();
	}
	
	
	@Override
	public String type_de_carte() {
		return "POKEMON";
	}

	public String toString(){
		String chaine = this.NIVEAU_NOM[this.niveau];
		chaine += "\t / \t" + this.nom;
		chaine += "\t / \t" + this.points_de_vie;
		chaine += "\t / \t" + TypeEnergie.NOMS[this.type_energie];
		chaine += "\n========================================";
		for(int i = 0; i < attaques.size();i++){
			chaine += "\n" + this.attaques.get(i).toString();
			if(i < attaques.size() - 1) chaine += "--------------------------------";
		}
		chaine += "\n========================================";
		chaine += "\n" + this.numero;
		return chaine;
	}

	@Override
	public Carte copier_carte() {
		return new Pokemon(this.numero, this.nom, this.niveau, this.attaques);
	}
}
