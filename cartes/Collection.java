/**
 * 
 */
package cartes;

import java.util.ArrayList;
import java.util.HashMap;

import sauvegarde.SauvegardeBinaire;

/**
 * @author aicha
 * 
 */
public class Collection extends SauvegardeBinaire{

	private static transient final long serialVersionUID = 1L;
	private ArrayList<Carte> collection;
	private transient HashMap<Integer,Carte> liste_de_cartes_uniques;
	private transient HashMap<Integer,Integer> statistiques;
	public static final int TAILLE_PAR_DEFAUT = 39;
	private int taille;

	public Collection(int taille) {
		if(!this.recuperer()){
			this.taille = taille;
			this.collection = new ArrayList<>();
		}
		this.actualiser();
	}
	
	public Collection() {
		this(TAILLE_PAR_DEFAUT);
	}
	
	private void actualiser(){
		this.liste_de_cartes_uniques = new HashMap<>();
		this.statistiques = new HashMap<>();
		for(Carte c:collection){
			this.liste_de_cartes_uniques.put(c.get_numero(), c);
			if(this.statistiques.containsKey(c.get_numero()))
					this.statistiques.put(c.get_numero(), this.statistiques.get(c.get_numero()) + 1);
			else
				this.statistiques.put(c.get_numero(), 1);
		}
		this.sauvegarder();
	}
	
	public int nombre_de_carte(){
		return this.collection.size();
	}

	public void supprimer_une_carte(int num,int nombre) {
		if(existe_carte(num)){
			Carte carte = this.liste_de_cartes_uniques.get(num);
			if(nombre < 0 || nombre > this.statistiques.get(num))
				nombre = this.statistiques.get(num);
			
			while(nombre > 0){
				int index = this.collection.indexOf(carte);
				System.out.println(index);
				if(index >= 0)this.collection.remove(index);
				nombre --;
			}
				
			this.actualiser();
		}
	}
	
	public void modifier_une_carte(int numero,HashMap<String, Object> map){
		if(existe_carte(numero)){
			Carte carte = this.liste_de_cartes_uniques.get(numero).modifier_carte(map);
			ajouter_une_carte(carte, true);
		}
	}

	public boolean ajouter_une_carte(Carte carte,boolean modif) {
		if(carte != null && carte.numero_inferieur_a(this.taille)){
			if(modif){
				int nb = this.statistiques.get(carte.get_numero());
				this.supprimer_une_carte(carte.get_numero(), this.statistiques.get(carte.get_numero()));
				for(int i = 0;i < nb ;i++)
					this.collection.add(carte);
					
			}
			else
				this.collection.add(carte);
			this.actualiser();
			return true;
		}
		return false;
	}
	
	public boolean copier_carte(int num){
		if(this.existe_carte(num)){
			Carte c = (Carte)this.liste_de_cartes_uniques.get(num).clone();
			this.collection.add(c);
			this.actualiser();
			return true;
		}
		return false;
	}
	
	public String consulter_la_carte(int numero) {
		return (this.liste_de_cartes_uniques.get(numero) != null) ? (this.liste_de_cartes_uniques
				.get(numero).toString() + "\nExemplaires : " + this.statistiques.get(numero)) : "Cette carte n'existe pas";
	}
	
	public HashMap<String, Object> information_sur_la_carte(int numero) {
		if(existe_carte(numero)){
			HashMap<String, Object> infos = this.liste_de_cartes_uniques.get(numero).informations_sur_la_carte();
			infos.put("exemplaires", this.statistiques.get(numero));
			return infos;
		}
		
		return null;
	}
	
	public ArrayList<Integer> liste_de_carte(){
		return this.liste_de_carte(this.liste_de_cartes_uniques);
	}
	
	public ArrayList<Integer> liste_de_carte(HashMap<Integer, Carte> cartes){
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(Integer numero : cartes.keySet())
			liste.add(numero);
		
		return liste;
	}
	
	public boolean existe_carte(int numero){
		return this.liste_de_cartes_uniques.containsKey(numero);
	}
	

	@Override
	protected void charger(Object obj) {
		if(obj instanceof Collection && obj != null){
			Collection jeu = (Collection)obj;
			this.taille = jeu.taille;
			this.collection = jeu.collection;
		}			
	}
	
	public String afficher_liste_carte(ArrayList<Integer> liste,String message){
		
		String sep = "\n*****************************************************";
		String chaine = "";
		chaine += sep;
		
		if(liste.size() > 0){
			for (int num : liste) {
				chaine += "\n" + this.consulter_la_carte(num);
				chaine += sep;
			}
		}
		else
			chaine += "\n" + message + sep;
		
		return chaine;
	}
	
	public String toString(){
		String chaine = "";
		if(this.collection.size() > 0){
			chaine += "\nVous possedez au total " + this.collection.size() + " cartes";
			chaine += " dont " + this.liste_de_cartes_uniques.size() + " cartes uniques.\n";
		}
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(int n : liste_de_cartes_uniques.keySet())
			liste.add(n);
		chaine += this.afficher_liste_carte(liste, "Vous n'avez encore aucune carte !!");
		return chaine;
	}
	
	/*public Carte rechercher_par_numero(int num){
		if(existe_carte(num))
			return 
			System.out.println(this.consulter_la_carte(num));
		else
			System.out.println("Aucune carte n'a ete trouvee pour le numero \"" + num + "\" !!");
	
			
	}*/
	
	public ArrayList<Integer> rechercher_par_type(String type){
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(Carte carte:this.collection)
			if(carte.est_de_type(type))
				liste.add(carte.get_numero());
		return liste;//, "Aucune carte n'a ete trouvee pour le type \"" + type + "\" !!"));
	}

	public String get_type(int numero) {
		if(existe_carte(numero))
			return this.liste_de_cartes_uniques.get(numero).type_de_carte();
		return "";
	}
	
	public void json_en_java(){
		String chaine = convertir_en_json();
		System.out.println(chaine);
		System.out.println();
		if(this.collection == null)
			this.collection = new ArrayList<Carte>();
		chaine = chaine.substring(1, (chaine.length() - 1));
		String[] liste = chaine.split(",");
	    for(String s : liste){
	    	/*if(s.indexOf("\"type_de_carte\":\"DRESSEUR\"") >= 0){
	    		Dresseur d = new Dresseur(0, 0, "", "");
	    		this.collection.add(d.json_en_carte(s));
	    		System.out.println("dresseur");
	    	}
	    	else if(s.indexOf("\"type_de_carte\":\"POKEMON\"") >= 0){
	    		Pokemon p = new Pokemon(0, 0, 0, "", 0, null);
	    		this.collection.add(p.json_en_carte(s));
	    		System.out.println("pokemon");
	    	}
	    	else if(s.indexOf("\"type_de_carte\":\"ENERGIE\"") >= 0){
	    		Energie e = new Energie(0, 0);
	    		this.collection.add(e.json_en_carte(s));
	    		System.out.println("energie");
	    	}*/
	    	
	    	System.out.println(s);
	    	
	    }
	    
	}

	public String convertir_en_json() {
		//Gson gson = new Gson();
		String chaine = "[";
		/*for(Carte c : this.collection)
			chaine += gson.toJson(c) + ",";
		if(chaine.charAt(chaine.length() - 1) == ',')
			chaine = chaine.substring(0, (chaine.length() - 1));*/
		chaine += "]";
		
		return chaine;
	}
}
