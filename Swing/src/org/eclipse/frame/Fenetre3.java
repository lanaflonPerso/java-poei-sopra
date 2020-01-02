package org.eclipse.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Fenetre3 extends JFrame implements ActionListener {
	JTextArea resultArea = new JTextArea();
	JButton retourButton =new JButton("Retour");

	public Fenetre3(int resultat) { //version Achref : on crée un constructeur avec un paramètre de type int
		setVisible(true);
		setLayout(null);
		add(resultArea);
		add(retourButton);
		setSize(200, 150);
		resultArea.setBounds(20, 20, 100, 20);
		resultArea.setBackground(getBackground());
		retourButton.setBounds(20, 60, 100, 20);
		retourButton.addActionListener(this);
		setTitle("Résultat");
		resultArea.setEditable(false);
		setLocationRelativeTo(null);
		resultArea.setText("Résultat = " + resultat);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if (e.getSource()==retourButton) {
		this.dispose();
		Fenetre2 fenetre2 = new Fenetre2();
	}
		
	}

}
