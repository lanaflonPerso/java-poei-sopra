package org.eclipse.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Fenetre1 extends JFrame implements ActionListener {
	JLabel nomLabel = new JLabel("Nom : ");
	JTextField nomText = new JTextField();
	JButton afficherButton = new JButton("Afficher");

	public Fenetre1() {
		setVisible(true);
		setSize(500, 500);
		setTitle("Ma première fenêtre");
		nomLabel.setBounds(20, 20, 100, 20);
		nomText.setBounds(140, 20, 100, 20);
		afficherButton.setBounds(140, 60, 100, 20);

		add(nomLabel);
		add(nomText);
		add(afficherButton);
		setLayout(null);
		afficherButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource()==afficherButton); // pour spécifier de quel bouton il s'agit
		var nom = nomText.getText();
		System.out.println("Bonjour " + nom);
	}

}
