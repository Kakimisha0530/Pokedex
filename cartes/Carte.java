package cartes;

import java.io.Serializable;

public abstract class Carte implements Serializable{
	
	private transient static final long serialVersionUID = 1L;
	protected String nom;
	protected int numero;

	public Carte(int num, String nom) {
		this.nom = nom;
		this.numero = num;
	}
	
	public boolean numero_inferieur_a(int taille){
		return this.numero <= taille;
	}
	
	public int get_numero(){
		return this.numero;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Carte) {
			Carte carte = (Carte) obj;
			return this.numero == carte.numero;
		}
		return false;
	}

	public abstract String type_de_carte();
	
	public abstract Carte copier_carte();
	

}
