package org.eclipse.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.eclipse.dao.UtilisateurDaoImpl;
import org.eclipse.model.Utilisateur;

public class GestionAdministrateurFrame extends JFrame {
	JLabel messageBienvenue = new JLabel();
	JButton modifDonneesButton = new JButton("Modifier mes données personnelles");
	JButton supprButton = new JButton("Supprimer mon compte");
	JButton createUserButton = new JButton("Ajouter un utilisateur");
	JButton modifUserButton = new JButton("Modifier ou supprimer un utilisateur");

	public GestionAdministrateurFrame(Utilisateur utilisateur) {
		setVisible(true);
		setLayout(null);
		setSize(700, 200);
		setTitle("Espace Personnel - Administrateur ");
		setLocationRelativeTo(null);

		add(messageBienvenue);
		messageBienvenue.setBounds(100, 20, 300, 20);
		messageBienvenue.setText("Bienvenue " + utilisateur.getPrenom() + " " + utilisateur.getNom());

		add(modifDonneesButton);
		modifDonneesButton.setBounds(20, 60, 200, 20);
		add(supprButton);
		supprButton.setBounds(250, 60, 200, 20);
		add(createUserButton);
		createUserButton.setBounds(20, 100, 200, 20);
		add(modifUserButton);
		modifUserButton.setBounds(250, 100, 200, 20);

		modifDonneesButton.addActionListener((modifDonnees) -> {
			ModifierDonneesPersoFrame modifierDonnees = new ModifierDonneesPersoFrame(utilisateur);
			this.dispose();
		});

		supprButton.addActionListener((suppr) -> {
			UtilisateurDaoImpl userDaoImpl = new UtilisateurDaoImpl();
			userDaoImpl.remove(utilisateur);
			JOptionPane.showMessageDialog(null, "Votre compte a bien été supprimé.");
			this.dispose();
			ConnexionFrame connexionFrame = new ConnexionFrame();
		});

		createUserButton.addActionListener((add) -> {
			AjouterUtilisateurFrame ajouterUtilisateurFrame = new AjouterUtilisateurFrame();
			this.dispose();
		});

	}

}
