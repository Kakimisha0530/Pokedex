package cartes;

public class Energie extends Carte {

	private int type_energie;

	public Energie(int num, int type) {
		super(num, "");
		this.type_energie = type;
	}

	@Override
	public String type_de_carte() {
		return "ENERGIE";
	}

	public String toString() {
		String chaine = this.type_de_carte();
		chaine += "\t / \t" + TypeEnergie.ENERGY_NAME[this.type_energie];
		chaine += "\n=========================";
		chaine += "\n" + this.numero;
		return chaine;
	}

}
