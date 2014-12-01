package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cartes.Collection;

public class FenetreConsulter extends JFrame {

	private static final long serialVersionUID = 1L;
	private Collection collection;
	private JPanel contentPane;
	private JLabel suivant ,precedent;
	private JLabel carte;
	private String repertoire;
	private ArrayList<Integer> liste_vue;
	private int vue;

	public FenetreConsulter(Collection co) {
		this.collection = co;
		if (this.collection == null)
			this.collection = new Collection();

		this.liste_vue = this.collection.liste_de_carte();
		URL chemin = this.getClass().getResource("");
		String uri = chemin.getPath();
		this.repertoire = uri.split("bin")[0];
		this.repertoire += "ressources/images/";

		this.initialiser();
		this.setVisible(true);
	}

	private void initialiser() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Consulter mes cartes");
		this.setSize(500, 600);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		
		JPanel centre = new JPanel();
		contentPane.add(centre, BorderLayout.CENTER);
		
		JPanel entete = new JPanel();
		contentPane.add(entete, BorderLayout.NORTH);
		contentPane.add(new JPanel(), BorderLayout.SOUTH);
		
		JPanel gauche = new JPanel();
		contentPane.add(gauche, BorderLayout.EAST);
		gauche.setLayout(new BorderLayout(0, 0));
		suivant = new JLabel(new ImageIcon(this.repertoire + "next.png") , JLabel.CENTER);
		suivant.addMouseListener(new Suivant());
		gauche.add(suivant);
		
		JPanel droite = new JPanel();
		contentPane.add(droite, BorderLayout.WEST);
		droite.setLayout(new BorderLayout(0, 0));
		precedent = new JLabel(new ImageIcon(this.repertoire + "prev.png") , JLabel.CENTER);
		precedent.addMouseListener(new Precedent());
		droite.add(precedent);
		
		carte = new JLabel("aucun visuel");
		carte.setVisible(true);
		carte.setFont(new Font("Serif", Font.PLAIN, 14));
		carte.setForeground(Color.MAGENTA);
		centre.add(carte);
		this.vue = 0;
		afficher(this.vue, 0);
	}

	public void afficher(int index, int pas) {

		this.vue += pas;
		precedent.setVisible(true);
		suivant.setVisible(true);
		if (this.vue <= 0)
			precedent.setVisible(false);
		if (this.vue >= (this.liste_vue.size() - 1))
			suivant.setVisible(false);

		if (this.vue >= 0 && this.vue < this.liste_vue.size()) {
			String chaine = "<html>";
			HashMap<String, Object> infos = this.collection.information_sur_la_carte(
					this.liste_vue.get(this.vue));
			if(infos != null){
				for (String s : infos.keySet())
					chaine += s + " : " + infos.get(s) + "<br>";
			}
			
			this.carte.setText(chaine + "</html>");
		}

	}

	class Suivant implements MouseListener {	
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			afficher(vue, 1);
		}
	}

	class Precedent implements MouseListener {	
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			afficher(vue, -1);
		}
	}
}
