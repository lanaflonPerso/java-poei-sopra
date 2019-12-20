package org.eclipse.test;

import java.util.Arrays;

public class Personne {
	private String nom;
	private char sexe;
	private Adresse[] adresses;

	public Personne(String nom, char sexe, Adresse[] adresses) {
		super();
		this.nom = nom;
		this.sexe = sexe;
		this.adresses = adresses;
	}

	public Personne() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public Adresse[] getAdresses() {
		return adresses;
	}

	public void setAdresses(Adresse[] adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", sexe=" + sexe + ", adresses=" + Arrays.toString(adresses) + "]";
	}

}
