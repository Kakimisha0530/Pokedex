package interfaceGraphique;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cartes.Collection;

public class FenetreConsulter extends JFrame {

	private static final long serialVersionUID = 1L;
	private Collection collection;
	private JButton left = new JButton("<");
	private JButton right = new JButton(">");
	private JLabel carte;
	private ArrayList<Integer> liste_vue;
	private int vue;

	public FenetreConsulter(Collection co) {
		this.collection = co;
		if (this.collection == null)
			this.collection = new Collection();

		this.liste_vue = this.collection.liste_de_carte();

		this.initialiser();
	}

	private void initialiser() {
		this.setTitle("Consulter mes pokemons");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		JPanel panneau = new JPanel();
		panneau.setLayout(new FlowLayout());
		left = new JButton("<");
		left.setVisible(true);
		left.addActionListener(new Precedent());
		right = new JButton(">");
		right.addActionListener(new Suivant());
		right.setVisible(true);
		carte = new JLabel("aucun visuel");
		carte.setVisible(true);
		carte.setFont(new Font("Serif", Font.PLAIN, 14));
		carte.setForeground(Color.MAGENTA);
		JPanel vue_carte = new JPanel();
		vue_carte.setSize(300, 300);
		panneau.add(left);
		vue_carte.add(carte);
		panneau.add(vue_carte);
		panneau.add(right);
		this.vue = 0;
		afficher(this.vue, 0);
		this.add(panneau);
	}

	public void afficher(int index, int pas) {

		this.vue += pas;
		left.setVisible(true);
		right.setVisible(true);
		if (this.vue <= 0)
			left.setVisible(false);
		if (this.vue >= (this.liste_vue.size() - 1))
			right.setVisible(false);

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

	class Suivant implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			afficher(vue, 1);
		}
	}

	class Precedent implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			afficher(vue, -1);
		}
	}
}
