package org.eclipse.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

import javax.swing.JButton;
import java.awt.Color;

public class SupprimerPersonneFrame extends JFrame implements KeyListener{
	private JTextField idText;
	JLabel idLabel = new JLabel("Identifiant :");
	JButton supprimerButton = new JButton("Supprimer");

	
	public SupprimerPersonneFrame() {
		setTitle("Suppresion");
		setLayout(null);
		setVisible(true);
		setSize(500, 500);

		idLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		idLabel.setBounds(55, 51, 111, 31);
		add(idLabel);
		idText = new JTextField();
		idText.setBounds(162, 51, 111, 30);
		add(idText);
		idText.setColumns(10);
		idText.addKeyListener(this);

	
		supprimerButton.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		supprimerButton.setBounds(162, 120, 111, 31);
		add(supprimerButton);
		supprimerButton.setEnabled(false);
		supprimerButton.addActionListener((e) -> {
			PersonneDaoImpl daoImpl = new PersonneDaoImpl();
			int num = Integer.parseInt(idText.getText());
			Personne personne = daoImpl.findById(num);
			
			if (personne != null) {
				daoImpl.remove(personne);
				JOptionPane.showMessageDialog(null, "Personne supprimée");
			} else {
				JOptionPane.showMessageDialog(null, "Personne introuvable");
			}
			idText.setText("");
			supprimerButton.setEnabled(false);
		});
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!idText.getText().isEmpty()) {
			supprimerButton.setEnabled(true);
		}
		else {
			supprimerButton.setEnabled(false);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!idText.getText().isEmpty()) {
			supprimerButton.setEnabled(true);
		}
		else {
			supprimerButton.setEnabled(false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!idText.getText().isEmpty()) {
			supprimerButton.setEnabled(true);
		}
		else {
			supprimerButton.setEnabled(false);
		}
	}
}
