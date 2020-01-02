package org.eclipse.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fenetre2 extends JFrame implements ActionListener, KeyListener {
	JLabel xLabel = new JLabel("x : ");
	JTextField xTextField = new JTextField();
	JLabel yLabel = new JLabel("y : ");
	JTextField yTextField = new JTextField();
	JButton calculSommeButton = new JButton("somme");
	JButton calculSoustractionButton = new JButton("soustraction");
	JButton calculProduitButton = new JButton("produit");
	JButton calculDivisionButton = new JButton("division");
	JTextArea resArea = new JTextArea();

	public Fenetre2() {
		setVisible(true);
		setLayout(null);
		setTitle("Calcul de la somme");
		setSize(500, 220);
		add(xLabel);
		add(yLabel);
		add(xTextField);
		add(yTextField);
		add(calculSommeButton);
		add(calculSoustractionButton);
		add(calculProduitButton);
		add(calculDivisionButton);
		add(resArea);
		setLocationRelativeTo(null);

		xLabel.setBounds(20, 20, 100, 20);
		xTextField.setBounds(140, 20, 100, 20);
		yLabel.setBounds(20, 60, 40, 20);
		yTextField.setBounds(140, 60, 100, 20);
		calculSommeButton.setBounds(20, 100, 100, 20);
		calculSoustractionButton.setBounds(140, 100, 150, 20);
		calculProduitButton.setBounds(20, 140, 100, 20);
		calculDivisionButton.setBounds(140, 140, 150, 20);

//		resArea.setBounds(20, 140, 100, 20);
		resArea.setBackground(getBackground());
		calculSommeButton.addActionListener(this);
		calculSommeButton.setEnabled(false);
		calculSoustractionButton.addActionListener(this);
		calculSoustractionButton.setEnabled(false);
		calculProduitButton.addActionListener(this);
		calculProduitButton.setEnabled(false);
		calculDivisionButton.addActionListener(this);
		calculDivisionButton.setEnabled(false);
		xTextField.addKeyListener(this);
		yTextField.addKeyListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		var x = Integer.parseInt(xTextField.getText());
		var y = Integer.parseInt(yTextField.getText());
		int result = 0;
		if (e.getSource() == calculSommeButton) {
			result = x + y;
		}

		else if (e.getSource() == calculSoustractionButton) {
			result = x - y;
		}

		else if (e.getSource() == calculProduitButton) {
			result = x * y;
		} else if (e.getSource() == calculDivisionButton) {
			result = x / y;
		}

		Fenetre3 resultFenetre3 = new Fenetre3(result);
		resultFenetre3.resultArea.setText("" + result);
		this.dispose();

//	var result = x + y;if(e.getSource()==calculSommeButton)
//	{
//		System.out.println(result);
////			JOptionPane.showMessageDialog(null, x+y);
////			resArea.setText("" + result);
//		Fenetre3 resultFenetre3 = new Fenetre3(result);
////			resultFenetre3.resultArea.setText("" + result);			
//		this.dispose();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (!xTextField.getText().isEmpty() && !yTextField.getText().isEmpty()) {
			calculSommeButton.setEnabled(true);
			calculSoustractionButton.setEnabled(true);
			calculProduitButton.setEnabled(true);
			if (yTextField.getText().equals("0")==false) {
				calculDivisionButton.setEnabled(true);
				}
		} else {
			calculSommeButton.setEnabled(false);
			calculSoustractionButton.setEnabled(false);
			calculProduitButton.setEnabled(false);
			calculDivisionButton.setEnabled(false);

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!xTextField.getText().isEmpty() && !yTextField.getText().isEmpty()) {
			calculSommeButton.setEnabled(true);
			calculSoustractionButton.setEnabled(true);
			calculProduitButton.setEnabled(true);
			if (yTextField.getText().equals("0")==false) {
			calculDivisionButton.setEnabled(true);
			}
		} else {
			calculSommeButton.setEnabled(false);
			calculSoustractionButton.setEnabled(false);
			calculProduitButton.setEnabled(false);
			calculDivisionButton.setEnabled(false);

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!xTextField.getText().isEmpty() && !yTextField.getText().isEmpty()) {
			calculSommeButton.setEnabled(true);
			calculSoustractionButton.setEnabled(true);
			calculProduitButton.setEnabled(true);
			if (yTextField.getText().equals("0")==false) {
				calculDivisionButton.setEnabled(true);
				};
		} else {
			calculSommeButton.setEnabled(false);
			calculSoustractionButton.setEnabled(false);
			calculProduitButton.setEnabled(false);
			calculDivisionButton.setEnabled(false);

		}
	}

}
