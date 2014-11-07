package cartes;

import java.util.HashMap;

import com.google.gson.Gson;

public class Energie extends Carte {

	private transient static final long serialVersionUID = 1L;
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
		System.out.println();
	}

	public String toString() {
		String chaine = this.type_de_carte();
		chaine += " / " + TypeEnergie.NOMS[this.type_energie];
		chaine += "\n=========================";
		chaine += "\nN° : " + this.numero;
		return chaine;
	}

	@Override
	public Object clone() {
		Energie temp = (Energie)super.clone();
		temp.type_energie = this.type_energie;
		return temp;
	}
	
	@Override
	public Carte modifier_carte(HashMap<String, Object> map) {
		int type = this.type_energie;
		if(map.get("type") instanceof Integer)
			type = ((Integer)map.get("type") < 0 || (Integer)map.get("type") > TypeEnergie.NOMS.length)?this.type_energie:(Integer)map.get("type");
		
		return new Energie(this.numero, type);
	}
	
	@Override
	public Carte json_en_carte(String json) {
		Gson gson = new Gson();
		Energie carte = gson.fromJson(json, this.getClass());
		return carte;
	}
	
	@Override
	public HashMap<String, Object> informations_sur_la_carte() {
		HashMap<String, Object> liste = new HashMap<String, Object>();
		liste.put("numero", this.numero);
		liste.put("type_energie", TypeEnergie.NOMS[this.type_energie]);
		return liste;
	}

}
