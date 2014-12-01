package cartes;

/**
 * 
 * @author aicha
 *
 */
public enum TypeEnergie {
	INCOLORE("","","IN"),
	PLANTE("","","PL"),
	FEU("","","FEU"),
	EAU("","","EAU"),
	ELECTRIQUE("","","EL"),
	PSYCHIQUE("","","PSY"),
	COMBAT("","","CO"),
	OBSCURITE("","","OBS"),
	METAL("","","ME"),
	FEE("","","FEE"),
	DRAGON("","","DRA");
	
	private String couleur, icone , symbol_str;

	TypeEnergie(String couleur,String symbol_icone,String symbol_str){
		this.symbol_str = symbol_str;
		this.couleur = couleur;
		this.icone = symbol_icone;
	}
	
	public String get_couleur(){
		return this.couleur;
	}
	
	public String get_symbol_icone(){
		return this.icone;
	}
	
	public String get_symbol_str(){
		return this.symbol_str;
	}
}
