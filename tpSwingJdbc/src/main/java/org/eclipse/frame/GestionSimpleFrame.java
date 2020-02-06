package org.eclipse.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.eclipse.dao.UtilisateurDaoImpl;
import org.eclipse.model.Utilisateur;

public class GestionSimpleFrame extends JFrame {
	JLabel messageBienvenue = new JLabel();
	JButton modifierButton = new JButton("Modifier mes données personnelles");
	JButton supprimerButton = new JButton("Supprimer mon compte");

	public GestionSimpleFrame(Utilisateur utilisateur) {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setSize(500, 320);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Espace personnel");

		add(messageBienvenue);
		messageBienvenue.setBounds(100, 20, 300, 20);
		messageBienvenue.setText("Bienvenue " + utilisateur.getPrenom() + " " + utilisateur.getNom());
		messageBienvenue.setBackground(getBackground());
		add(modifierButton);
		modifierButton.setBounds(20, 60, 300, 20);
		add(supprimerButton);
		supprimerButton.setBounds(20, 100, 300, 20);

		modifierButton.addActionListener((modif) -> {
			ModifierDonneesPersoFrame modifierDonnees = new ModifierDonneesPersoFrame(utilisateur);
			this.dispose();
		});

		supprimerButton.addActionListener((suppr) -> {
			UtilisateurDaoImpl userDaoImpl = new UtilisateurDaoImpl();
			userDaoImpl.remove(utilisateur);
			JOptionPane.showMessageDialog(null, "Votre compte a bien été supprimé.");
			this.dispose();
			ConnexionFrame connexionFrame = new ConnexionFrame();
		}

		);
	}

}
