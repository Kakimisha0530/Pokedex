package interfaceGraphique;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cartes.Collection;

public class Menu extends JFrame{
	private static final long serialVersionUID = 1L;
	private Collection collection;
	private JButton ajouter = new JButton("Ajouter une carte");
	private JButton supprimer = new JButton("Supprimer une carte");
	private JButton modifier = new JButton("Modifier une carte");
	private JButton consulter = new JButton("Consulter mes cartes");
	private JButton rechercher = new JButton("Rechercher une carte");
	private JButton quitter = new JButton("Quitter");
	
	public Menu(Collection co){
		this.collection = co;
		if(this.collection == null)
			this.collection = new Collection();
		
		this.initialiser();
	}
	
	private void initialiser(){
		this.setTitle("GESTIONNAIRE DE POKEMON");
		this.setSize(250,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		JPanel panneau = new JPanel();
		panneau.setLayout(new FlowLayout());
		ajouter.addActionListener(new Ajouter());
		supprimer.addActionListener(new Supprimer());
		modifier.addActionListener(new Modifier());
		consulter.addActionListener(new Consulter());
		rechercher.addActionListener(new Rechercher());
		quitter.addActionListener(new Quitter());
		panneau.add(ajouter);
		panneau.add(modifier);
		panneau.add(supprimer);
		panneau.add(consulter);
		panneau.add(rechercher);
		panneau.add(quitter);
		panneau.add(new JPanel());
		
		this.add(panneau);
	}
	
	class Ajouter implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	class Supprimer implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	class Consulter implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new FenetreConsulter(collection);
		}
	}
	class Rechercher implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	class Modifier implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	class Quitter implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
}
