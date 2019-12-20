package org.eclipse.model;


public class Enseignant extends Personne {
	private int salaire;

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	public Enseignant(int num, String nom, String prenom, Adresse adresse, int salaire) {
		super(num, nom, prenom, adresse);
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return super.toString() + "Enseignant [salaire=" + salaire + "]";
	}

}
