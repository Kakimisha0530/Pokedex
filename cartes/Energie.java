package cartes;

public class Energie extends Carte {

	private int type_energie;
	
	public Energie(int num, int type , String nom) {
		super(num, nom);
		this.type_energie = type;
	}
	/**
	 * Retourne le nombre représentant le type d'énergie associé à la carte
	 * @return
	 */
	public int getType_energie() {
		return type_energie;
	}
	
	/**
	 * Retourne le nom correspondant au type d'énergie associé à la carte
	 * @return
	 */
	public String getNomTypeEnergie() {
		return TypeEnergie.ENERGY_NAME[type_energie];
	}
	
	@Override
	public String typeDeCarte() {
		return "Energie";
	}

}
