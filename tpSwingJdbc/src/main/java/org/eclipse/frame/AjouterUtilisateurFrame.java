package org.eclipse.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.eclipse.dao.UtilisateurDaoImpl;
import org.eclipse.model.Utilisateur;

public class AjouterUtilisateurFrame extends JFrame implements KeyListener {
	JLabel nomLabel = new JLabel("Nom d'utilisateur : ");
	JTextField nomText = new JTextField();
	JLabel prenomLabel = new JLabel("Prénom : ");
	JTextField prenomText = new JTextField();
	String[] sexeStrings = { "féminin", "masculin" };
	JComboBox<String> sexeBox = new JComboBox<String>(sexeStrings);
	JButton ajoutButton = new JButton("Ajouter");

	public AjouterUtilisateurFrame() {

		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		add(nomLabel);
		nomLabel.setBounds(20, 20, 150, 20);
		add(nomText);
		nomText.setBounds(140, 20, 100, 20);
		nomText.addKeyListener(this);
		add(prenomLabel);
		prenomLabel.setBounds(20, 60, 100, 20);
		add(prenomText);
		prenomText.setBounds(140, 60, 100, 20);
		prenomText.addKeyListener(this);
		add(sexeBox);
		sexeBox.setBounds(20, 100, 100, 20);
		add(ajoutButton);
		ajoutButton.setBounds(140, 100, 100, 20);
		ajoutButton.setEnabled(false);

		ajoutButton.addActionListener((ajout) -> {
			String sexe;
			if (sexeBox.getSelectedItem().equals("féminin")) {
				sexe = "f";
			} else {
				sexe = "m";
			}
			Utilisateur addUser = new Utilisateur(nomText.getText(), prenomText.getText(), sexe, "s");
			UtilisateurDaoImpl daoUserImpl = new UtilisateurDaoImpl();
			daoUserImpl.save(addUser);
			if (addUser != null) {
				JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succès");
			}
		});

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if ((!nomText.getText().isEmpty()) && (!prenomText.getText().isEmpty())) {
			ajoutButton.setEnabled(true);
		} else {
			ajoutButton.setEnabled(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if ((!nomText.getText().isEmpty()) && (!prenomText.getText().isEmpty())) {
			ajoutButton.setEnabled(true);
		} else {
			ajoutButton.setEnabled(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if ((!nomText.getText().isEmpty()) && (!prenomText.getText().isEmpty())) {
			ajoutButton.setEnabled(true);
		} else {
			ajoutButton.setEnabled(false);
		}
	}

}
