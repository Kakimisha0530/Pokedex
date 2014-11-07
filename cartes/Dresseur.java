package cartes;

import java.util.HashMap;

import com.google.gson.Gson;

/**
 * Cette classe repr&eacute;sente les cartes de type Dresseur. Ils en existe
 * trois types qui sont : Chaque carte poss&egrave;de un nom, un numero dans la
 * collection
 * 
 * @author aicha
 * 
 */
public class Dresseur extends Carte {
	private transient static final long serialVersionUID = 1L;
	private int type_dresseur;
	private String actions;
	private transient static final String[] TYPE_DRESSEUR_NOM = { "Objet", "Supporter", "Stade" };
	private transient static final String[] TYPE_DRESSEUR_REGLE = { "", "", "" };

	public Dresseur(int num, int type, String nom, String actions) {
		super(num, nom);
		this.type_dresseur = type;
		this.actions = actions;
	}

	@Override
	public String type_de_carte() {
		return "DRESSEUR";
	}

	public static void affiche_dresseurs_types() {
		for (int i = 0; i < TYPE_DRESSEUR_NOM.length; i++)
			System.out.print((i + 1) + ". " + TYPE_DRESSEUR_NOM[i] + "\t");
	}

	public String toString() {
		String chaine = this.type_de_carte();
		chaine += " / " + TYPE_DRESSEUR_NOM[this.type_dresseur];
		chaine += "\nNom :" + this.nom;
		chaine += "\nActions : " + this.actions;
		chaine += "\nRegles : " + TYPE_DRESSEUR_REGLE[this.type_dresseur];
		chaine += "\n=========================";
		chaine += "\nN° : " + this.numero;

		return chaine;
	}

	@Override
	public Object clone() {
		Dresseur temp = (Dresseur)super.clone();
		temp.actions = this.actions;
		temp.type_dresseur = this.type_dresseur;
		return temp;
	}
	
	@Override
	public Carte modifier_carte(HashMap<String, Object> map) {
		String nom = this.nom,actions = this.actions;
		int type = this.type_dresseur;
		if(map.get("nom") instanceof String && !map.get("nom").equals(""))
			nom = map.get("nom").toString();
		if(map.get("actions") instanceof String && !map.get("actions").equals(this.actions))
			actions = map.get("actions").toString();
		if(map.get("type") instanceof Integer)
			type = ((Integer)map.get("type") < 0 || (Integer)map.get("type") > TYPE_DRESSEUR_NOM.length)?this.type_dresseur:(Integer)map.get("type");
		
		return new Dresseur(this.numero, type , nom,actions);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public Carte json_en_carte(String json) {
		Gson gson = new Gson();
		Dresseur carte = gson.fromJson(json, this.getClass());
		return carte;
	}
	
	@Override
	public HashMap<String, Object> informations_sur_la_carte() {
		HashMap<String, Object> liste = new HashMap<String, Object>();
		liste.put("numero", this.numero);
		liste.put("nom", this.nom);
		liste.put("actions", this.actions);
		liste.put("type_dresseur", TYPE_DRESSEUR_NOM[this.type_dresseur]);
		return liste;
	}
}
