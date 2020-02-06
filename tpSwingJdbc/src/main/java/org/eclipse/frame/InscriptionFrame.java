package org.eclipse.frame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.eclipse.dao.UtilisateurDaoImpl;
import org.eclipse.model.Utilisateur;

public class InscriptionFrame extends JFrame implements KeyListener {
	JLabel nomLabel = new JLabel("Nom d'utilisateur : ");
	JTextField nomText = new JTextField();
	JLabel prenomLabel = new JLabel("Prénom : ");
	JTextField prenomText = new JTextField();
	String [] sexeStrings = {"féminin", "masculin"};
	JComboBox<String> sexeBox = new JComboBox<String>(sexeStrings);
	JButton inscriptionButton = new JButton("Inscription");

	public InscriptionFrame() {
		setVisible(true);
		setTitle("Inscription");
		setLayout(null);
		setLocationRelativeTo(null);
		setSize(500, 500);

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
		sexeBox.setBounds(20, 100, 100,20);
		add(inscriptionButton);
		inscriptionButton.setBounds(140, 100, 100, 20);
		inscriptionButton.setEnabled(false);

		inscriptionButton.addActionListener((e) -> {
			UtilisateurDaoImpl daoUserImpl = new UtilisateurDaoImpl();
			Utilisateur inscriptionUser = new Utilisateur();
			inscriptionUser.setNom(nomText.getText());
			inscriptionUser.setPrenom(prenomText.getText());
			if (sexeBox.getSelectedItem().equals("féminin")) {
				inscriptionUser.setSexe("f");
			}
			else {
				inscriptionUser.setSexe("m");
			}
			inscriptionUser.setType("s");
			daoUserImpl.save(inscriptionUser);
			this.dispose();
			new ConnexionFrame();
		});
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if ((!nomText.getText().isEmpty()) && (!prenomText.getText().isEmpty())) {
			inscriptionButton.setEnabled(true);
		} else {
			inscriptionButton.setEnabled(false);
		}
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if ((!nomText.getText().isEmpty()) && (!prenomText.getText().isEmpty())) {
			inscriptionButton.setEnabled(true);
		} else {
			inscriptionButton.setEnabled(false);
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if ((!nomText.getText().isEmpty()) && (!prenomText.getText().isEmpty())) {
			inscriptionButton.setEnabled(true);
		} else {
			inscriptionButton.setEnabled(false);
		}
	}

}
