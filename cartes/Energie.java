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
	
	public static void affiche_energies_types(){
		for(int i = 0;i < TypeEnergie.NOMS.length;i++){
			System.out.print((i+1) + ". " + TypeEnergie.NOMS[i] + "\t");
			if((i+1)%4 == 0)
				System.out.println();
		}
	}

	public String toString() {
		String chaine = this.type_de_carte();
		chaine += "\t / \t" + TypeEnergie.NOMS[this.type_energie];
		chaine += "\n=========================";
		chaine += "\n" + this.numero;
		return chaine;
	}

	@Override
	public Carte copier_carte() {
		return new Energie(this.numero, this.type_energie);
	}

}
