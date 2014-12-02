package cartes;

import java.util.HashMap;

public class Energie extends Carte {

	private transient static final long serialVersionUID = 1L;
	private int type_energie;

	public Energie(int num, int type) {
		super(num, "","default.png");
		this.type_energie = type;
	}

	@Override
	public String type_de_carte() {
		return Carte.TypeDeCarte.ENERGIE.name();
	}
	
	public static void affiche_energies_types(){
		TypeEnergie[] tab = TypeEnergie.values();
		for(TypeEnergie en : tab){
			System.out.print((en.ordinal()+1) + ". " + en.name() + "\t");
			if((en.ordinal()+1)%4 == 0)
				System.out.println();
		}
		System.out.println();
	}

	public String toString() {
		String chaine = this.type_de_carte();
		chaine += " / " + TypeEnergie.values()[this.type_energie].name();
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
			type = ((Integer)map.get("type") < 0 || (Integer)map.get("type") > TypeEnergie.values().length)?this.type_energie:(Integer)map.get("type");
		
		return new Energie(this.numero, type);
	}
	
	@Override
	public Carte json_en_carte(String json) {
		return null;
		/*Gson gson = new Gson();
		Energie carte = gson.fromJson(json, this.getClass());
		return carte;*/
	}
	
	@Override
	public HashMap<String, Object> informations_sur_la_carte() {
		HashMap<String, Object> liste = new HashMap<String, Object>();
		liste.put("type", this.type_de_carte());
		liste.put("numero", this.numero);
		liste.put("type_energie", TypeEnergie.values()[this.type_energie].name());
		return liste;
	}

}
