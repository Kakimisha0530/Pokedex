package cartes;

import java.util.ArrayList;

/**
 * Cette classe permet de d&eacute;finir les attaques des pok&eacute;mons
 * @author aicha
 */
public class Attaque
{
	private String nom;
	private int degats;
	private char bonus_char;
	private String description;
	private ArrayList<Integer> energies;
	
	
	public Attaque(String nom, int degats, char bonus_char, String description) {
		this.nom = nom;
		this.degats = degats;
		this.setBonus_char(bonus_char);
		this.description = description;
		this.energies = new ArrayList<>();
	}
	
	/**
	 * Ajout d'un type d'&eacute;nergie n&eacute;cessaire pour l'attaque
	 * @param en
	 */
	public void addEnergie(int en){
		this.energies.add(en);
	}

	/**
	 * Retourne le nom de l'attaque
	 * @return 
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne les d&eacute;gats totaux &agrave; inflig&eacute;s par l'attaque.<br>
	 * Suivant certaines conditions le nombre de d&eacute;gats peut &ecirc;tre 
	 * multipli&eacute;, incr&eacute;menter ou d&eacute;cr&eacute;ment&eacute;.<br>
	 * Dans ces cas l&agrave; la valeur des d&eacute;gats totaux est d&eacute;termin&eacute; par la valeur 
	 * de l'attribut bonus_char et du param&egrave;tre bonus (qui n'en est pas toujours un).
	 * 
	 * @param bonus
	 * 
	 * @return 
	 */
	public int getDegats(int bonus) {
		return this.degats;
	}
	
	/**
	 * Retourne une chaine de caract&egrave;res repr&eacute;sentant le nombre de d&eacute;gat inflig&eacute; par l'attaque
	 * @return
	 */
	public String getDegatsString(){
		return this.degats + "" + this.bonus_char;
	}

	/**
	 * Retourne la description de l'attaque
	 * @return 
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Le type d'&eacute;nergie correspondant &agrave; l'index fourni
	 * @return 
	 */
	public int getEnergie(int index) {
		return this.energies.get(index);
	}

	/**
	 * Permet de definir l'op&eacute;rateur pour le calcul du total des d&eacute;gats
	 * @param 
	 */
	private void setBonus_char(char bonus_char) {
		
		this.bonus_char = (bonus_char != '+' && bonus_char != '*' && bonus_char != '-')?' ':bonus_char;
	}
}
