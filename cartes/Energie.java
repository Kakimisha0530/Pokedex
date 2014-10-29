package cartes;

public class Energie extends Carte {

	private int type_energie;
	
	public Energie(int num, int type , String nom) {
		super(num, nom);
		this.type_energie = type;
	}

	@Override
	public String typeDeCarte() {
		return "Energie";
	}

}
