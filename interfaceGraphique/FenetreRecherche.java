/**
 * 
 */
package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import utils.Utils;
import cartes.Carte;
import cartes.Carte.TypeDeCarte;
import cartes.Collection;

/**
 * @author aicha
 *
 */
public class FenetreRecherche{
	private Collection collection;
	private JFrame fenetre;
	private JPanel contentPane;
	private JTextField numero;
	private JComboBox<String> comboBox;
	private JButton btnRechercher;
	private JLabel erreur;
	
	public FenetreRecherche(Collection co){
		this.collection = co;
		this.initialiser();
		this.fenetre.setVisible(true);
	}
	
	private void initialiser(){
		this.fenetre = new JFrame();
		this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetre.setTitle("RECHERCHER UNE CARTE");
		this.fenetre.setSize(500, 200);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		this.fenetre.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 2, 10, 20));
		panel.add(new JPanel());
		erreur = new JLabel("Numero invalide !!");
		erreur.setVerticalAlignment(SwingConstants.BOTTOM);
		erreur.setHorizontalAlignment(SwingConstants.CENTER);
		erreur.setForeground(Color.RED);
		erreur.setFont(new Font("Dialog", Font.ITALIC, 12));
		panel.add(erreur);
		erreur.setVisible(false);
		JLabel lblNumero = new JLabel("Numero de la carte : ");
		panel.add(lblNumero);	
		numero = new JTextField();
		panel.add(numero);
		numero.setColumns(10);		
		JLabel lblTypeDeCarte = new JLabel("Type de carte : ");
		panel.add(lblTypeDeCarte);		
		comboBox = new JComboBox<String>();
		for(TypeDeCarte t : Carte.TypeDeCarte.values())
			comboBox.addItem(t.name());
		panel.add(comboBox);
		
		btnRechercher = new JButton("RECHERCHER");
		btnRechercher.addActionListener(new Rechercher());
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fenetre.dispose();
			}
		});
		panel.add(btnRetour);
		panel.add(btnRechercher);
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.EAST);
	}
	
	class Rechercher implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String num = numero.getText();
			if(num != null && !num.isEmpty()){
				if(Utils.isInteger(num)){
					ArrayList<Integer> nums = new ArrayList<>();
					nums.add(Integer.parseInt(num));
					new FenetreConsulter(collection,nums);
					fenetre.dispose();
				}
				else
					erreur.setVisible(true);
			}
			else
			{
				int type = comboBox.getSelectedIndex();
				new FenetreConsulter(collection,collection.rechercher_par_type(Carte.TypeDeCarte.values()[type].name()));
				fenetre.dispose();
			}
		}
		
	}
}
