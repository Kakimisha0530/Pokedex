package cartes;

public abstract class Carte
{
	private String nom;
	private int numero;
	
	public Carte(int num,String nom) {
		this.nom = nom;
		this.numero = num;
	}
	
	public String getNom() {
		return this.nom;
	}

	public int getNumero() {
		return this.numero;
	}

	public abstract String typeDeCarte();
}
