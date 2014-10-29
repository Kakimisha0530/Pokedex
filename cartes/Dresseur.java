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

	/**
	 * Permet de mettre &agrave; jour le texte correspondant aux actions de la carte dresseur
	 * @param actions
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}
	
	/**
	 * Retourne les actions associ&eacute;es &agrave; cette carte
	 * @return
	 */
	public String getActions() {
		return actions;
	}
	
	/**
	 * Retourne le nombre repr&eacute;sentant le type de dresseur
	 * @return
	 */
	public int getTypeDresseur(){
		return this.type_dresseur;
	}
	
	/**
	 * Retourne le nom correspondant au type de dresseur
	 * @return
	 */
	public String getTypeDresseurNom(){
		return this.TYPE_DRESSEUR_NOM[this.type_dresseur];
	}
	
	/**
	 * Retourne les r&egrave;gles correspondantes au type de dresseur
	 * @return
	 */
	public String getTypeDresseurRegle(){
		return this.TYPE_DRESSEUR_REGLE[this.type_dresseur];
	}

	@Override
	public String typeDeCarte() {
		return "Dresseur";
	}
}
