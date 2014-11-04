package cartes;

import java.util.HashMap;

import com.google.gson.Gson;

/**
 * 
 * @author aicha
 *
 */
public class Pokemon extends Carte
{
	private transient static final long serialVersionUID = 1L;
	private int niveau;
	private int points_de_vie;
	private int type_energie;
	private HashMap<String,Attaque> attaques;
	private static transient final String[] NIVEAU_NOM = {"Basic","Niveau 1","Niveau 2"};
	
	
	public Pokemon(int num,int type,int pts_de_vies,String nom,int niveau,HashMap<String,Attaque> attaques) {
		super(num,nom);
		if(attaques != null)
			this.attaques = attaques;
		else
			this.attaques = new HashMap<>();
		this.niveau = niveau;
		this.points_de_vie = pts_de_vies;
		this.type_energie = type;
	}
	
	
	@Override
	public String type_de_carte() {
		return "POKEMON";
	}

	public String toString(){
		String chaine = this.type_de_carte();
		chaine += " / " + NIVEAU_NOM[this.niveau];
		chaine += "\nNom : " + this.nom;
		chaine += "\nPoints de vies : " + this.points_de_vie;
		chaine += "\nEnergie : " + TypeEnergie.NOMS[this.type_energie];
		chaine += "\n\t\t ATTAQUES : \n";
		int i = 0;
		for(String s : this.attaques.keySet()){
			chaine += "\n" + this.attaques.get(s).toString();
			if(i < attaques.size() - 1) chaine += "--------------------------------";
			i++;
		}
		chaine += "\n========================================";
		chaine += "\nN° : " + this.numero;
		return chaine;
	}
	
	public static void affiche_niveau_pokemon() {
		for (int i = 0; i < NIVEAU_NOM.length; i++)
			System.out.print((i + 1) + ". " + NIVEAU_NOM[i] + "\t");
	}

	@Override
	public Object clone() {
		Pokemon temp = (Pokemon)super.clone();
		temp.attaques = this.attaques;
		temp.niveau = this.niveau;
		temp.points_de_vie = this.points_de_vie;
		temp.type_energie = this.type_energie;
		return temp;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Carte modifier_carte(HashMap<String, Object> map) {
		String nom_bis = this.nom;
		int type_bis = this.type_energie,pts_de_vie = this.points_de_vie,niveau_bis = this.niveau;
		HashMap<String, Attaque> att = this.attaques;
		if(map.get("nom") instanceof String && !map.get("nom").equals(""))
			nom_bis = map.get("nom").toString();
		if(map.get("type") instanceof Integer)
			type_bis = ((Integer)map.get("type") < 0 || (Integer)map.get("type") > TypeEnergie.NOMS.length)?this.type_energie:(Integer)map.get("type");
		if(map.get("pts_de_vie") instanceof Integer)
			pts_de_vie = ((Integer)map.get("pts_de_vie") > 0)?(Integer)map.get("pts_de_vie"):this.points_de_vie;
		if(map.get("niveau") instanceof Integer)
			niveau_bis = ((Integer)map.get("niveau") < 0 || (Integer)map.get("niveau") > NIVEAU_NOM.length)?this.niveau:(Integer)map.get("niveau");
		
		if(map.get("attaques") instanceof HashMap){
			HashMap<String, Attaque> att_bis = (HashMap<String, Attaque>)map.get("attaques");
			if(map.get("concat_attaques") != null)
				for(String n : att_bis.keySet())
					att.put(n, att_bis.get(n));
			else
				att = att_bis;
					
		}
		
		return new Pokemon(this.numero, type_bis , pts_de_vie, nom_bis, niveau_bis, att);
	}
	
	@Override
	public Carte json_en_carte(String json) {
		Gson gson = new Gson();
		Pokemon carte = gson.fromJson(json, this.getClass());
		return carte;
	}
}
