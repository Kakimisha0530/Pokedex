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
	
	
	public Pokemon(int num,String nom) {
		super(num,nom);
		this.attaques = new ArrayList<>();
	}

	/**
	 * Retourne le nombre correspondant au niveau du pok&eacute;mon
	 * @return 
	 */
	public int getNiveau() {
		return this.niveau;
	}
	
	/**
	 * Retourne le nom correspondant au niveau du pok&eacute;mon
	 * @return 
	 */
	public String getNomNiveau() {
		return this.NIVEAU_NOM[this.niveau];
	}

	/**
	 * Retourne les points de vie du pok&eacute;mon
	 * @return 
	 */
	public int getPoints_de_vie() {
		return this.points_de_vie;
	}

	/**
	 * Retourne le nombre repr&eacute;sentant le type d'&eacute;nergie associ&eacute; au pok&eacute;mon
	 * @return 
	 */
	public int getType_energie() {
		return this.type_energie;
	}

	/**
	 * Retourne l'attaque &agrave; l'index fourni
	 * @param index
	 * @return
	 */
	public Attaque getAttaque(int index) {
		return this.attaques.get(index);
	}
	
	/**
	 * Permet d'ajouter la description d'une attaque &agrave; notre liste d'attaque
	 * @param at
	 */
	public void addAttaque(Attaque at) {
		this.attaques.add(at);
	}

	/**
	 * Retourne le nom correspondant au type d'&eacute;nergie associ&eacute; &agrave; la carte
	 * @return
	 */
	public String getNomTypeEnergie() {
		return TypeEnergie.ENERGY_NAME[this.type_energie];
	}
	
	@Override
	public String typeDeCarte() {
		return "Pokemon";
	}
}
