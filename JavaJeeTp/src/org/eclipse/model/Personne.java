package org.eclipse.model;

public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private char sexe;

	public Personne() {
	}

	public Personne(int id) {
		this.id = id;
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(String nom, String prenom, char sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}

	public Personne(int id, String nom, String prenom, char sexe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + "]";
	}

}
