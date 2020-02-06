package org.eclipse.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.eclipse.dao.UtilisateurDaoImpl;
import org.eclipse.model.Utilisateur;

public class ConnexionFrame extends JFrame implements KeyListener {
	JLabel nomLabel = new JLabel("Nom d'utilisateur : ");
	JTextField nomTextField = new JTextField();
	JLabel passwordLabel = new JLabel("Mot de passe : ");
	JTextField passwordText = new JTextField();
	JButton connexionButton = new JButton("Connexion");
	JButton inscriptionButton = new JButton("Incription");
	static int nbrConnexion = 0;

	public ConnexionFrame() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setSize(500, 200);
		setTitle("Connexion");

		add(nomLabel);
		nomLabel.setBounds(20, 20, 150, 20);
		add(nomTextField);
		nomTextField.setBounds(190, 20, 100, 20);
		nomTextField.addKeyListener(this);
		add(passwordLabel);
		passwordLabel.setBounds(20, 60, 150, 20);
		add(passwordText);
		passwordText.setBounds(190, 60, 100, 20);
		passwordText.addKeyListener(this);
		add(inscriptionButton);
		inscriptionButton.setBounds(370, 120, 100, 20);
		add(connexionButton);
		connexionButton.setBounds(20, 120, 100, 20);
		connexionButton.setEnabled(false);

		inscriptionButton.addActionListener((inscription) -> {
			InscriptionFrame inscriptionFrame = new InscriptionFrame();
			this.dispose();
		});
		
		connexionButton.addActionListener((connect) -> {
			nbrConnexion++;
			UtilisateurDaoImpl daoUserImpl = new UtilisateurDaoImpl();
			Utilisateur userTestConnexion = new Utilisateur();
			userTestConnexion = daoUserImpl.findByNomPrenom(nomTextField.getText(), passwordText.getText());
			if (userTestConnexion != null) {
				this.dispose();
				if (userTestConnexion.getType().equals("a")) {
					GestionAdministrateurFrame gestionAdmin = new GestionAdministrateurFrame(userTestConnexion);
				} else if (userTestConnexion.getType().equals("s")==true) {
					GestionSimpleFrame gestionSimple = new GestionSimpleFrame(userTestConnexion);
				}

			} else {
				nomTextField.setText(null);
				passwordText.setText(null);
				if (nbrConnexion == 3) {
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe érroné(s)");
				}
			}

		});

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (!(nomTextField.getText().isEmpty()) && !(passwordText.getText().isEmpty())) {
			connexionButton.setEnabled(true);
		} else {
			connexionButton.setEnabled(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!(nomTextField.getText().isEmpty()) && !(passwordText.getText().isEmpty())) {
			connexionButton.setEnabled(true);
		} else {
			connexionButton.setEnabled(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!(nomTextField.getText().isEmpty()) && !(passwordText.getText().isEmpty())) {
			connexionButton.setEnabled(true);
		} else {
			connexionButton.setEnabled(false);
		} // TODO Auto-generated method stub

	}

}
