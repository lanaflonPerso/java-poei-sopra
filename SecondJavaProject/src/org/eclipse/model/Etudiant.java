package org.eclipse.model;

public class Etudiant extends Personne {
	private String niveau;

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Etudiant(int num, String nom, String prenom, Adresse adresse, String niveau) {
		super(num, nom, prenom, adresse);
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return super.toString() + "Etudiant [niveau=" + niveau + "]";
	}


}
