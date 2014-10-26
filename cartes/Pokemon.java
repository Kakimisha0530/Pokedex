package cartes;

/**
 * 
 * @author aicha
 *
 */
public class Pokemon extends Carte
{
	private int niveau;
	private int points_de_vie;
	private int type_energie;
	private Attaque[] attaques;
	
	
	public Pokemon(int num,String nom) {
		super(num,nom);
	}
	
	@Override
	public String typeDeCarte() {
		// TODO Auto-generated method stub
		return null;
	}
}
