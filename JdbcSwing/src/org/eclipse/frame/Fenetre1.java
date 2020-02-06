package org.eclipse.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

public class Fenetre1 extends JFrame implements ActionListener, KeyListener {
	JLabel nomLabel = new JLabel("Nom : ");
	JLabel prenomLabel = new JLabel("Prénom : ");
	JTextField nomText = new JTextField();
	JTextField prenomText = new JTextField();
	JButton ajouterButton = new JButton("Ajouter");

	public Fenetre1() {
		setVisible(true);
		setSize(500, 500);
		setTitle("Ma première fenêtre");
		nomLabel.setBounds(20, 20, 100, 20);
		nomText.setBounds(140, 20, 100, 20);
		prenomLabel.setBounds(20, 60, 100, 20);
		prenomText.setBounds(140, 60, 100, 20);
		ajouterButton.setBounds(140, 100, 100, 20);

		add(nomLabel);
		add(nomText);
		nomText.addKeyListener(this);
		prenomText.addKeyListener(this);
		add(prenomLabel);
		add(prenomText);
		add(ajouterButton);
		setLayout(null);
		ajouterButton.addActionListener(this);
		ajouterButton.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Personne personne = new Personne(nomText.getText(), prenomText.getText());
		PersonneDaoImpl daoImpl = new PersonneDaoImpl();
		var insertedPersonne = daoImpl.save(personne);

		if (insertedPersonne != null) {
			JOptionPane.showMessageDialog(null, "La personne a été ajoutée avec succès");
		} else {
			JOptionPane.showMessageDialog(null, "Oups, problème lors de l'insertion.");
		}
		prenomText.setText("");
		nomText.setText("");
		ajouterButton.setEnabled(false);
		daoImpl.getAll().forEach(System.out::println);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!(nomText.getText().isEmpty()) && !(prenomText.getText().isEmpty())) {
			ajouterButton.setEnabled(true);
		} else {
			ajouterButton.setEnabled(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!(nomText.getText().isEmpty()) && !(prenomText.getText().isEmpty())) {
			ajouterButton.setEnabled(true);
		} else {
			ajouterButton.setEnabled(false);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!(nomText.getText().isEmpty()) && !(prenomText.getText().isEmpty())) {
			ajouterButton.setEnabled(true);
		} else {
			ajouterButton.setEnabled(false);
		}
	}

}
