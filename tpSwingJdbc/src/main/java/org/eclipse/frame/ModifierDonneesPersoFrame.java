package org.eclipse.frame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.dao.UtilisateurDaoImpl;
import org.eclipse.model.Utilisateur;
import javax.swing.JPanel;

public class ModifierDonneesPersoFrame extends JFrame {
	JLabel nomActuel = new JLabel("Nom actuel : ");
	JLabel nomActuelText = new JLabel();
	JLabel prenomActuel = new JLabel("Prénom actuel : ");
	JLabel prenomActuelText = new JLabel();
	JLabel sexeActuel = new JLabel("Sexe : ");
	JLabel sexeActuelText = new JLabel();
	JLabel nomLabel = new JLabel("Nouveau nom : ");
	JTextField nomText = new JTextField();
	JLabel prenomLabel = new JLabel("Nouveau prénom : ");
	JTextField prenomText = new JTextField();
	JLabel sexeLabel = new JLabel("Sexe : ");
	String[] sexeStrings = { "féminin", "masculin" };
	JComboBox<String> sexeBox = new JComboBox<String>(sexeStrings);
	JButton modifButton = new JButton("Modifier mes données");

	public ModifierDonneesPersoFrame(Utilisateur utilisateur) {
		setVisible(true);
		getContentPane().setLayout(null);
		setTitle("Modifier mes données personnelles");
		setSize(500, 500);

		add(nomActuel);
		nomActuel.setBounds(20, 20, 100, 20);
		add(prenomActuel);
		prenomActuel.setBounds(20, 60, 100, 20);
		add(sexeActuel);
		sexeActuel.setBounds(20, 100, 100, 20);

		add(nomActuelText);
		nomActuelText.setBounds(120, 20, 100, 20);
		add(prenomActuelText);
		prenomActuelText.setBounds(120, 60, 100, 20);
		add(sexeActuelText);
		sexeActuelText.setBounds(120, 100, 100, 20);

		add(nomLabel);
		nomLabel.setBounds(240, 20, 100, 20);
		add(prenomLabel);
		prenomLabel.setBounds(240, 60, 150, 20);
		add(sexeLabel);
		sexeLabel.setBounds(240, 100, 100, 20);

		add(nomText);
		nomText.setBounds(360, 20, 100, 20);
		add(prenomText);
		prenomText.setBounds(360, 60, 100, 20);
		add(sexeBox);
		sexeBox.setBounds(360, 100, 100, 20);

		add(modifButton);
		modifButton.setBounds(300, 140, 150, 20);

		nomActuelText.setText(utilisateur.getNom());
		prenomActuelText.setText(utilisateur.getPrenom());
		if (utilisateur.getSexe().equals("f")) {
			sexeActuelText.setText("Féminin");
		} else {
			sexeActuelText.setText("Masculin");
		}

		nomText.setText(utilisateur.getNom());
		prenomText.setText(utilisateur.getPrenom());
		if (utilisateur.getSexe().equals("m")==true) {
			sexeBox.setSelectedItem("masculin");
		}
		else { sexeBox.setSelectedItem("féminin");
		}
		
		
		modifButton.addActionListener((envoiModif) -> {

			UtilisateurDaoImpl daoUserImpl = new UtilisateurDaoImpl();
			utilisateur.setNom(nomText.getText());
			utilisateur.setPrenom(prenomText.getText());
			if (sexeBox.getSelectedItem().equals("féminin") == true) {
				utilisateur.setSexe("f");
			} else {
				utilisateur.setSexe("m");
			}
			daoUserImpl.update(utilisateur);
			this.dispose();
			JOptionPane.showMessageDialog(null, "Modifications effectuées");
			GestionSimpleFrame gestionSimpleFrame = new GestionSimpleFrame(utilisateur);
		}

		);
	}}
