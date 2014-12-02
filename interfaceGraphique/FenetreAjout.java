package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.Utils;
import cartes.Carte.TypeDeCarte;
import cartes.Carte;
import cartes.Collection;

public class FenetreAjout {

	private JFrame fenetre;
	private Collection collection;
	private HashMap<String, Object> donnees;
	private JPanel contentPane;
	private JTextField numero;
	private JLabel erreur;
	private JComboBox<String> types;
	private int vue;

	public FenetreAjout(Collection co) {
		this.collection = co;
		if (this.collection == null)
			this.collection = new Collection();

		this.donnees = new HashMap<>();
		this.vue = 0;

		this.initialiser();
		this.fenetre.setVisible(true);
	}

	private void initialiser() {
		this.fenetre = new JFrame();
		this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetre.setTitle("AJOUTER UNE CARTE");
		this.fenetre.setSize(500, 200);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		this.fenetre.setContentPane(contentPane);
		this.choix_numero();
	}

	public void afficher_vue() {
		switch (this.vue) {
		case 1:
			this.copier();
			break;
		case 2:
			this.choix_type();
			break;
		case 20:
			this.carte_dresseur();
			break;
		case 21:
			this.carte_energie();;
			break;
		case 22:
			this.carte_pokemon();
			break;
		default:
			this.choix_numero();
			break;
		}

		this.fenetre.revalidate();
	}

	private void choix_numero() {
		this.fenetre.setSize(500, 200);
		contentPane.removeAll();
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 2, 10, 20));
		panel.add(new JPanel());
		erreur = new JLabel("Numero invalide !!");
		erreur.setVerticalAlignment(SwingConstants.BOTTOM);
		erreur.setHorizontalAlignment(SwingConstants.CENTER);
		erreur.setForeground(Color.RED);
		erreur.setFont(new Font("Dialog", Font.ITALIC, 12));
		erreur.setVisible(false);
		panel.add(erreur);
		JLabel lblNumero = new JLabel("Numero de la carte : ");
		panel.add(lblNumero);
		numero = new JTextField();
		panel.add(numero);
		numero.setColumns(5);
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
			}
		});
		panel.add(retour);
		JButton suivant = new JButton("Suivant");
		suivant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String num = numero.getText();
				if (num != null && !num.isEmpty() && Utils.isInteger(num)) {
					donnees.put("numero", num);
					if (collection.existe_carte(Integer.parseInt(num)))
						vue = 1;
					else
						vue = 2;
					afficher_vue();
				} else
					erreur.setVisible(true);

			}
		});
		panel.add(suivant);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.EAST);
	}

	private void copier() {
		this.fenetre.setSize(500, 250);
		contentPane.removeAll();
		JPanel panel = new JPanel();
		int num = Integer.parseInt((String) donnees.get("numero"));
		HashMap<String, Object> infos = collection
				.information_sur_la_carte(num);
		contentPane.add(panel, BorderLayout.CENTER);
		String txt = "<html><head></head><body>";
		txt += "<h2>Cette carte existe deja.</h2>";
		txt += "<p>Type : " + infos.get("type") + "</p>";
		if (infos.get("nom") != null)
			txt += "<p>Nom : " + infos.get("nom") + "</p>";
		if (infos.get("type_energie") != null)
			txt += "<p>Energie : " + infos.get("type_energie") + "</p>";
		if (infos.get("type_dresseur") != null)
			txt += "<p>Type de dresseur : " + infos.get("type_dresseur")
					+ "</p>";
		txt += "<p>Exemplaires : " + infos.get("exemplaires") + "</p>";
		txt += "<h2>Voulez vous la dupliquée ?</h2>";
		txt += "</body></html>";
		JLabel texte = new JLabel(txt);
		panel.add(texte);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(2, 5, 10, 10));
		panel_1.add(new JPanel());
		JButton btnNon = new JButton("Non");
		btnNon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vue = 0;
				afficher_vue();
			}
		});
		panel_1.add(btnNon);
		panel_1.add(new JPanel());
		JButton btnOui = new JButton("Oui");
		btnOui.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt((String) donnees.get("numero"));
				if (collection.copier_carte(num))
					comfirmer("La copie de la carte a bien été crée !!");
			}
		});
		panel_1.add(btnOui);
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
	}

	public void comfirmer(String message) {
		JOptionPane.showMessageDialog(null, message, "Ajouter une carte",
				JOptionPane.INFORMATION_MESSAGE);
		this.vue = 0;
		this.afficher_vue();
	}

	private void choix_type() {
		this.fenetre.setSize(500, 100);
		contentPane.removeAll();
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 10, 20));
		JLabel lblNumero = new JLabel("Type de la carte : ");
		panel.add(lblNumero);
		types = new JComboBox<>();
		for (TypeDeCarte t : Carte.TypeDeCarte.values())
			types.addItem(t.name());
		types.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int t = types.getSelectedIndex();
				vue = Integer.parseInt(vue + "" + t);
			}
		});
		panel.add(types);
		panel.add(new JPanel());

		JButton suivant = new JButton("Suivant");
		suivant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				afficher_vue();
			}
		});
		panel.add(suivant);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.EAST);
	}

	private void carte_pokemon() {
		System.out.println("pokemon");
	}

	private void carte_dresseur() {
		System.out.println("dresseur");
	}

	private void carte_energie() {
		System.out.println("energie");
	}
}
