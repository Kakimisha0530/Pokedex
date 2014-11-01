package cartes;

public abstract class Carte {
	protected String nom;
	protected int numero;

	public Carte(int num, String nom) {
		this.nom = nom;
		this.numero = num;
	}
	
	public boolean numero_inferieur_a(int taille){
		return this.numero <= taille;
	}

	public abstract String type_de_carte();
	
	// public abstract String afficher_carte();
}
