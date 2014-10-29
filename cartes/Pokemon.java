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
	
	
	
	public int getPoints_de_vie() {
		return points_de_vie;
	}



	public void setPoints_de_vie(int points_de_vie) {
		this.points_de_vie = points_de_vie;
	}



	public int getNiveau() {
		return niveau;
	}



	public int getType_energie() {
		return type_energie;
	}



	public ArrayList<Attaque> getAttaques() {
		return attaques;
	}



	public String[] getNIVEAU_NOM() {
		return NIVEAU_NOM;
	}



	@Override
	public String typeDeCarte() {
		return "Pokemon";
	}
}
