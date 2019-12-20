package org.eclipse.model;

import org.eclipse.interfaces.IMiseEnForme;

public class Personne implements IMiseEnForme {
	private int num;
	private String nom;
	private String prenom;
	private Adresse adresse;
	private static int nbrPersonnes;

	public Personne(int num, String nom, String prenom, Adresse adresse) {

		setNum(num);
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		nbrPersonnes++;
	}

	public Personne() {
		nbrPersonnes++;
	}

	public static int getNbrPersonnes() {
		return nbrPersonnes;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if (num > 0) {
			this.num = num;
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Personne [num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}

	@Override
	public void afficherNomMajuscule() {
		System.out.println(nom.toUpperCase());
	}

	@Override
	public void afficherPrenomMajuscule() {
		System.out.println(prenom.toUpperCase());
	}

}
