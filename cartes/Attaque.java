package cartes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cette classe permet de d&eacute;finir les attaques des pok&eacute;mons
 * 
 * @author aicha
 */
public class Attaque implements Serializable{
	
	private transient static final long serialVersionUID = 1L;
	private String nom;
	private int degats;
	private char bonus_char;
	private String description;
	private ArrayList<Integer> energies;

	public Attaque(String nom, int degats, char bonus_char, String description,
			ArrayList<Integer> energies) {
		this.nom = nom;
		this.degats = degats;
		this.bonus_char = (bonus_char != '+' && bonus_char != '*' && bonus_char != '-') ? ' '
				: bonus_char;
		this.description = description;
		this.energies = energies;
		if (this.energies == null)
			this.energies = new ArrayList<>();
	}
	

	/**
	 * Retourne les d&eacute;gats totaux &agrave; inflig&eacute;s par l'attaque.<br>
	 * Suivant certaines conditions le nombre de d&eacute;gats peut &ecirc;tre
	 * multipli&eacute;, incr&eacute;menter ou d&eacute;cr&eacute;ment&eacute;.<br>
	 * Dans ces cas l&agrave; la valeur des d&eacute;gats totaux est
	 * d&eacute;termin&eacute; par la valeur de l'attribut bonus_char et du
	 * param&egrave;tre bonus (qui n'en est pas toujours un).
	 * 
	 * @param bonus
	 * 
	 * @return
	 */
	public int degats_totaux(int bonus) {
		int total_degat = this.degats;
		int symbol = (int) this.bonus_char;
		switch (symbol) {
		case 42:
			total_degat *= bonus;
			break;
		case 43:
			total_degat += bonus;
			break;
		case 45:
			total_degat -= bonus;
			break;
		default:
			break;
		}
		return total_degat;
	}

	@Override
	public String toString() {
		String chaine = "";
		for (int energie : this.energies) {
			chaine += "[" + TypeEnergie.values()[energie].get_symbol_str() + "] ";
		}
		chaine += "\t" + this.nom;
		chaine += "\t" + this.degats + this.bonus_char;
		if (this.description != "")
			chaine += "\n" + this.description;
		return chaine;
	}
	
	public String get_nom(){
		return this.nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Attaque && super.equals(obj)) {
			Attaque att = (Attaque) obj;
			return this.nom.equals(att.nom) && this.degats == att.degats
					&& this.bonus_char == att.bonus_char
					&& this.description.equals(att.description)
					&& this.energies.equals(att.energies);
		}
		return false;
	}

}
