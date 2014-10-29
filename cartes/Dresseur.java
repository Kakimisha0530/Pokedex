package cartes;

/**
 * Cette classe repr&eacute;sente les cartes de type Dresseur.
 * Ils en existe trois types qui sont : 
 * Chaque carte poss&egrave;de un nom, un numero dans la collection
 * 
 * @author aicha
 * 
 */
public class Dresseur extends Carte{
	private int type_dresseur;
	private String actions;
	private final String[] 	TYPE_DRESSEUR_NOM = {"Objet","Supporter","Stade"};
	private final String[] 	TYPE_DRESSEUR_REGLE = {"","",""};
	
	public Dresseur(int num,int type,String nom) {
		super(num,nom);
		this.type_dresseur = type;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}
	
	public String getActions() {
		return actions;
	}
	
	public int getTypeDresseur(){
		return this.type_dresseur;
	}

	@Override
	public String typeDeCarte() {
		return "Dresseur";
	}
}
