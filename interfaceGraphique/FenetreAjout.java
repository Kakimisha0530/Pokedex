package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cartes.Collection;

public class FenetreAjout extends JFrame{

	private static final long serialVersionUID = 1L;
	private Collection collection;
	private HashMap<String, Object> donnees;
	private JPanel main, panel_vue;
	private int vue;
	
	public FenetreAjout(Collection co){
		this.collection = co;
		if (this.collection == null)
			this.collection = new Collection();
		
		this.donnees = new HashMap<>();
		this.vue = 0;
		
		this.initialiser();
	}
	
	private void initialiser(){
		this.setTitle("Ajouter une carte");
		this.setSize(700,500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		main = new JPanel();
		main.setLayout(new FlowLayout());
		this.afficher_vue(vue);
	}
	
	private void afficher_vue(int vue){
		switch(vue){
		case 0: 
			this.panel_vue = new JPanel();
			this.panel_vue.add(new JLabel("numero de la carte :  "));
			this.panel_vue.add(new JTextField());
			this.panel_vue.setVisible(true);
			this.main.add(panel_vue);
			System.out.println("affiche");
			break;
		default:break;
		}
	}
}
