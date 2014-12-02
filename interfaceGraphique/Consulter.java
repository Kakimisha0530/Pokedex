package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

public class Consulter extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		Consulter frame = new Consulter();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Consulter() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Consulter mes cartes");
		this.setSize(500, 600);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(2, 4, 0, 0));
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
		panel_1.add(new JPanel());
		JLabel edit = new JLabel(new ImageIcon("images/edit.png"));
		panel_1.add(edit);
		JLabel delete = new JLabel(new ImageIcon("images/del.png"));
		panel_1.add(delete);
		panel_1.add(new JPanel());
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(2, 4, 10, 10));
		
		JButton btnRetour = new JButton("RETOUR");
		panel_2.add(btnRetour);
		panel_2.add(new JPanel());
		panel_2.add(new JPanel());
		panel_2.add(new JPanel());
		panel_2.add(new JPanel());
		panel_2.add(new JPanel());
		panel_2.add(new JPanel());
		panel_2.add(new JPanel());
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel suivant = new JLabel(new ImageIcon("images/next.png"));
		panel_3.add(suivant);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel precedent = new JLabel(new ImageIcon("images/prev.png"));
		panel_4.add(precedent);
		precedent.setVisible(false);
	}

}
