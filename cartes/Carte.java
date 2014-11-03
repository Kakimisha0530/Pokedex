package cartes;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Carte implements Serializable,Cloneable{
	
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
	
	public boolean est_de_type(String type){
		return this.type_de_carte().toLowerCase().equals(type.toLowerCase());
	}

	public abstract String type_de_carte();
	
	@Override
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		}
		catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}
		return o;
	}

	public abstract Carte modifier_carte(HashMap<String, Object> map);
	
}
