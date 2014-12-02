package interfaceGraphique;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Recherche extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Recherche frame = new Recherche();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Recherche() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("RECHERCHER UNE CARTE");
		this.setSize(500, 200);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 2, 10, 20));
		JLabel lblNumero = new JLabel("Numero de la carte : ");
		panel.add(lblNumero);	
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(5);		
		JLabel lblTypeDeCarte = new JLabel("Type de carte : ");
		panel.add(lblTypeDeCarte);		
		JComboBox<String> comboBox = new JComboBox<String>();
		String[] liste = {"test 1", "test 2"};
		comboBox.addItem("lqlalalal");
		panel.add(comboBox);
		panel.add(new JPanel());
		panel.add(new JPanel());
		panel.add(new JPanel());		
		JButton btnRechercher = new JButton("RECHERCHER");
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
}
