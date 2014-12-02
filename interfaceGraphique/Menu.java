package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import cartes.Collection;

public class Menu extends JFrame{
	private static final long serialVersionUID = 1L;
	private Collection collection;
	private JPanel contentPane;
	private JButton ajouter = new JButton("Ajouter une carte");
	private JButton consulter = new JButton("Consulter mes cartes");
	private JButton rechercher = new JButton("Rechercher une carte");
	private JButton quitter = new JButton("Quitter");
	
	public Menu(Collection co){
		this.collection = co;
		if(this.collection == null)
			this.collection = new Collection();
	}
	
	public void lancer(){
		this.initialiser();
		this.setVisible(true);
	}
	
	private void initialiser(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setTitle("GESTIONNAIRE DE POKEMON");
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		ajouter.addActionListener(new Ajouter());
		consulter.addActionListener(new Consulter());
		rechercher.addActionListener(new Rechercher());
		quitter.addActionListener(new Quitter());
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 2, 5, 5));
		panel.add(ajouter);
		panel.add(new JPanel());
		panel.add(new JPanel());
		panel.add(consulter);
		panel.add(rechercher);
		panel.add(new JPanel());
		panel.add(new JPanel());
		panel.add(quitter);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel titreMenu = new JLabel("Menu");
		titreMenu.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(titreMenu);
		titreMenu.setForeground(new Color(51, 102, 153));
		titreMenu.setFont(new Font("Courier 10 Pitch", Font.BOLD, 55));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		//JLabel vide = new JLabel("    ");
		//vide.setFont(new Font("Courier 10 Pitch", Font.BOLD, 29));
		//panel_4.add(vide);
	}
	
	class Ajouter implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new FenetreAjout(collection);
		}
	}
	
	class Consulter implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new FenetreConsulter(collection,null);
		}
	}
	
	class Rechercher implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			new FenetreRecherche(collection);
		}
	}
	
	class Quitter implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
}
